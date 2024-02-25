# Build Stage
FROM amazoncorretto:17.0.10-alpine3.19 AS build
WORKDIR /app
COPY . .
RUN ./gradlew wrapper
RUN ./gradlew build -x test

# Prod Stage
FROM amazoncorretto:17.0.10-alpine3.19
COPY --from=build /app/build/libs/dev-task-api-0.0.2-SNAPSHOT.jar /app/application.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/application.jar"]