# Stage 1: Build the Spring Boot application
FROM maven:3.8.5-openjdk-17 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
RUN mvn -f /usr/src/app/pom.xml package -DskipTests

# Stage 2: Create the Docker image
FROM openjdk:17-jdk-slim
COPY --from=build /usr/src/app/target/vehicleservice-0.0.1-SNAPSHOT.jar /usr/app/vehicleservice-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/vehicleservice-0.0.1-SNAPSHOT.jar"]
