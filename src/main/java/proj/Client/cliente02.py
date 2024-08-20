import grpc
from Messaging_pb2 import ChannelName, MessageRequest, MessageList, QueueName, Message
from Messaging_pb2_grpc import MessagingServiceStub
from Subscribe_pb2 import ChannelType as SubscribeChannelType, Empty as SubscribeEmpty, QueueType as SubscribeQueueType
from Subscribe_pb2_grpc import SubscribeServiceStub
from google.protobuf.empty_pb2 import Empty as GoogleEmpty
import logging

class MessagingSubscribeClient:
    def __init__(self, channel):
        self.messaging_stub = MessagingServiceStub(channel)
        self.subscribe_stub = SubscribeServiceStub(channel)

    def create_channel(self, channel_name, channel_type):
        request = ChannelName(type=channel_type, content=channel_name)  # Ajustado para ordem correta dos campos
        try:
            response = self.messaging_stub.NewChannel(request)
            print(f"Channel Created: {response.content}")
        except grpc.RpcError as e:
            print(f"Error creating channel: {e.code()} {e.details()}")

    def list_channels(self):
        request = GoogleEmpty()
        try:
            response = self.messaging_stub.ListChannels(request)
            print("Channels:")
            for channel in response.canais:  # Nome correto do campo conforme o proto
                print(f"- Name: {channel.name}, Type: {channel.type}")
        except grpc.RpcError as e:
            print(f"Error listing channels: {e.code()} {e.details()}")

    def subscribe_to_channel(self, channel_name, channel_type, client_name):
        request = SubscribeChannelType(channelName=channel_name, channelType=channel_type, clientName=client_name)  # Ajustado para correspondência com o proto
        try:
            response = self.subscribe_stub.Subscribe(request)
            print(f"Subscribed to channel: {response.content}")
        except grpc.RpcError as e:
            print(f"Error subscribing to channel: {e.code()} {e.details()}")

    def send_one_message(self, channel_name, message_content):
        request = MessageRequest(channel=channel_name, message=message_content)
        try:
            response = self.messaging_stub.SendOneMessage(request)
            print(f"Message sent: {response.response}")
        except grpc.RpcError as e:
            print(f"Error sending one message: {e.code()} {e.details()}")

    def send_multiple_messages(self, channel_name, messages):
        message_list = MessageList(ChannelName=channel_name, type=SubscribeQueueType.SIMPLES,  # Ajustado para correspondência com o proto
                                   messages=[Message(content=msg) for msg in messages])
        try:
            response = self.messaging_stub.SendMultipleMessages(message_list)
            print(f"Multiple messages sent: {response.response}")
        except grpc.RpcError as e:
            print(f"Error sending multiple messages: {e.code()} {e.details()}")

    def receive_single_message(self, channel_name):
        request = QueueName(name=channel_name, type=SubscribeQueueType.SIMPLES)  # Ajustado para consistência
        try:
            response = self.messaging_stub.ReceiveSingleMessage(request)
            print(f"Received message: {response.content}")
        except grpc.RpcError as e:
            print(f"Error receiving single message: {e.code()} {e.details()}")

    def stream_messages(self, channel_name):
        request = QueueName(name=channel_name, type=SubscribeQueueType.SIMPLES)  # Ajustado para consistência

        try:
            for message in self.messaging_stub.StreamMessages(request):
                print(f"Received message: {message.content}")
        except grpc.RpcError as e:
            print(f"Error streaming messages: {e.code()} {e.details()}")

    def list_subscribers(self):
        request = SubscribeEmpty()
        try:
            response = self.subscribe_stub.ListSubscribers(request)
            print(f"Subscribers:\n{response.assinantes}")  # Ajustado para nome correto do campo
        except grpc.RpcError as e:
            print(f"Error listing subscribers: {e.code()} {e.details()}")

    def delete_channel(self, channel_name):
        request = QueueName(name=channel_name, type=SubscribeQueueType.SIMPLES)  # Ajustado para consistência
        try:
            response = self.messaging_stub.DeleteChannel(request)
            print(f"Channel deleted: {response.content}")
        except grpc.RpcError as e:
            print(f"Error deleting channel: {e.code()} {e.details()}")

def main():
    target = 'localhost:50051'
    channel = grpc.insecure_channel(target)
    client = MessagingSubscribeClient(channel)

    try:
        # Step 1: Create a new channel
        client.create_channel('TestChannelCLIENT01', SubscribeQueueType.SIMPLES)

        # Step 2: List available channels
        client.list_channels()

        # Step 3: Send multiple messages to the channel
        messages = ["Message 1", "Message 2", "Message 3"]
        client.send_multiple_messages('TestChannelCLIENT01', messages)

        # Step 4: Receive a single message from the channel
        client.receive_single_message('TestChannelCLIENT01')

        # Step 5: Receive messages using stream
        client.stream_messages('TestChannelCLIENT01')

        # Step 6: Delete a channel
        client.delete_channel('TestChannelCLIENT01')

        # List channels again after deletion
        client.list_channels()
    finally:
        channel.close()

if __name__ == '__main__':
    logging.basicConfig(level=logging.INFO)
    main()
