# zlikun-sc-eureka
Spring Cloud Eureka ，微服务注册中心

#### 资料
- <https://github.com/netflix/eureka>

#### 笔记
- `Eureka Server` 提供服务发现能力，各个微服务启动时，会向 `Eureka Server` 注册自己的信息(IP、端口、微服务名称等)，`Eureka Server` 会存储这些信息
- `Eureka Client` 是一个Java客户端，用于简化与 `Eureka Server` 的交互
- 如果 `Eureka Server` 在一定时间内没有接收到某个微服务实例的心跳，`Eureka Server` 会将该实例注销(默认90秒)
- 默认情况下，`Eureka Server` 同时也是 `Eureka Client` ，多个 `Eureka Server` 实例，相互之间通过复制的方式，来实现服务注册表中的数据同步
- `Eureka Client` 会缓存服务注册表信息，这种方式的优势：
  - 微服务不用每次都请求查询 `Eureka Server` ，降低了 `Eureka Server` 的压力
  - 即使 `Eureka Server` 所有节点都宕掉，服务消息端依然可以使用缓存中的信息找到服务提供者并完成调用

> 综上所述 `Eureka` 通过心跳检测、客户端缓存等机制，提高系统灵活性、可伸缩性和可用性

#### 示例
- 在 `pom.xml` 文件中添加依赖

```
<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-eureka</artifactId>
</dependency>

<dependency>
  <groupId>org.springframework.cloud</groupId>
  <artifactId>spring-cloud-starter-eureka-server</artifactId>
</dependency>
```
- 在启动类上添加 `@EnableEurekaServer` 注解，声明这是一个 `Eureka Server`

- 在 `application.yml` 配置文件中添加相关配置

```
server:
  port: 8761
# register-with-eureka 表示是否将自己注册到Eureka Server，默认为：true
# fetch-registry 表示是否从Eureka Server获取注册信息，默认为：true
eureka:
  client:
    register-with-eureka: true
    fetch-registry: true
    service-url:
      default-zone: http://localhost:${server.port}/eureka/
# 实现basic认证并设置用户名、密码
security:
  basic:
    enabled: true
  user:
    name: root
    password: xxxxxx
```
> `eureka.client.registerWithEureka`：表示是否将自己注册到 `Eureka Server` ，默认：true。单台部署时，由于当前应用就是server，所以配置为：false
> `eureka.client.fetchRegistry`：表示是否从 `Eureka Server` 获取注册信息，默认：true。单台部署时，不需要同步其它 `Eureka Server` 节点数据，所以配置为：false
> `eureka.client.service-url.default-zone`：设置与 `Eureka Server` 交互的地址，查询服务和注册服务都需要依赖这个地址，默认：<http://localhost:8761/eureka/> 多个地址以英文逗号分隔

- 访问Eureka监控界面(需登录)

```
# http://localhost:8761/
# 首页展示了很多信息，包含当前实例的状态、注册到 Eureka Server 上的服务实例、常用信息、实例信息等。
```

#### Docker
```
# 添加Docker依赖及Dockerfile文件
$ mvn clean package docker:build
```