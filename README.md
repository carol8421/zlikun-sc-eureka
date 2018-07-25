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
