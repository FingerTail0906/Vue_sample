import { createApp } from "vue";
import App from "./App.vue";
import { createRouter, createWebHistory } from "vue-router";

import Header from "./components/common/header.vue";
import Footer from "./components/common/footer.vue";
import Sidebar from "./components/common/sidebar.vue";
import CO01 from "./components/CO01.vue";
import CO02 from "./components/CO02.vue";

const router = createRouter({
  history: createWebHistory(),
  routes: [
    {
        // 検索機能
      path: "/CO01",
      components: {
        default: CO01,
        header: Header,
        footer: Footer,
        sidebar: Sidebar,
      },
    },
    {
        // csv取り込み機能
      path: "/CO02",
      components: {
        default: CO02,
        header: Header,
        footer: Footer,
        sidebar: Sidebar,
      },
    },
  ],
});

const app = createApp(App);

app.use(router);

app.mount("#app");
