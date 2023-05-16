<template>
    <div>
      <h1>Messages:</h1>
        <div v-for="(message, index) in items" :key="index" class="message">
          <div v-if="message.fields.sender === '1'" class="class-a">{{ message.fields.text }}</div>
          <div v-else-if="message.fields.sender === '0'" class="class-b">{{ message.fields.text }}</div>
      </div>
        <form @submit.prevent="sendResponse">
        <input type="text" v-model="text" />
        <button type="submit">Send</button>
      </form>
    <div>
    </div>


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
          window.location.reload();
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style scoped>
.message{
  background-color: rgb(49, 49, 49);
  margin: 3px;
  border-radius: 50px;

  
}
h2 {
  color: blue;
}

.class-a{
  color: red;
  margin-left: 20px;
  min-width: 300px;
}

.class-b{
  display: flex;
  color: greenyellow;
  justify-content: flex-end;
  margin-right: 20px;
  min-width: 300px;
}

button{
  background-color: rgb(128, 128, 128);
  min-width: 100px;
  cursor: pointer;
  padding: 5px;
}

button:hover{
  background-color: rgb(170, 170, 170);

}

input{
  background-color: rgba(255, 255, 255, 0.664);
  padding: 5px;
  margin: 6px;
}
</style>