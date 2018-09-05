FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD monkey-eureka-1.0.0.jar app.jar
ENTRYPOINT ["sh","-c","java $PARAMS -jar /app.jar"]