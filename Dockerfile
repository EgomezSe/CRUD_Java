FROM openjdk:8-jdk-slim
COPY "./target/ControlClientes-1.0.jar" "app.jar"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
