from django.urls import path
from . import views

urlpatterns = [
    path('messages/id/<conversation_id>', views.send_message, name='send_message'),
    path('messages/my/<user_id>', views.my_conversations, name='my_messages'),
]
