FROM docker.1ms.run/eclipse-temurin:17-jre

FROM docker.1ms.run/openjdk:17-slim

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-Xms128m", "-Xmx1024m", "-jar", "app.jar"]
