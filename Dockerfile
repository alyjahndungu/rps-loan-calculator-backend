FROM maven:3-eclipse-temurin-17 AS build
COPY . .
RUN mvn clean package -DskipTests
FROM eclipse-temurin:17-alpine
COPY --from=build /target/rps-loan-calculator-0.0.1-SNAPSHOT.jar rps-loan-calculator.jar
ENTRYPOINT ["java","-Dspring.profiles.active=render","-jar","rps-loan-calculator.jar"]
