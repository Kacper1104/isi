<template>
  <div class="about">
    <Conversations :items="items"/>

  </div>
</template>

<script>
import Conversations from '../components/Conversations.Vue'; 
import axios from 'axios'

axios.get('http://localhost:8000/messages/my/${messageId}')
.then(response => {
  console.log(response.data.messages)
})
export default {
  name: "allConversations",
  components: {
    Conversations
  },
  data() {
    return {
      items: []
    };
  },
  mounted() {
    const messageId = this.$route.params.id;
    axios.get(`http://localhost:8000/messages/my/${messageId}`)
      .then(response => {
        this.items = response.data.conversations;
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
