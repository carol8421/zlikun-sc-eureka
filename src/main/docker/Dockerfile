# 基于java8镜像
FROM java:8

# 指定作者信息
MAINTAINER zlikun "zlikun-dev@hotmail.com"

# 将本地文件挂载到容器
VOLUME /tmp

# 复制文件到容器
ADD eureka.jar /eureka.jar

# 指定暴露端口
EXPOSE 80

# 配置容器启动后执行的命令
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/eureka.jar" ,"--spring.profiles.active=prod"]