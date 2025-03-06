FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/UserServiceLab2-0.0.1-SNAPSHOT.jar userservice.jar

# Открываем внутренний порт 9051
EXPOSE 9051

ENTRYPOINT ["java", "-jar", "/app/userservice.jar"]
