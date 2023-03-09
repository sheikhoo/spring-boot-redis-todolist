FROM openjdk:17.0.1-jdk-slim AS builder
COPY . /app
WORKDIR /app
RUN ./mvnw clean package -DskipTests

FROM gcr.io/distroless/java17-debian11
COPY --from=builder /app/target/*.jar  /app/app.jar
WORKDIR /app
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]