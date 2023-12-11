<template>
  <div class="c-sidebar__sec">
    <ul>
      <li>
        <router-link to="/CO01"><span>CO01</span></router-link>
      </li>
      <li>
        <router-link to="/CO02"><span>CO02</span></router-link>
      </li>
      <li>
        <a><span>CO03</span></a>
      </li>
      <li>
        <a><span>CO04</span></a>
      </li>
      <li>
        <a><span>CO05</span></a>
      </li>
      <li>
        <a><span>CO06</span></a>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "App",
  props: {},
};
</script>
<style>
@import "../../css/style.css";
</style>
