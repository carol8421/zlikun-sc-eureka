# zlikun-sc-eureka
注册中心服务，提供服务发现功能

#### 资料
- [12. Service Discovery: Eureka Server](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi_spring-cloud-eureka-server.html)
- [11. Service Discovery: Eureka Clients](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi__service_discovery_eureka_clients.html)
- [Netflix/eureka](https://github.com/Netflix/eureka)

#### 测试服务
```
# http://localhost:8761/
```

#### Docker
```
# 1. Docker服务器开启远程访问
# 2. 编写Dockerfile文件
# 3. 配置Docker打包插件
# 4. 执行构建镜像命令
$ mvn clean package docker:build
# 5. 查看镜像
$ docker image ls zlikun/zlikun-sc-eureka
REPOSITORY                TAG                 IMAGE ID            CREATED             SIZE
zlikun/zlikun-sc-eureka   1.0.0               bcf2d4e9f79e        2 minutes ago       689MB
zlikun/zlikun-sc-eureka   latest              bcf2d4e9f79e        2 minutes ago       689MB
# 6. 启动容器测试：http://192.168.0.105:8761/
$ $ docker run -p 8761:8761 --rm zlikun/zlikun-sc-eureka
```

#### [12.5 Peer Awareness](http://cloud.spring.io/spring-cloud-static/Finchley.RELEASE/multi/multi_spring-cloud-eureka-server.html#spring-cloud-eureka-server-peer-awareness)
```

---
spring:
  profiles: dev
eureka:
  instance:
    hostname: dev
  client:
    service-url:
      default-zone: http://dev/eureka/
---
spring:
  profiles: prod
eureka:
  instance:
    hostname: prod
  client:
    service-url:
      default-zone: http://prod/eureka/
```
