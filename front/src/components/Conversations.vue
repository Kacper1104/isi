<template>
    <div>
      <h1>Lista konwersacji:</h1>
      <ul>
        <router-link v-for="(message, index) in items" :key="index" :to="'/messages/id/' + message.pk">
          <li>Konwersacja z użytkownikiem: {{ message.fields.sender_id }}</li>
        </router-link>
      </ul>
    </div>
</template>
<script>
export default {
  name: "Conversations",
  props: {
    items: Array
  }
};
</script>

<style scoped>
h2 {
  color: blue;
}

li{
  font-size: 1.5rem;
  background-color: black;
  padding: 10px;
  border-radius: 50px;
  ;
}

li:hover{
  background-color: rgba(0, 0, 0, 0.301);
}
</style>

