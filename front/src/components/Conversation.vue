<template>
    <div>
      <h2>Messages:</h2>
      <ul>
        <li v-for="(message, index) in items" :key="index">{{ message.fields }}</li>
      </ul>
    </div>
    <div>
    <form @submit.prevent="sendResponse">
      <input type="text" v-model="text" />
      <button type="submit">Send</button>
    </form>
  </div>
</template>
<script>
import axios from 'axios';


export default {
  name: "Conversation",
  props: {
    items: Array
  },

  data() {
    return {
      text: "",
    };
  },
  methods: {
    sendResponse() {
      const messageId = this.$route.params.id;
      const formData = new FormData();
      formData.append("text", this.text);

      axios
        .post(`http://localhost:8000/messages/id/${messageId}`, formData, {
          headers: {
            "Content-Type": "multipart/form-data",
          },
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
h2 {
  color: blue;
}
</style>