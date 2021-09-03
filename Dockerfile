FROM openjdk:8jdk-slim
COPY "./application/app-service/build/libs/app.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
