package proj.messaging;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.*;
import java.util.concurrent.ConcurrentHashMap;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import messaging.MessagingServiceGrpc;
import messaging.Messaging.*;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class MessagingServiceImpl extends MessagingServiceGrpc.MessagingServiceImplBase {
    
    private final ConcurrentHashMap<String, QueueType> channelMap = new ConcurrentHashMap<>();
    private final ConcurrentHashMap<String, Integer> roundRobinIndex = new ConcurrentHashMap<>();
    private final String channelPath = "/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels";

    public ConcurrentHashMap<String, QueueType> getChannelMap() {
        return channelMap;
    }

    @Override
    public void newChannel(ChannelName request, StreamObserver<Message> responseObserver) {
        
        String channelName = request.getContent();
        QueueType queueType = request.getType();
        Path newChannelDir = Paths.get(channelPath, channelName);
        Path newChannelFile = Paths.get(newChannelDir.toString(), queueType.toString() + ".txt");
        Path newChannel = Paths.get(channelPath, channelName);

        try 
        {
            channelMap.put(channelName, queueType);
            // create directory and archive
            Files.createDirectory(newChannel);
            Files.write(newChannelFile, queueType.toString().getBytes(), StandardOpenOption.CREATE);

            Message response = Message.newBuilder()
                .setContent(String.format("Novo canal criado: %s, Tipo do canal: %s", channelName, queueType))
                .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
        } 
        catch (IOException e)
        {
            System.err.println("Erro ao criar novo canal: " + e.getMessage());
        }
    }

    @Override
    public void deleteChannel(QueueName request, StreamObserver<Message> responseObserver) {
        String channelName = request.getName(); // Nome do canal
        Path channelDir = Paths.get(channelPath, channelName);

        try {
            // Verificar se o diretório existe
            if (Files.exists(channelDir)) {
                // Deletar todo o conteúdo do diretório
                try (Stream<Path> paths = Files.list(channelDir)) {
                    paths.forEach(path -> {
                        try {
                            if (Files.isDirectory(path)) {
                                // Se for um diretório, deletar seu conteúdo recursivamente
                                deleteDirectoryContent(path);
                            } 
                            // Deletar o arquivo ou diretório
                            Files.delete(path);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
                }

                // Deletar o próprio diretório
                Files.delete(channelDir);

                // Remover a entrada do channelMap
                channelMap.remove(channelName);

                // Enviar a resposta
                Message response = Message.newBuilder()
                    .setContent("Canal removido: " + channelName)
                    .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            } else {
                // Diretório não encontrado
                Message response = Message.newBuilder()
                    .setContent("Canal não encontrado: " + channelName)
                    .build();
                responseObserver.onNext(response);
                responseObserver.onCompleted();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteDirectoryContent(Path directory) throws IOException {
        // Lista e exclui o conteúdo do diretório
        try (Stream<Path> paths = Files.list(directory)) {
            paths.forEach(path -> {
                try {
                    if (Files.isDirectory(path)) {
                        // Se for um diretório, chamar a função recursiva
                        deleteDirectoryContent(path);
                    }
                    // Deletar arquivo ou diretório
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void listChannels(Empty request, StreamObserver<ChannelList> responseObserver) {
        List<Channel> channelList = new ArrayList<>();
        for (Entry<String, QueueType> entry : channelMap.entrySet()) {
            String channelName = entry.getKey();
            String type = entry.getValue().toString();

            Path channelPath = Paths.get(this.channelPath, channelName);

            long pendingMessages = 0;
            try {
                pendingMessages = Files.list(channelPath)
                    .filter(p -> p.toString().endsWith(".txt"))
                    .count() - 1;  // Ajuste dependendo da lógica
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }

            pendingMessages = Math.max(pendingMessages, 0);

            Channel channel = Channel.newBuilder()
                .setName(channelName)
                .setType(type)
                .setPendingMessages(String.valueOf(pendingMessages))
                .build();
            channelList.add(channel);
        }

        ChannelList response = ChannelList.newBuilder()
            .addAllCanais(channelList)
            .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void sendOneMessage(MessageRequest request, StreamObserver<MessageResponse> responseObserver) {
        try {
            String channelName = request.getChannel();
            Path channelDir = Paths.get(channelPath, channelName);
    
            renameFilesSequentially(channelDir);
    
            int fileIndex = 0;
            Path filePath;
    
            do {
                String fileName = String.format("%02d.txt", fileIndex);
                filePath = channelDir.resolve(fileName);
                fileIndex++;
            } while (Files.exists(filePath));
    
            Files.write(filePath, request.getMessage().getBytes(), StandardOpenOption.CREATE_NEW);
    
            // Update the pending messages count in the global cache
            long pendingMessages = Files.list(channelDir)
                .filter(p -> p.toString().endsWith(".txt"))
                .count() - 1;
    
            pendingMessages = Math.max(pendingMessages, 0);
    
            QueueType queueType = channelMap.get(channelName);
            if (queueType != null) {
                channelMap.put(channelName, queueType); // update with current queueType
            }
    
            MessageResponse response = MessageResponse.newBuilder()
                    .setResponse("Nova mensagem criada: " + filePath.getFileName().toString())
                    .setContent(request.getMessage())
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
    
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }
    }

    @Override
    public void sendMultipleMessages(MessageList request, StreamObserver<MessageResponse> responseObserver) {
        String channelName = request.getChannelName();
        QueueType expectedType = request.getType();
        
        // Verifica se o canal existe
        if (!channelMap.containsKey(channelName)) {
            responseObserver.onError(Status.NOT_FOUND.withDescription("Channel not found.").asRuntimeException());
            return;
        }
        
        // Verifica se o tipo do canal corresponde ao tipo esperado
        QueueType actualType = channelMap.get(channelName);
        if (actualType != expectedType) {
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription("Channel type invalid.").asRuntimeException());
            return;
        }
        
        Path channelDir = Paths.get(channelPath, channelName);
        
        try {
            for (Message message : request.getMessagesList()) {
                int fileIndex = 0;
                Path filePath;
                do {
                    String fileName = String.format("%02d.txt", fileIndex);
                    filePath = channelDir.resolve(fileName);
                    fileIndex++;
                } while (Files.exists(filePath));
        
                // Salva a mensagem no arquivo
                Files.write(filePath, message.getContent().getBytes(), StandardOpenOption.CREATE_NEW);
            }
            
            // Atualiza o número de mensagens pendentes no canal
            long pendingMessages = Files.list(channelDir)
                .filter(p -> p.toString().endsWith(".txt"))
                .count() - 1;
        
            // Atualiza o channelMap com as mensagens pendentes
            channelMap.put(channelName, actualType); 

            // Cria a resposta com informações do canal e mensagens recebidas
            MessageResponse response = MessageResponse.newBuilder()
                    .setResponse("Messages sent successfully")
                    .setContent("Channel: " + channelName + ", Type: " + actualType + ", Messages Count: " + request.getMessagesCount())
                    .build();
            
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(Status.INTERNAL.withDescription("Failed to save messages").withCause(e).asRuntimeException());
        }
    }

    @Override
    public void receiveSingleMessage(QueueName request, StreamObserver<Message> responseObserver) {
        String channelName = request.getName();
        QueueType queueType = channelMap.get(channelName);

        if (queueType != null) {
            Path channelDir = Paths.get(channelPath, channelName);

            try {
                // Obtém a lista de arquivos de mensagens ordenados pelo nome (menor primeiro)
                List<Path> messageFiles = Files.list(channelDir)
                    .filter(p -> p.toString().endsWith(".txt"))
                    .filter(p -> {
                        // Filtra arquivos que têm nomes numéricos
                        String fileName = p.getFileName().toString().replace(".txt", "");
                        try {
                            Integer.parseInt(fileName);
                            return true;
                        } catch (NumberFormatException e) {
                            return false;
                        }
                    })
                    .sorted(Comparator.comparing(p -> Integer.parseInt(p.getFileName().toString().replace(".txt", ""))))
                    .collect(Collectors.toList());

                if (messageFiles.isEmpty()) {
                    // Se não houver mensagens, espera até que uma mensagem esteja disponível ou timeout
                    synchronized (this) {
                        this.wait(10000); // Timeout de 10 segundos
                    }

                    messageFiles = Files.list(channelDir)
                        .filter(p -> p.toString().endsWith(".txt"))
                        .filter(p -> {
                            // Filtra arquivos que têm nomes numéricos
                            String fileName = p.getFileName().toString().replace(".txt", "");
                            try {
                                Integer.parseInt(fileName);
                                return true;
                            } catch (NumberFormatException e) {
                                return false;
                            }
                        })
                        .sorted(Comparator.comparing(p -> Integer.parseInt(p.getFileName().toString().replace(".txt", ""))))
                        .collect(Collectors.toList());

                    if (messageFiles.isEmpty()) {
                        responseObserver.onNext(Message.newBuilder()
                                .setContent("Timeout: Nenhuma mensagem disponível no canal " + channelName)
                                .build());
                    } else {
                        Path path = messageFiles.get(0);
                        String msg = new String(Files.readAllBytes(path));
                        Files.delete(path);
                        responseObserver.onNext(Message.newBuilder()
                                .setContent(msg)
                                .build());
                    }
                    responseObserver.onCompleted();
                } else {
                    Path path = messageFiles.get(0);
                    String msg = new String(Files.readAllBytes(path));
                    Files.delete(path);
                    responseObserver.onNext(Message.newBuilder()
                            .setContent(msg)
                            .build());
                    responseObserver.onCompleted();
                }
            } catch (IOException | InterruptedException e) {
                responseObserver.onError(e);
            }
        } else {
            responseObserver.onError(new Throwable("Canal não encontrado: " + channelName));
        }
    }


    @Override
    public void streamMessages(QueueName request, StreamObserver<Message> responseObserver) {
        String channelName = request.getName();
        QueueType queueType = channelMap.get(channelName);
        Path channelDir = Paths.get(channelPath, channelName);

        if (queueType != null) {
            new Thread(() -> {
                try {
                    while (true) {
                        List<Path> messageFiles = Files.list(channelDir)
                            .filter(p -> p.toString().endsWith(".txt"))
                            .sorted(Comparator.comparing(p -> Integer.parseInt(p.getFileName().toString().replace(".txt", ""))))
                            .collect(Collectors.toList());

                        if (!messageFiles.isEmpty()) {
                            Path path = messageFiles.get(0);
                            String msg = new String(Files.readAllBytes(path));
                            Files.delete(path);
                            responseObserver.onNext(Message.newBuilder()
                                    .setContent(msg)
                                    .build());
                        } else {
                            synchronized (this) {
                                this.wait(10000); // Timeout de 10 segundos
                            }
                        }
                    }
                } catch (IOException | InterruptedException e) {
                    responseObserver.onError(e);
                }
            }).start();
        } else {
            responseObserver.onError(new Throwable("Canal não encontrado: " + channelName));
        }
    }




    @Override
    public void receiveMessages(QueueName request, StreamObserver<Message> responseObserver) {
        String channelName = request.getName();
        QueueType queueType = request.getType();

        System.out.println("Recebendo mensagens para o canal: " + channelName + " com tipo: " + queueType);

        Path channelDir = Paths.get(channelPath, channelName);

        try {
            // Obtém a lista de arquivos de mensagens ordenados pelo nome (menor primeiro)
            List<Path> messageFiles = Files.list(channelDir)
                .filter(p -> p.toString().endsWith(".txt") && !p.getFileName().toString().equals("SIMPLES.txt") && !p.getFileName().toString().equals("MULTIPLO.txt"))
                .sorted(Comparator.comparing(p -> Integer.parseInt(p.getFileName().toString().replace(".txt", ""))))
                .collect(Collectors.toList());

            if (messageFiles.isEmpty()) {
                System.out.println("Sem arquivos");
                responseObserver.onCompleted();
                return;
            }

            // Lê apenas o menor arquivo (o primeiro na lista)
            Path path = messageFiles.get(0);
            String msg = new String(Files.readAllBytes(path));

            List<String> subscribers = getSubscribers(channelName, queueType);

            if (queueType == QueueType.SIMPLES) {
                // Round-Robin para canais SIMPLES
                int index = roundRobinIndex.getOrDefault(channelName, 0);
                if (subscribers != null && !subscribers.isEmpty()) {
                    System.out.println("Entrou no tipo simples diferente de nulo");
                    String subscriber = subscribers.get(index % subscribers.size());
                    Message response = Message.newBuilder()
                            .setContent("Channel: " + channelName + ", Subscriber: " + subscriber + ", Message: " + msg)
                            .build();
                    responseObserver.onNext(response);
                    roundRobinIndex.put(channelName, (index + 1) % subscribers.size());
                    Files.delete(path);
                }
            } else if (queueType == QueueType.MULTIPLO) {
                // Envia a mensagem para todos os assinantes
                if (subscribers != null) {
                    System.out.println("SUbscribers: " + subscribers);
                    System.out.println("ENtrou no tipo multiplo diferente de nulo");
                    for (String subscriber : subscribers) {
                        Message response = Message.newBuilder()
                                .setContent("Channel: " + channelName + ", Subscriber: " + subscriber + ", Message: " + msg)
                                .build();
                        responseObserver.onNext(response);
                    }
                    Files.delete(path);
                }
            }
            
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(e);
        }

        responseObserver.onCompleted();
    }

    public List<String> getSubscribers(String channelName, QueueType channelType) {
        List<String> subscribers = new ArrayList<>();
        String fileName = channelPath + "/" + channelName + "_" + channelType.name() + ".txt";
    
        System.out.println("Buscando assinantes no arquivo: " + fileName);
    
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                subscribers.add(line);
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de assinantes: " + e.getMessage());
            return subscribers; // Retorna
        }
        return subscribers;
    }


    public void renameFilesSequentially(Path directoryPath) throws IOException {
        List<Path> txtFiles = Files.list(directoryPath)
            .filter(p -> {
                String fileName = p.getFileName().toString();
                return p.toString().endsWith(".txt") && 
                       !(fileName.equals("MULTIPLO.txt") || fileName.equals("SIMPLES.txt"));
            })
            .sorted()
            .collect(Collectors.toList());
    
        for (int i = 0; i < txtFiles.size(); i++) {
            Path currentFile = txtFiles.get(i);
            String newFileName = String.format("%02d.txt", i);
            Path newFilePath = directoryPath.resolve(newFileName);
    
            if (!currentFile.getFileName().toString().equals(newFileName)) {
                Files.move(currentFile, newFilePath, StandardCopyOption.REPLACE_EXISTING);
            }
        }
    }

    public void messagingCache() {
        Path baseDir = Paths.get(channelPath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(baseDir)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    Path simplesFile = entry.resolve("SIMPLES.txt");
                    Path multiploFile = entry.resolve("MULTIPLO.txt");
    
                    String type = "";
                    if (Files.exists(simplesFile)) {
                        type = "SIMPLES";
                    } else if (Files.exists(multiploFile)) {
                        type = "MULTIPLO";
                    }
    
                    long pendingMessages = Files.list(entry)
                        .filter(p -> p.toString().endsWith(".txt"))
                        .count() - (Files.exists(simplesFile) || Files.exists(multiploFile) ? 1 : 0);
    
                    pendingMessages = Math.max(pendingMessages, 0);

                        // Adiciona ao channelMap
                    if (!type.isEmpty()) {
                        channelMap.put(entry.getFileName().toString(), QueueType.valueOf(type));
                        //System.out.println("Adicionado ao channelMap: " + entry.getFileName() + " -> " + type);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
