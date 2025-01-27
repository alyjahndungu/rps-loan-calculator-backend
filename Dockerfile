## Importing JDK and copying required files
#FROM openjdk:17-jdk-alpine AS build
#WORKDIR /app
#COPY pom.xml .
#COPY src src
#
## Copy Maven wrapper
#COPY mvnw .
#COPY .mvn .mvn
#
## Set execution permission for the Maven wrapper
#RUN chmod +x ./mvnw
#RUN ./mvn clean package -DskipTests
#
## Stage 2: Create the final Docker image using OpenJDK 17 Alpine
#FROM openjdk:17-jdk-alpine
#VOLUME /tmp
#
## Copy the JAR from the build stage
#COPY --from=build /app/target/*.jar app.jar
#ENTRYPOINT ["java","-jar","/rps-loan-calculator-0.0.1-SNAPSHOT.jar"]
#EXPOSE 8085


FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-alpine
COPY --from=build /target/rps-loan-calculator-0.0.1-SNAPSHOT.jar rps-loan-calculator.jar
ENTRYPOINT ["java","-Dspring.profiles.active=render","-jar","rps-loan-calculator.jar"]
EXPOSE 8085
