from django.shortcuts import render
from myMessages.models import Conversation, Message
from django.http import JsonResponse

def send_message(request, conversation_id):
    if request.method == 'POST':
        message = request.POST.get('message')
        sender_id = 1
        text = 'test'
        Message.send_message(conversation_id, sender_id, text)

        response_data = {'status': 'success', 'conversation id': 'conversation_id'}
        return JsonResponse(response_data)
    else:
        messages = Message.get_messages(conversation_id)
        response_data = {'status': 'success', 'messages': messages}
        return JsonResponse(response_data, status=200)


def my_conversations(request, user_id):
    if request.method == 'GET':
        conversations = Conversation.get_conversations_for_user(user_id)
        response_data = {'status': 'success', 'conversations': conversations}
        return JsonResponse(response_data, status=200)
