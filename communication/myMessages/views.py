from django.shortcuts import render

from django.http import JsonResponse

def send_message(request, conversation_id):
    if request.method == 'POST':
        message = request.POST.get('message')
        response_data = {'status': 'success', 'conversation id': 'conversation_id'}
        return JsonResponse(response_data)
    else:
        response_data = {'status': 'error', 'conversation id': conversation_id}
        return JsonResponse(response_data, status=400)


def my_conversations(request):
    if request.method == 'GET':
        response_data = {'status': 'success', 'message': 'My conversations'}
        return JsonResponse(response_data, status=400)
