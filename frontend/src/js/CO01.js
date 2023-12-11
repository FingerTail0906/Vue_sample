import axios from "axios";
export default {
  props: {},
  methods: {
    sendReqInit,
    sendReqParam,
  },
};

// データ取得 sample
function sendReqInit() {
  axios
    .get("http://localhost:8081/CO01")
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.error(error);
    });
}

// パラメータ送信 sample
function sendReqParam() {
  const data = {
    key1: "value1",
    key2: "value2",
  };
  const params = new URLSearchParams(data);
  axios
    .get("http://localhost:8081/CO01/AAA", { params })
    .then((response) => {
      console.log(response.data);
    })
    .catch((error) => {
      console.error(error);
    });
}
