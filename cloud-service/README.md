# 搭建SpringCloudAlibaba模板项目

使用Nacos进行服务注册与发现的测试

![91task](README.assets/91task.png)

## Nacos

[Nacos 文档](https://nacos.io/zh-cn/docs/quick-start.html)

进入	`nacos/bin`目录，打开终端

- 启动服务

```bash
./startup.sh -m standalone
```

- 打开nacos控制台登录页面,默认用户名密码都是： nacos
```
http://localhost:8848/nacos/
```

- 关闭服务

```bash
./shutdown.sh
```

## Spring Cloud

Spring Cloud为开发者提供了快速构建分布式系统中一些常见模式的工具（例如，配置管理、服务发现、断路器、智能路由、微代理、控制总线、一次性令牌、全局锁、领导层选举、分布式会话、集群状态）。分布式系统的协调导致了锅炉板模式，使用Spring Cloud，开发者可以快速建立实现这些模式的服务和应用。它们在任何分布式环境中都能很好地工作，包括开发人员自己的笔记本电脑、裸机数据中心和管理平台（如Cloud Foundry）。



[微服务新秀之Nacos，看了就会，我说的！ - 菜农曰的文章 - 知乎 ](https://zhuanlan.zhihu.com/p/264887200)

[linux安装nacos](https://www.cnblogs.com/lazysang/p/14079508.html)