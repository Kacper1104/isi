<template>
  <h1>Cool offer of bread</h1>
  <img width="400" height="200" src="https://www.thespruceeats.com/thmb/j4mujy24lcmnyW_a7VS1sVP4Mw4=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/loaf-of-bread-182835505-58a7008c5f9b58a3c91c9a14.jpg" alt="bread">
  <GoogleMap api-key="AIzaSyC22-Nma_6Anh7be0V57f-xrO-KITMDCBk" style="width: 100%; height: 500px" :center="center" :zoom="15">
    <Marker :options="{ position: center }" />
  </GoogleMap>
</template>

<script>
import { GoogleMap, Marker } from "vue3-google-map";
export default {

  name: "Offer",
  components: { GoogleMap, Marker },
  setup() {
    const center = { lat: 40.689247, lng: -74.044502 };
    return { center };
  },
}
</script>

<style scoped>

</style>