package subscribe;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.1)",
    comments = "Source: Subscribe.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SubscribeServiceGrpc {

  private SubscribeServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "subscribe.SubscribeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<subscribe.Subscribe.ChannelType,
      subscribe.Subscribe.Message> getSubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Subscribe",
      requestType = subscribe.Subscribe.ChannelType.class,
      responseType = subscribe.Subscribe.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<subscribe.Subscribe.ChannelType,
      subscribe.Subscribe.Message> getSubscribeMethod() {
    io.grpc.MethodDescriptor<subscribe.Subscribe.ChannelType, subscribe.Subscribe.Message> getSubscribeMethod;
    if ((getSubscribeMethod = SubscribeServiceGrpc.getSubscribeMethod) == null) {
      synchronized (SubscribeServiceGrpc.class) {
        if ((getSubscribeMethod = SubscribeServiceGrpc.getSubscribeMethod) == null) {
          SubscribeServiceGrpc.getSubscribeMethod = getSubscribeMethod =
              io.grpc.MethodDescriptor.<subscribe.Subscribe.ChannelType, subscribe.Subscribe.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Subscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  subscribe.Subscribe.ChannelType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  subscribe.Subscribe.Message.getDefaultInstance()))
              .setSchemaDescriptor(new SubscribeServiceMethodDescriptorSupplier("Subscribe"))
              .build();
        }
      }
    }
    return getSubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<subscribe.Subscribe.ChannelType,
      subscribe.Subscribe.Message> getUnsubscribeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Unsubscribe",
      requestType = subscribe.Subscribe.ChannelType.class,
      responseType = subscribe.Subscribe.Message.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<subscribe.Subscribe.ChannelType,
      subscribe.Subscribe.Message> getUnsubscribeMethod() {
    io.grpc.MethodDescriptor<subscribe.Subscribe.ChannelType, subscribe.Subscribe.Message> getUnsubscribeMethod;
    if ((getUnsubscribeMethod = SubscribeServiceGrpc.getUnsubscribeMethod) == null) {
      synchronized (SubscribeServiceGrpc.class) {
        if ((getUnsubscribeMethod = SubscribeServiceGrpc.getUnsubscribeMethod) == null) {
          SubscribeServiceGrpc.getUnsubscribeMethod = getUnsubscribeMethod =
              io.grpc.MethodDescriptor.<subscribe.Subscribe.ChannelType, subscribe.Subscribe.Message>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Unsubscribe"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  subscribe.Subscribe.ChannelType.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  subscribe.Subscribe.Message.getDefaultInstance()))
              .setSchemaDescriptor(new SubscribeServiceMethodDescriptorSupplier("Unsubscribe"))
              .build();
        }
      }
    }
    return getUnsubscribeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<subscribe.Subscribe.Empty,
      subscribe.Subscribe.ReturnList> getListSubscribersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListSubscribers",
      requestType = subscribe.Subscribe.Empty.class,
      responseType = subscribe.Subscribe.ReturnList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<subscribe.Subscribe.Empty,
      subscribe.Subscribe.ReturnList> getListSubscribersMethod() {
    io.grpc.MethodDescriptor<subscribe.Subscribe.Empty, subscribe.Subscribe.ReturnList> getListSubscribersMethod;
    if ((getListSubscribersMethod = SubscribeServiceGrpc.getListSubscribersMethod) == null) {
      synchronized (SubscribeServiceGrpc.class) {
        if ((getListSubscribersMethod = SubscribeServiceGrpc.getListSubscribersMethod) == null) {
          SubscribeServiceGrpc.getListSubscribersMethod = getListSubscribersMethod =
              io.grpc.MethodDescriptor.<subscribe.Subscribe.Empty, subscribe.Subscribe.ReturnList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListSubscribers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  subscribe.Subscribe.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  subscribe.Subscribe.ReturnList.getDefaultInstance()))
              .setSchemaDescriptor(new SubscribeServiceMethodDescriptorSupplier("ListSubscribers"))
              .build();
        }
      }
    }
    return getListSubscribersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubscribeServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscribeServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscribeServiceStub>() {
        @java.lang.Override
        public SubscribeServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscribeServiceStub(channel, callOptions);
        }
      };
    return SubscribeServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscribeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscribeServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscribeServiceBlockingStub>() {
        @java.lang.Override
        public SubscribeServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscribeServiceBlockingStub(channel, callOptions);
        }
      };
    return SubscribeServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubscribeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscribeServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscribeServiceFutureStub>() {
        @java.lang.Override
        public SubscribeServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscribeServiceFutureStub(channel, callOptions);
        }
      };
    return SubscribeServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void subscribe(subscribe.Subscribe.ChannelType request,
        io.grpc.stub.StreamObserver<subscribe.Subscribe.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSubscribeMethod(), responseObserver);
    }

    /**
     */
    default void unsubscribe(subscribe.Subscribe.ChannelType request,
        io.grpc.stub.StreamObserver<subscribe.Subscribe.Message> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUnsubscribeMethod(), responseObserver);
    }

    /**
     */
    default void listSubscribers(subscribe.Subscribe.Empty request,
        io.grpc.stub.StreamObserver<subscribe.Subscribe.ReturnList> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getListSubscribersMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SubscribeService.
   */
  public static abstract class SubscribeServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SubscribeServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SubscribeService.
   */
  public static final class SubscribeServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SubscribeServiceStub> {
    private SubscribeServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscribeServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscribeServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribe(subscribe.Subscribe.ChannelType request,
        io.grpc.stub.StreamObserver<subscribe.Subscribe.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void unsubscribe(subscribe.Subscribe.ChannelType request,
        io.grpc.stub.StreamObserver<subscribe.Subscribe.Message> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void listSubscribers(subscribe.Subscribe.Empty request,
        io.grpc.stub.StreamObserver<subscribe.Subscribe.ReturnList> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListSubscribersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SubscribeService.
   */
  public static final class SubscribeServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SubscribeServiceBlockingStub> {
    private SubscribeServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscribeServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscribeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public subscribe.Subscribe.Message subscribe(subscribe.Subscribe.ChannelType request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public subscribe.Subscribe.Message unsubscribe(subscribe.Subscribe.ChannelType request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUnsubscribeMethod(), getCallOptions(), request);
    }

    /**
     */
    public subscribe.Subscribe.ReturnList listSubscribers(subscribe.Subscribe.Empty request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListSubscribersMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SubscribeService.
   */
  public static final class SubscribeServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SubscribeServiceFutureStub> {
    private SubscribeServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscribeServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscribeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<subscribe.Subscribe.Message> subscribe(
        subscribe.Subscribe.ChannelType request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<subscribe.Subscribe.Message> unsubscribe(
        subscribe.Subscribe.ChannelType request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUnsubscribeMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<subscribe.Subscribe.ReturnList> listSubscribers(
        subscribe.Subscribe.Empty request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListSubscribersMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SUBSCRIBE = 0;
  private static final int METHODID_UNSUBSCRIBE = 1;
  private static final int METHODID_LIST_SUBSCRIBERS = 2;

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
        case METHODID_SUBSCRIBE:
          serviceImpl.subscribe((subscribe.Subscribe.ChannelType) request,
              (io.grpc.stub.StreamObserver<subscribe.Subscribe.Message>) responseObserver);
          break;
        case METHODID_UNSUBSCRIBE:
          serviceImpl.unsubscribe((subscribe.Subscribe.ChannelType) request,
              (io.grpc.stub.StreamObserver<subscribe.Subscribe.Message>) responseObserver);
          break;
        case METHODID_LIST_SUBSCRIBERS:
          serviceImpl.listSubscribers((subscribe.Subscribe.Empty) request,
              (io.grpc.stub.StreamObserver<subscribe.Subscribe.ReturnList>) responseObserver);
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
          getSubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              subscribe.Subscribe.ChannelType,
              subscribe.Subscribe.Message>(
                service, METHODID_SUBSCRIBE)))
        .addMethod(
          getUnsubscribeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              subscribe.Subscribe.ChannelType,
              subscribe.Subscribe.Message>(
                service, METHODID_UNSUBSCRIBE)))
        .addMethod(
          getListSubscribersMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              subscribe.Subscribe.Empty,
              subscribe.Subscribe.ReturnList>(
                service, METHODID_LIST_SUBSCRIBERS)))
        .build();
  }

  private static abstract class SubscribeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscribeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return subscribe.Subscribe.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SubscribeService");
    }
  }

  private static final class SubscribeServiceFileDescriptorSupplier
      extends SubscribeServiceBaseDescriptorSupplier {
    SubscribeServiceFileDescriptorSupplier() {}
  }

  private static final class SubscribeServiceMethodDescriptorSupplier
      extends SubscribeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SubscribeServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SubscribeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubscribeServiceFileDescriptorSupplier())
              .addMethod(getSubscribeMethod())
              .addMethod(getUnsubscribeMethod())
              .addMethod(getListSubscribersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
