<template>
    <div>
      <h2>List of items:</h2>
      <ul>
        <router-link v-for="(message, index) in items" :key="index" :to="'/messages/my/' + message.pk">
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