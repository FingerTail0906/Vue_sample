<template>
  <div class="p-co01__main">
    <div class="p-co01__fv-sec">
      <div class="p-co01__fv-contents">
        <p v-if="!init" class="c-button__test" @click="view">view</p>
        <ul v-if="init" class="p-co01__fv-menu">
          <li>
            <p>検索キーワード</p>
            <input type="text" placeholder="検索キーワード" v-model="searchKeyWord" />
          </li>
          <li>
            <p>rank</p>
            <select v-model="selectA">
              <option></option>
              <option>1</option>
              <option>2</option>
              <option>3</option>
            </select>
          </li>
          <li>
            <p>termstudent</p>
            <select v-model="selectB">
              <option></option>
              <option>1</option>
              <option>2</option>
              <option>3</option>
              <option>NULL</option>
            </select>
          </li>
          <li>
            <p class="c-button__test" @click="reqApi">search</p>
          </li>
        </ul>
        <DataTable :tableObj="obj" :tableColumns="tableColumns" />
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import DataTable from "./common/function/dataTable.vue";

export default {
  components: {
    DataTable,
  },
  data() {
    return {
      obj: [],
      init: true,
      // テーブルの型定義
      tableColumns: [
        { key: "noticeid", value: "ID" },
        { key: "termstudent", value: "期生" },
        { key: "rank", value: "ランク" },
        { key: "sdate", value: "開始日" },
        { key: "edate", value: "終了日" },
        { key: "title", value: "タイトル" },
        { key: "message", value: "メッセージ" },
      ],
      searchKeyWord: '',
      selectA: '',
      selectB: '',
    };
  },
  // viewボタン押下
  methods: {
    view() {
      this.init = false
      axios
        .get("http://localhost:8081/CO01")
        .then((response) => {
          this.obj = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    // searchボタン押下
    reqApi() {
      axios
        .get("http://localhost:8081/CO01Search", {
          params: {
            searchKeyWord: this.searchKeyWord,
            selectA: this.selectA,
            selectB: this.selectB
          }
        })
        .then((response) => {
          this.obj = response.data;
        })
        .catch((error) => {
          console.error(error);
        });
    }
  },
};
</script>

<style scoped>
@import "../css/CO01.css";
</style>
