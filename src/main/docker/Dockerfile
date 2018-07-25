# 基于java8镜像
FROM java:8

# 指定作者信息
MAINTAINER zlikun "zlikun-dev@hotmail.com"

# 复制文件到容器
ADD eureka.jar /app/eureka.jar
WORKDIR /app

# 指定暴露端口
EXPOSE 8761

# 配置容器启动后执行的命令
ENTRYPOINT ["java", "-jar", "eureka.jar"]