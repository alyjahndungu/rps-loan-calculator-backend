# Importing JDK and copying required files
FROM openjdk:17-jdk-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src src

# Copy Maven wrapper
COPY mvnw .
COPY .mvn .mvn

# Set execution permission for the Maven wrapper
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

# Stage 2: Create the final Docker image using OpenJDK 17 Alpine
FROM openjdk:17-jdk-alpine
VOLUME /tmp

# Copy the JAR from the build stage
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java","-jar","/rps-loan-calculator-0.0.1-SNAPSHOT.jar"]
EXPOSE 8085