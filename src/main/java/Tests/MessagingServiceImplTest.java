package Tests;

/*import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import messaging.Messaging.*;
import proj.messaging.MessagingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MessagingServiceImplTest {
    
    private MessagingServiceImpl messagingService;
    private StreamObserver<Message> messageObserver;
    private StreamObserver<MessageResponse> messageResponseObserver;

    @BeforeEach
    void setUp() {
        messagingService = new MessagingServiceImpl();
        messageObserver = mock(StreamObserver.class);
        messageResponseObserver = mock(StreamObserver.class);
    }

    @Test
    void testNewChannel() throws IOException {
        ChannelName request = ChannelName.newBuilder()
                .setContent("testChannel")
                .setType(QueueType.SIMPLES)
                .build();

        messagingService.newChannel(request, messageObserver);

        verify(messageObserver).onNext(Message.newBuilder()
                .setContent("Novo canal criado: testChannel, Tipo do canal: SIMPLES")
                .build());
        verify(messageObserver).onCompleted();
        
        // Verificar se o canal foi criado
        assertTrue(Files.exists(Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels/testChannel")));
        assertTrue(Files.exists(Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels/testChannel/SIMPLES.txt")));
    }

    @Test
    void testDeleteChannel() throws IOException {
        String channelName = "testChannel";
        Path channelDir = Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels", channelName);
        Files.createDirectory(channelDir);
        Files.createFile(channelDir.resolve("SIMPLES.txt"));

        QueueName request = QueueName.newBuilder().setName(channelName).build();
        messagingService.deleteChannel(request, messageObserver);

        verify(messageObserver).onNext(Message.newBuilder().setContent("Canal removido: testChannel").build());
        verify(messageObserver).onCompleted();

        assertFalse(Files.exists(channelDir));
    }

    @Test
    void testListChannels() throws IOException {
        // Setup channel map
        messagingService.getChannelMap().put("testChannel", QueueType.SIMPLES);
        Path channelDir = Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels", "testChannel");
        Files.createDirectory(channelDir);
        Files.createFile(channelDir.resolve("01.txt"));

        Empty request = Empty.newBuilder().build();
        StreamObserver<ChannelList> channelListObserver = mock(StreamObserver.class);
        
        messagingService.listChannels(request, channelListObserver);

        verify(channelListObserver).onNext(ChannelList.newBuilder()
                .addCanais(Channel.newBuilder()
                        .setName("testChannel")
                        .setType("SIMPLES")
                        .setPendingMessages("0")
                        .build())
                .build());
        verify(channelListObserver).onCompleted();
    }

    @Test
    void testSendOneMessage() throws IOException {
        String channelName = "testChannel";
        Path channelDir = Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels", channelName);
        Files.createDirectory(channelDir);

        MessageRequest request = MessageRequest.newBuilder()
                .setChannel(channelName)
                .setMessage("Test Message")
                .build();

        messagingService.sendOneMessage(request, messageResponseObserver);

        verify(messageResponseObserver).onNext(MessageResponse.newBuilder()
                .setResponse("Nova mensagem criada: 00.txt")
                .setContent("Test Message")
                .build());
        verify(messageResponseObserver).onCompleted();
        
        // Check if the file was created
        assertTrue(Files.exists(channelDir.resolve("00.txt")));
    }

    @Test
    void testSendMultipleMessages() throws IOException {
        String channelName = "testChannel";
        Path channelDir = Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels", channelName);
        Files.createDirectory(channelDir);
        Files.createFile(channelDir.resolve("SIMPLES.txt"));

        Message message1 = Message.newBuilder().setContent("Message 1").build();
        Message message2 = Message.newBuilder().setContent("Message 2").build();

        MessageList request = MessageList.newBuilder()
                .setChannelName(channelName)
                .setType(QueueType.SIMPLES)
                .addMessages(message1)
                .addMessages(message2)
                .build();

        messagingService.sendMultipleMessages(request, messageResponseObserver);

        verify(messageResponseObserver).onNext(MessageResponse.newBuilder()
                .setResponse("Messages sent successfully")
                .setContent("Channel: testChannel, Type: SIMPLES, Messages Count: 2")
                .build());
        verify(messageResponseObserver).onCompleted();

        // Check if the files were created
        assertTrue(Files.exists(channelDir.resolve("00.txt")));
        assertTrue(Files.exists(channelDir.resolve("01.txt")));
    }

    @Test
    void testReceiveSingleMessage() throws IOException, InterruptedException {
        String channelName = "testChannel";
        Path channelDir = Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels", channelName);
        Files.createDirectory(channelDir);
        Files.write(channelDir.resolve("00.txt"), "Test Message".getBytes());

        QueueName request = QueueName.newBuilder().setName(channelName).build();
        StreamObserver<Message> responseObserver = mock(StreamObserver.class);

        messagingService.receiveSingleMessage(request, responseObserver);

        verify(responseObserver).onNext(Message.newBuilder().setContent("Test Message").build());
        verify(responseObserver).onCompleted();
        
        // Verify that the file was deleted
        assertFalse(Files.exists(channelDir.resolve("00.txt")));
    }

    @Test
    void testStreamMessages() throws IOException, InterruptedException {
        String channelName = "testChannel";
        Path channelDir = Paths.get("/home/kali/Desktop/distributed systems/proj/src/main/java/proj/Channels", channelName);
        Files.createDirectory(channelDir);
        Files.write(channelDir.resolve("00.txt"), "Test Stream Message".getBytes());

        QueueName request = QueueName.newBuilder().setName(channelName).build();
        StreamObserver<Message> responseObserver = mock(StreamObserver.class);

        messagingService.streamMessages(request, responseObserver);

        verify(responseObserver).onNext(Message.newBuilder().setContent("Test Stream Message").build());
        verify(responseObserver).onCompleted();
        
        // Verify that the file was deleted
        assertFalse(Files.exists(channelDir.resolve("00.txt")));
    }
}
*/