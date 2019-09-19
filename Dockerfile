FROM frolvlad/alpine-oraclejre8
LABEL maintainer="Chethan Katteri <chethangowda@gmail.com>"
LABEL description="duplicatecheck-redis"
COPY duplicatecheck-redis.jar /opt/
WORKDIR /opt/
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "duplicatecheck-redis.jar"]
