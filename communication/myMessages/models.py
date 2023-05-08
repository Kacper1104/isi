from django.db import models
from django.core import serializers
import json
from django.utils import timezone

# Create your models here.
class Conversation(models.Model):
    offer_id = models.CharField(max_length=255)
    offer_owner_id = models.CharField(max_length=255)
    sender_id = models.CharField(max_length=255)

    def get_conversations_for_user(user_id):
        conversations = Conversation.objects.filter(models.Q(offer_owner_id=user_id) | models.Q(sender_id=user_id))
        json_data = serializers.serialize('json', conversations)
        data = json.loads(json_data)
        return data

class Message(models.Model):
    conversation = models.ForeignKey(Conversation, on_delete=models.CASCADE, related_name='messages')
    sender = models.CharField(max_length=255)
    text = models.TextField()
    timestamp = models.DateTimeField(auto_now_add=True)

    def send_message(conversation_id, sender_id, text):
        conversation = Conversation.objects.get(id = conversation_id)
        Message.objects.create(conversation = conversation,
                               sender = sender_id,
                               text = text,
                               timestamp = timezone.now())
    
    def get_messages(conversation_id):
        messages = Message.objects.filter(conversation_id=conversation_id)
        json_data = serializers.serialize('json', messages)
        data = json.loads(json_data)
        return data