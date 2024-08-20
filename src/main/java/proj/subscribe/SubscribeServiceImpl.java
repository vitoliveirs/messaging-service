package proj.subscribe;

import io.grpc.stub.StreamObserver;
import proj.messaging.MessagingServiceImpl;
import subscribe.SubscribeServiceGrpc;
import subscribe.Subscribe.*;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.*;
import java.util.*;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SubscribeServiceImpl extends SubscribeServiceGrpc.SubscribeServiceImplBase {

    private final MessagingServiceImpl messagingService;
    private final String channelPath = "/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Subscribers";
    private final Map<String, QueueType> subscriptionMap = new ConcurrentHashMap<>();
    private final Gson gson = new Gson();
    private final Path subscribersFilePath = Paths.get(channelPath, "subscribers.json");

    public SubscribeServiceImpl(MessagingServiceImpl messagingService) {
        this.messagingService = messagingService;
    }

    @Override
    public void subscribe(ChannelType request, StreamObserver<Message> responseObserver) {
        String channelName = request.getChannelName();
        String channelType = request.getChannelType().name();
        String clientName = request.getClientName();

        // Criar um objeto JSON para o novo assinante
        JSONObject newSubscriber = new JSONObject();
        newSubscriber.put("channelName", channelName);
        newSubscriber.put("channelType", channelType);
        newSubscriber.put("clientName", clientName);

        // Caminho para o arquivo de assinantes
        String subscriberFilePath = "/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Subscribers/subscribers.json";
        File subscriberFile = new File(subscriberFilePath);

        try {
            // Ler o conteúdo existente do arquivo
            JSONArray subscriberList;
            if (subscriberFile.exists()) {
                String content = new String(Files.readAllBytes(subscriberFile.toPath()));
                subscriberList = new JSONArray(content);
            } else {
                subscriberList = new JSONArray();
            }

            // Verificar se o assinante já existe
            boolean alreadySubscribed = false;
            for (int i = 0; i < subscriberList.length(); i++) {
                JSONObject subscriber = subscriberList.getJSONObject(i);
                if (subscriber.getString("channelName").equals(channelName)
                        && subscriber.getString("clientName").equals(clientName)) {
                    alreadySubscribed = true;
                    break;
                }
            }

            // Se não estiver inscrito, adicionar ao arquivo
            if (!alreadySubscribed) {
                subscriberList.put(newSubscriber);

                // Escrever a lista de volta ao arquivo
                Files.write(subscriberFile.toPath(), subscriberList.toString(2).getBytes());
                System.out.println("Novo assinante registrado: " + clientName + " no canal " + channelName);
            } else {
                System.out.println(clientName + " já está inscrito no canal " + channelName);
            }

            // Retornar uma mensagem de sucesso
            Message response = Message.newBuilder()
                    .setContent("Inscrição bem-sucedida para o canal: " + channelName)
                    .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();

        } catch (IOException e) {
            System.err.println("Erro ao manipular o arquivo de assinantes: " + e.getMessage());
            responseObserver.onError(e);
        }
    }



    @Override
    public void unsubscribe(ChannelType request, StreamObserver<Message> responseObserver) {
        String channelName = request.getChannelName();
        QueueType channelType = request.getChannelType();
        String clientName = request.getClientName();

        // Cria uma chave combinando o nome do cliente, nome e tipo do canal
        String key = clientName + ":" + channelName + ":" + channelType;

        // Remove o canal do mapa de assinaturas
        if (subscriptionMap.remove(key) != null) {
            // Atualiza o cache ao remover a assinatura
            updateSubscribeCache();

            Message response = Message.newBuilder()
                .setContent("Desinscrito do canal: " + channelName + ", Tipo: " + channelType)
                .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } else {
            Message response = Message.newBuilder()
                .setContent("Não foi possível encontrar o canal para desinscrição: " + channelName + ", Tipo: " + channelType)
                .build();
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }

    @Override
    public void listSubscribers(Empty request, StreamObserver<ReturnList> responseObserver) {
        // Lista todos os assinantes
        String subscriberList = subscriptionMap.entrySet().stream()
                .map(entry -> "Canal: " + entry.getKey() + ", Tipo: " + entry.getValue())
                .collect(Collectors.joining("\n"));
        
        ReturnList response = ReturnList.newBuilder()
                .setAssinantes(subscriberList)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void saveSubscribe(String channelName, QueueType channelType, String clientName) {
        // Carrega as assinaturas existentes
        List<Subscription> subscriptions = subscribeCache();

        // Adiciona ou atualiza a assinatura
        subscriptions.add(new Subscription(channelName, channelType, clientName));

        // Escreve de volta para o arquivo
        try (FileWriter writer = new FileWriter(subscribersFilePath.toFile())) {
            gson.toJson(subscriptions, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateSubscribeCache() {
        // Recria o arquivo JSON com as assinaturas atuais
        List<Subscription> subscriptions = subscriptionMap.entrySet().stream()
                .map(entry -> {
                    String[] parts = entry.getKey().split(":");
                    return new Subscription(parts[1], entry.getValue(), parts[0]);
                })
                .collect(Collectors.toList());

        // Escreve de volta para o arquivo
        try (FileWriter writer = new FileWriter(subscribersFilePath.toFile())) {
            gson.toJson(subscriptions, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Subscription> subscribeCache() {
        // Garante que o arquivo existe e está inicializado com uma lista vazia, se necessário
        createFileIfNotExists();

        // Lê as assinaturas do arquivo JSON
        try (FileReader reader = new FileReader(subscribersFilePath.toFile())) {
            Type listType = new TypeToken<ArrayList<Subscription>>() {}.getType();
            List<Subscription> subscriptions = gson.fromJson(reader, listType);

            if (subscriptions == null) {
                subscriptions = new ArrayList<>();
            }

            return subscriptions;
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();  // Retorna uma lista vazia em caso de erro
        }
    }

    public void loadSubscriptions() {
        List<Subscription> subscriptions = subscribeCache();
        if (subscriptions != null) {
            subscriptions.forEach(sub -> {
                String key = sub.getClientName() + ":" + sub.getChannelName() + ":" + sub.getChannelType();
                subscriptionMap.put(key, sub.getChannelType());
            });
        }
    }

    private void createFileIfNotExists() {
        File file = subscribersFilePath.toFile();
        if (!file.exists()) {
            try {
                // Cria o arquivo e escreve uma lista vazia de assinaturas
                file.createNewFile();
                try (FileWriter writer = new FileWriter(file)) {
                    gson.toJson(new ArrayList<Subscription>(), writer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> getSubscribers(String channelName, QueueType queueType) {
        Path subscribersFile = Paths.get(channelPath, channelName, "subscribers.json");
        if (Files.exists(subscribersFile)) {
            try {
                String json = new String(Files.readAllBytes(subscribersFile));
                Type listType = new TypeToken<ArrayList<Subscriber>>() {}.getType();
                List<Subscriber> subscribersList = new Gson().fromJson(json, listType);

                // Filtra os assinantes com base no canal e tipo de canal
                List<String> subscribers = subscribersList.stream()
                        .filter(sub -> sub.getChannelName().equals(channelName) && sub.getChannelType() == queueType)
                        .map(Subscriber::getClientName)
                        .filter(name -> !name.isEmpty())
                        .collect(Collectors.toList());

                System.out.println("Subscritores para o canal " + channelName + ": " + subscribers);
                return subscribers;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Subscritores não encontrados ou erro ao ler o arquivo.");
        return Collections.emptyList();
    }

    class Subscriber {
        private String channelName;
        private QueueType channelType;
        private String clientName;

        public String getChannelName() {
            return channelName;
        }

        public QueueType getChannelType() {
            return channelType;
        }

        public String getClientName() {
            return clientName;
        }
    }

    // Classe interna para representar uma assinatura
    private static class Subscription {
        private String channelName;
        private QueueType channelType;
        private String clientName;

        public Subscription(String channelName, QueueType channelType, String clientName) {
            this.channelName = channelName;
            this.channelType = channelType;
            this.clientName = clientName;
        }

        public String getChannelName() {
            return channelName;
        }

        public QueueType getChannelType() {
            return channelType;
        }

        public String getClientName() {
            return clientName;
        }
    }
}
