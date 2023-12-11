<template>
  <div class="f-table__container">
    <table v-if="keys.length > 0">
      <thead>
        <tr>
          <th v-for="key in keys" :key="key">{{ key.value }}</th>
        </tr>
      </thead>
      <tbody v-if="rows.length > 0">
        <tr v-for="row in rows" :key="row">
          <td v-for="key in keys" :key="key">{{ row[key.key] }}</td>
        </tr>
      </tbody>
      <tbody v-if="rows.length == 0">
        <tr class="f-table__not-data "> データが存在しません。</tr>
      </tbody>
    </table>
  </div>
  <ul v-if="keys.length > 0">
    <li>
      <p>1</p>
    </li>
    <li>
      <p>1</p>
    </li>
  </ul>
</template>
<script>

// const maxLength = 10;

export default {
  props: {
    tableObj: {
      type: Array,
      default: () => [],
    },
    tableColumns: {
      type: Array,
      default: null,
    },
  },
  data() {
    return {
      keys: [],
      rows: [],
    };
  },
  watch: {
    // テーブル表示機能
    tableObj(elm) {
      // key情報セット
      this.keys = this.tableColumns.map(column => column);
      const keys = this.tableColumns.map(column => column.key);
      const list = elm.map(element => {
        const object = {};
        keys.forEach(key => {
          object[key] = element[key];
        });
        return object;
      });
      this.rows = list;
    },
  },
};
</script>

<style scoped>
@import "../../../css/dataTable.css";
</style>
