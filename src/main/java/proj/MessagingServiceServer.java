package proj;

import io.grpc.Server;
import proj.messaging.*;
import proj.subscribe.*;
import io.grpc.ServerBuilder;
import io.grpc.protobuf.services.ProtoReflectionService;

public class MessagingServiceServer {

    private final int port = 50051;
    private final Server server;

    public MessagingServiceServer() {
        // Cria uma instância de MessagingServiceImpl
        MessagingServiceImpl messagingService = new MessagingServiceImpl();
        SubscribeServiceImpl subscribeService = new SubscribeServiceImpl(messagingService);

        // Popula o cache temporário ao iniciar o servidor
        messagingService.messagingCache();
        System.out.println("Messaging cache populated.");
        subscribeService.loadSubscriptions();
        System.out.println("Subscribes cache populated.");
        // Constrói o servidor com os serviços
        this.server = ServerBuilder.forPort(port)
                .addService(messagingService)
                .addService(subscribeService)
                .addService(ProtoReflectionService.newInstance()) 
                .build();
    }

    public void start() throws Exception {
        server.start();
        System.out.println("Server started, listening on " + port);
        server.awaitTermination();
    }

    public static void main(String[] args) throws Exception {
        MessagingServiceServer server = new MessagingServiceServer();
        server.start();
    }
}
