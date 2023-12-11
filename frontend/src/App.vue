<template>
  <router-view name="header" />
  <div class="c-contents">
    <router-view name="sidebar" />
    <router-view />
  </div>
  <router-view name="footer" />
</template>

<script>
export default {
  name: "App",
};
</script>

<style>
@import "./css/style.css";
</style>