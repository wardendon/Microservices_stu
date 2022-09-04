"use strict";

const NacosNamingClient = require("nacos").NacosNamingClient;
const logger = console;
const express = require("express");
const app = express();
const port = 3000;

const client = new NacosNamingClient({
  logger,
  serverList: "124.221.138.97:8848", // nacos 服务地址
  namespace: "public", // nacos 命名空间
});
client.ready().then(() => {
  const serviceName = "nodejs.test.domain"; // 服务名
  // 开始注册
  client.registerInstance(serviceName, {
    ip: "192.168.3.6",
    port: port,
  });
});

// 测试接口
app.get("/", (req, res) => {
  res.send("Hello nacos~!~!");
});

app.listen(port, () => {
  console.log(`Example app listening on port ${port}`);
});
