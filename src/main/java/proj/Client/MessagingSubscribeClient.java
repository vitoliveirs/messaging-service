package proj.Client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import messaging.*;
import messaging.Messaging.*;
import messaging.MessagingServiceGrpc.*;
import subscribe.SubscribeServiceGrpc.*;
import subscribe.Subscribe.QueueType;
import subscribe.Subscribe.ReturnList;
import subscribe.*;

public class MessagingSubscribeClient {

    private final MessagingServiceBlockingStub messagingStub;
    private final SubscribeServiceBlockingStub subscribeStub;

    public MessagingSubscribeClient(ManagedChannel channel) {
        messagingStub = MessagingServiceGrpc.newBlockingStub(channel);
        subscribeStub = SubscribeServiceGrpc.newBlockingStub(channel);
    }

    public void createChannel(String channelName, Messaging.QueueType type) {
        ChannelName request = ChannelName.newBuilder()
                .setContent(channelName)
                .setType(type)
                .build();

        Message response;
        try {
            response = messagingStub.newChannel(request);
            System.out.println("Channel Created: " + response.getContent());
        } catch (StatusRuntimeException e) {
            System.out.println("Error creating channel: " + e.getStatus());
        }
    }

    public void listChannels() {
        Messaging.Empty request = Messaging.Empty.newBuilder().build();

        try {
            ChannelList response = messagingStub.listChannels(request);
            System.out.println("Channels:");
            for (Channel channel : response.getCanaisList()) {
                System.out.println("- Name: " + channel.getName() +
                        ", Type: " + channel.getType() +
                        ", Pending Messages: " + channel.getPendingMessages());
            }
        } catch (StatusRuntimeException e) {
            System.out.println("Error listing channels: " + e.getStatus());
        }
    }

    public void subscribeToChannel(String channelName, QueueType type, String clientName) {
        Subscribe.ChannelType request = Subscribe.ChannelType.newBuilder()
                .setChannelName(channelName)
                .setChannelType(type)
                .setClientName(clientName)
                .build();
    
        try {
            Subscribe.Message response = subscribeStub.subscribe(request);
        } catch (StatusRuntimeException e) {
            System.out.println("Error ao se inscrever no canal: " + e.getStatus());
        }
    }

    public void sendOneMessage(String channelName, String messageContent) {
        MessageRequest request = MessageRequest.newBuilder()
                .setChannel(channelName)
                .setMessage(messageContent)
                .build();
        
        // Enviar a mensagem
        MessageResponse response = messagingStub.sendOneMessage(request);
    }
    
    public void sendMultipleMessages(String channelName, String[] messages) {
        MessageList.Builder messageListBuilder = MessageList.newBuilder();
        for (String message : messages) {
            messageListBuilder.addMessages(Message.newBuilder().setContent(message).build());
        }
        messageListBuilder.setChannelName(channelName);
        messageListBuilder.setType(Messaging.QueueType.SIMPLES); 

        MessageList request = messageListBuilder.build();

        MessageResponse response = messagingStub.sendMultipleMessages(request);
    }

    public void receiveSingleMessage(String channelName) {
        QueueName request = QueueName.newBuilder()
                .setName(channelName)
                .setType(Messaging.QueueType.SIMPLES) // ou MULTIPLO, conforme o tipo do canal
                .build();

        try {
            Message response = messagingStub.receiveSingleMessage(request);
            System.out.println("Mensagem recebida: " + response.getContent());
        } catch (StatusRuntimeException e) {
            System.out.println("Error receiving single message: " + e.getStatus());
        }
    }

    public void streamMessages(String channelName) {
        QueueName request = QueueName.newBuilder()
                .setName(channelName)
                .setType(Messaging.QueueType.SIMPLES) // ou MULTIPLO, conforme o tipo do canal
                .build();

        // Utiliza o stub do serviço Messaging
        StreamObserver<Message> responseObserver = new StreamObserver<Message>() {
            @Override
            public void onNext(Message message) {
                System.out.println("Mensagem recebida: " + message.getContent());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("Erro ao receber mensagens: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Stream de mensagens concluída.");
            }
        };

        try {
            messagingStub.streamMessages(request);
        } catch (StatusRuntimeException e) {
            System.out.println("Error streaming messages: " + e.getStatus());
        }
    }

    public void listSubscribers() {
        Subscribe.Empty request = Subscribe.Empty.newBuilder().build();
        ReturnList response;
    
        try {
            response = subscribeStub.listSubscribers(request);
            System.out.println("Assinantes:\n" + response.getAssinantes());
        } catch (StatusRuntimeException e) {
            System.err.println("Erro ao listar assinantes: " + e.getStatus());
        }
    }

    public void deleteChannel(String channelName) {
        QueueName request = QueueName.newBuilder()
                .setName(channelName)
                .setType(Messaging.QueueType.SIMPLES)
                .build();

        Message response;
        try {
            response = messagingStub.deleteChannel(request);
            System.out.println(response.getContent());
        } catch (StatusRuntimeException e) {
            System.out.println("Error deleting channel: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        String target = "localhost:50051";
        ManagedChannel channel = ManagedChannelBuilder.forTarget(target)
                .usePlaintext()
                .build();

        String clientName = "JavaClient"; 
        MessagingSubscribeClient client = new MessagingSubscribeClient(channel);

        try {
            // Passo 1: Criar um novo canal
            client.createChannel("TestChannelCLIENT01", Messaging.QueueType.SIMPLES);

            // Passo 2: Listar os canais disponíveis
            client.listChannels();

            // Passo 3: Enviar múltiplas mensagens para o canal
            String[] messages = {
                "Message 1",
                "Message 2",
                "Message 3"
            };
            client.sendMultipleMessages("TestChannelCLIENT01", messages);

            // Passo 4: Receber uma única mensagem do canal
            client.receiveSingleMessage("TestChannelCLIENT01");

            // Passo 5: Receber mensagens usando stream
            client.streamMessages("TestChannelCLIENT01");

            // Passo 6: Excluir um canal
            client.deleteChannel("TestChannelCLIENT01");

            // Listar os canais novamente após a exclusão
            client.listChannels();
        } finally {
            channel.shutdown();
        }
    }
}
