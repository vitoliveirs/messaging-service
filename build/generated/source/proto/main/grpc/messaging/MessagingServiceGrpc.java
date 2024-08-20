package messaging;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
    comments = "Source: Messaging.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class MessagingServiceGrpc {

  private MessagingServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "messaging.MessagingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.ChannelName,
      messaging.Messaging.Message> getNewChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "NewChannel",
      requestType = messaging.Messaging.ChannelName.class,
      responseType = messaging.Messaging.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<messaging.Messaging.ChannelName,
      messaging.Messaging.Message> getNewChannelMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.ChannelName, messaging.Messaging.Message> getNewChannelMethod;
    if ((getNewChannelMethod = MessagingServiceGrpc.getNewChannelMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getNewChannelMethod = MessagingServiceGrpc.getNewChannelMethod) == null) {
          MessagingServiceGrpc.getNewChannelMethod = getNewChannelMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.ChannelName, messaging.Messaging.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "NewChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.ChannelName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.Message.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("NewChannel"))
              .build();
        }
      }
    }
    return getNewChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getDeleteChannelMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteChannel",
      requestType = messaging.Messaging.QueueName.class,
      responseType = messaging.Messaging.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getDeleteChannelMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.QueueName, messaging.Messaging.Message> getDeleteChannelMethod;
    if ((getDeleteChannelMethod = MessagingServiceGrpc.getDeleteChannelMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getDeleteChannelMethod = MessagingServiceGrpc.getDeleteChannelMethod) == null) {
          MessagingServiceGrpc.getDeleteChannelMethod = getDeleteChannelMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.QueueName, messaging.Messaging.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteChannel"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.QueueName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.Message.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("DeleteChannel"))
              .build();
        }
      }
    }
    return getDeleteChannelMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.Empty,
      messaging.Messaging.ChannelList> getListChannelsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListChannels",
      requestType = messaging.Messaging.Empty.class,
      responseType = messaging.Messaging.ChannelList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<messaging.Messaging.Empty,
      messaging.Messaging.ChannelList> getListChannelsMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.Empty, messaging.Messaging.ChannelList> getListChannelsMethod;
    if ((getListChannelsMethod = MessagingServiceGrpc.getListChannelsMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getListChannelsMethod = MessagingServiceGrpc.getListChannelsMethod) == null) {
          MessagingServiceGrpc.getListChannelsMethod = getListChannelsMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.Empty, messaging.Messaging.ChannelList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListChannels"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.ChannelList.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("ListChannels"))
              .build();
        }
      }
    }
    return getListChannelsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.MessageRequest,
      messaging.Messaging.MessageResponse> getSendOneMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendOneMessage",
      requestType = messaging.Messaging.MessageRequest.class,
      responseType = messaging.Messaging.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<messaging.Messaging.MessageRequest,
      messaging.Messaging.MessageResponse> getSendOneMessageMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.MessageRequest, messaging.Messaging.MessageResponse> getSendOneMessageMethod;
    if ((getSendOneMessageMethod = MessagingServiceGrpc.getSendOneMessageMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getSendOneMessageMethod = MessagingServiceGrpc.getSendOneMessageMethod) == null) {
          MessagingServiceGrpc.getSendOneMessageMethod = getSendOneMessageMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.MessageRequest, messaging.Messaging.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendOneMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.MessageRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("SendOneMessage"))
              .build();
        }
      }
    }
    return getSendOneMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.MessageList,
      messaging.Messaging.MessageResponse> getSendMultipleMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SendMultipleMessages",
      requestType = messaging.Messaging.MessageList.class,
      responseType = messaging.Messaging.MessageResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<messaging.Messaging.MessageList,
      messaging.Messaging.MessageResponse> getSendMultipleMessagesMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.MessageList, messaging.Messaging.MessageResponse> getSendMultipleMessagesMethod;
    if ((getSendMultipleMessagesMethod = MessagingServiceGrpc.getSendMultipleMessagesMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getSendMultipleMessagesMethod = MessagingServiceGrpc.getSendMultipleMessagesMethod) == null) {
          MessagingServiceGrpc.getSendMultipleMessagesMethod = getSendMultipleMessagesMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.MessageList, messaging.Messaging.MessageResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SendMultipleMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.MessageList.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.MessageResponse.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("SendMultipleMessages"))
              .build();
        }
      }
    }
    return getSendMultipleMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getReceiveMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveMessages",
      requestType = messaging.Messaging.QueueName.class,
      responseType = messaging.Messaging.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getReceiveMessagesMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.QueueName, messaging.Messaging.Message> getReceiveMessagesMethod;
    if ((getReceiveMessagesMethod = MessagingServiceGrpc.getReceiveMessagesMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getReceiveMessagesMethod = MessagingServiceGrpc.getReceiveMessagesMethod) == null) {
          MessagingServiceGrpc.getReceiveMessagesMethod = getReceiveMessagesMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.QueueName, messaging.Messaging.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.QueueName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.Message.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("ReceiveMessages"))
              .build();
        }
      }
    }
    return getReceiveMessagesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getReceiveSingleMessageMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReceiveSingleMessage",
      requestType = messaging.Messaging.QueueName.class,
      responseType = messaging.Messaging.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getReceiveSingleMessageMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.QueueName, messaging.Messaging.Message> getReceiveSingleMessageMethod;
    if ((getReceiveSingleMessageMethod = MessagingServiceGrpc.getReceiveSingleMessageMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getReceiveSingleMessageMethod = MessagingServiceGrpc.getReceiveSingleMessageMethod) == null) {
          MessagingServiceGrpc.getReceiveSingleMessageMethod = getReceiveSingleMessageMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.QueueName, messaging.Messaging.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReceiveSingleMessage"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.QueueName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.Message.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("ReceiveSingleMessage"))
              .build();
        }
      }
    }
    return getReceiveSingleMessageMethod;
  }

  private static volatile io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getStreamMessagesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamMessages",
      requestType = messaging.Messaging.QueueName.class,
      responseType = messaging.Messaging.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<messaging.Messaging.QueueName,
      messaging.Messaging.Message> getStreamMessagesMethod() {
    io.grpc.MethodDescriptor<messaging.Messaging.QueueName, messaging.Messaging.Message> getStreamMessagesMethod;
    if ((getStreamMessagesMethod = MessagingServiceGrpc.getStreamMessagesMethod) == null) {
      synchronized (MessagingServiceGrpc.class) {
        if ((getStreamMessagesMethod = MessagingServiceGrpc.getStreamMessagesMethod) == null) {
          MessagingServiceGrpc.getStreamMessagesMethod = getStreamMessagesMethod =
              io.grpc.MethodDescriptor.<messaging.Messaging.QueueName, messaging.Messaging.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamMessages"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.QueueName.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  messaging.Messaging.Message.getDefaultInstance()))
              .setSchemaDescriptor(new MessagingServiceMethodDescriptorSupplier("StreamMessages"))
              .build();
        }
      }
    }
    return getStreamMessagesMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MessagingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingServiceStub>() {
        @java.lang.Override
        public MessagingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingServiceStub(channel, callOptions);
        }
      };
    return MessagingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MessagingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingServiceBlockingStub>() {
        @java.lang.Override
        public MessagingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingServiceBlockingStub(channel, callOptions);
        }
      };
    return MessagingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MessagingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<MessagingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<MessagingServiceFutureStub>() {
        @java.lang.Override
        public MessagingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new MessagingServiceFutureStub(channel, callOptions);
        }
      };
    return MessagingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void newChannel(messaging.Messaging.ChannelName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getNewChannelMethod(), responseObserver);
    }

    /**
     */
    default void deleteChannel(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteChannelMethod(), responseObserver);
    }

    /**
     */
    default void listChannels(messaging.Messaging.Empty request,
        io.grpc.stub.StreamObserver<messaging.Messaging.ChannelList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListChannelsMethod(), responseObserver);
    }

    /**
     */
    default void sendOneMessage(messaging.Messaging.MessageRequest request,
        io.grpc.stub.StreamObserver<messaging.Messaging.MessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendOneMessageMethod(), responseObserver);
    }

    /**
     */
    default void sendMultipleMessages(messaging.Messaging.MessageList request,
        io.grpc.stub.StreamObserver<messaging.Messaging.MessageResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSendMultipleMessagesMethod(), responseObserver);
    }

    /**
     */
    default void receiveMessages(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveMessagesMethod(), responseObserver);
    }

    /**
     */
    default void receiveSingleMessage(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReceiveSingleMessageMethod(), responseObserver);
    }

    /**
     */
    default void streamMessages(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamMessagesMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service MessagingService.
   */
  public static abstract class MessagingServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return MessagingServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service MessagingService.
   */
  public static final class MessagingServiceStub
      extends io.grpc.stub.AbstractAsyncStub<MessagingServiceStub> {
    private MessagingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingServiceStub(channel, callOptions);
    }

    /**
     */
    public void newChannel(messaging.Messaging.ChannelName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getNewChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteChannel(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteChannelMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listChannels(messaging.Messaging.Empty request,
        io.grpc.stub.StreamObserver<messaging.Messaging.ChannelList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendOneMessage(messaging.Messaging.MessageRequest request,
        io.grpc.stub.StreamObserver<messaging.Messaging.MessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendOneMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sendMultipleMessages(messaging.Messaging.MessageList request,
        io.grpc.stub.StreamObserver<messaging.Messaging.MessageResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSendMultipleMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveMessages(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getReceiveMessagesMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void receiveSingleMessage(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReceiveSingleMessageMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamMessages(messaging.Messaging.QueueName request,
        io.grpc.stub.StreamObserver<messaging.Messaging.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamMessagesMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service MessagingService.
   */
  public static final class MessagingServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<MessagingServiceBlockingStub> {
    private MessagingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public messaging.Messaging.Message newChannel(messaging.Messaging.ChannelName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getNewChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public messaging.Messaging.Message deleteChannel(messaging.Messaging.QueueName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteChannelMethod(), getCallOptions(), request);
    }

    /**
     */
    public messaging.Messaging.ChannelList listChannels(messaging.Messaging.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListChannelsMethod(), getCallOptions(), request);
    }

    /**
     */
    public messaging.Messaging.MessageResponse sendOneMessage(messaging.Messaging.MessageRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendOneMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public messaging.Messaging.MessageResponse sendMultipleMessages(messaging.Messaging.MessageList request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSendMultipleMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<messaging.Messaging.Message> receiveMessages(
        messaging.Messaging.QueueName request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getReceiveMessagesMethod(), getCallOptions(), request);
    }

    /**
     */
    public messaging.Messaging.Message receiveSingleMessage(messaging.Messaging.QueueName request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReceiveSingleMessageMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<messaging.Messaging.Message> streamMessages(
        messaging.Messaging.QueueName request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamMessagesMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service MessagingService.
   */
  public static final class MessagingServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<MessagingServiceFutureStub> {
    private MessagingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MessagingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new MessagingServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<messaging.Messaging.Message> newChannel(
        messaging.Messaging.ChannelName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getNewChannelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<messaging.Messaging.Message> deleteChannel(
        messaging.Messaging.QueueName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteChannelMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<messaging.Messaging.ChannelList> listChannels(
        messaging.Messaging.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListChannelsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<messaging.Messaging.MessageResponse> sendOneMessage(
        messaging.Messaging.MessageRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendOneMessageMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<messaging.Messaging.MessageResponse> sendMultipleMessages(
        messaging.Messaging.MessageList request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSendMultipleMessagesMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<messaging.Messaging.Message> receiveSingleMessage(
        messaging.Messaging.QueueName request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReceiveSingleMessageMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_NEW_CHANNEL = 0;
  private static final int METHODID_DELETE_CHANNEL = 1;
  private static final int METHODID_LIST_CHANNELS = 2;
  private static final int METHODID_SEND_ONE_MESSAGE = 3;
  private static final int METHODID_SEND_MULTIPLE_MESSAGES = 4;
  private static final int METHODID_RECEIVE_MESSAGES = 5;
  private static final int METHODID_RECEIVE_SINGLE_MESSAGE = 6;
  private static final int METHODID_STREAM_MESSAGES = 7;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_NEW_CHANNEL:
          serviceImpl.newChannel((messaging.Messaging.ChannelName) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.Message>) responseObserver);
          break;
        case METHODID_DELETE_CHANNEL:
          serviceImpl.deleteChannel((messaging.Messaging.QueueName) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.Message>) responseObserver);
          break;
        case METHODID_LIST_CHANNELS:
          serviceImpl.listChannels((messaging.Messaging.Empty) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.ChannelList>) responseObserver);
          break;
        case METHODID_SEND_ONE_MESSAGE:
          serviceImpl.sendOneMessage((messaging.Messaging.MessageRequest) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.MessageResponse>) responseObserver);
          break;
        case METHODID_SEND_MULTIPLE_MESSAGES:
          serviceImpl.sendMultipleMessages((messaging.Messaging.MessageList) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.MessageResponse>) responseObserver);
          break;
        case METHODID_RECEIVE_MESSAGES:
          serviceImpl.receiveMessages((messaging.Messaging.QueueName) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.Message>) responseObserver);
          break;
        case METHODID_RECEIVE_SINGLE_MESSAGE:
          serviceImpl.receiveSingleMessage((messaging.Messaging.QueueName) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.Message>) responseObserver);
          break;
        case METHODID_STREAM_MESSAGES:
          serviceImpl.streamMessages((messaging.Messaging.QueueName) request,
              (io.grpc.stub.StreamObserver<messaging.Messaging.Message>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getNewChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              messaging.Messaging.ChannelName,
              messaging.Messaging.Message>(
                service, METHODID_NEW_CHANNEL)))
        .addMethod(
          getDeleteChannelMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              messaging.Messaging.QueueName,
              messaging.Messaging.Message>(
                service, METHODID_DELETE_CHANNEL)))
        .addMethod(
          getListChannelsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              messaging.Messaging.Empty,
              messaging.Messaging.ChannelList>(
                service, METHODID_LIST_CHANNELS)))
        .addMethod(
          getSendOneMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              messaging.Messaging.MessageRequest,
              messaging.Messaging.MessageResponse>(
                service, METHODID_SEND_ONE_MESSAGE)))
        .addMethod(
          getSendMultipleMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              messaging.Messaging.MessageList,
              messaging.Messaging.MessageResponse>(
                service, METHODID_SEND_MULTIPLE_MESSAGES)))
        .addMethod(
          getReceiveMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              messaging.Messaging.QueueName,
              messaging.Messaging.Message>(
                service, METHODID_RECEIVE_MESSAGES)))
        .addMethod(
          getReceiveSingleMessageMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              messaging.Messaging.QueueName,
              messaging.Messaging.Message>(
                service, METHODID_RECEIVE_SINGLE_MESSAGE)))
        .addMethod(
          getStreamMessagesMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              messaging.Messaging.QueueName,
              messaging.Messaging.Message>(
                service, METHODID_STREAM_MESSAGES)))
        .build();
  }

  private static abstract class MessagingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MessagingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return messaging.Messaging.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("MessagingService");
    }
  }

  private static final class MessagingServiceFileDescriptorSupplier
      extends MessagingServiceBaseDescriptorSupplier {
    MessagingServiceFileDescriptorSupplier() {}
  }

  private static final class MessagingServiceMethodDescriptorSupplier
      extends MessagingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    MessagingServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MessagingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MessagingServiceFileDescriptorSupplier())
              .addMethod(getNewChannelMethod())
              .addMethod(getDeleteChannelMethod())
              .addMethod(getListChannelsMethod())
              .addMethod(getSendOneMessageMethod())
              .addMethod(getSendMultipleMessagesMethod())
              .addMethod(getReceiveMessagesMethod())
              .addMethod(getReceiveSingleMessageMethod())
              .addMethod(getStreamMessagesMethod())
              .build();
        }
      }
    }
    return result;
  }
}
