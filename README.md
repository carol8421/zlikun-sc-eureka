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
$ docker run -p 8761:8761 --rm zlikun/zlikun-sc-eureka

# 实际运行命令(测试)
$ docker run -d \
--name eureka \
-p 8761:8761 \
zlikun/zlikun-sc-eureka
5aa8f488461e3ea48f7dc069f5428e51f713d70b0ed04ef002fd974e0742d49b
```

#### 集群配置
```
# 修改 hosts 文件，配置测试
127.0.0.1		peer1
127.0.0.1		peer2

# 启动两个eureka服务
$ java -jar eureka.jar --spring.profiles.active=peer1
$ java -jar eureka.jar --spring.profiles.active=peer2

# http://peer1:8761/
# http://peer2:8762/

# 可以看到每个注册中心监控页上可以看到另一个节点信息，并被标注为：available-replicas
```
