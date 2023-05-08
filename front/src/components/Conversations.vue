<template>
    <div>
      <h2>Lista konwersacji:</h2>
      <ul>
        <router-link v-for="(message, index) in items" :key="index" :to="'/messages/id/' + message.pk">
          <li>{{ message.fields }}</li>
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
</style>