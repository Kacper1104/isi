<template>
    <div>
      <h2>Messages:</h2>
      <ul>
        <li v-for="(message, index) in items" :key="index">{{ message.fields }}</li>
      </ul>
    </div>
</template>
<script>
export default {
  name: "Conversation",
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