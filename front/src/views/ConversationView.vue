<template>
    <div class="about">
      <Conversation :items="items"/>
  
    </div>
  </template>
  
  <script>
  import Conversation from '../components/Conversation.vue';
  import axios from 'axios'
  
  axios.get('http://localhost:8000/messages/id/1')
  .then(response => {
    console.log(response.data.messages)
  })
  export default {
    name: "allConversations",
    components: {
      Conversation
    },
    data() {
      return {
        items: []
      };
    },
    mounted() {
      const messageId = this.$route.params.id;
      axios.get(`http://localhost:8000/messages/id/${messageId}`)
        .then(response => {
          this.items = response.data.messages;
        })
        .catch(error => {
          console.log(error);
        })
    }
  };
  
  </script>
  
  <style>
  @media (min-width: 1024px) {
    .about {
      min-height: 100vh;
      display: flex;
      align-items: center;
    }
  }
  </style>
  