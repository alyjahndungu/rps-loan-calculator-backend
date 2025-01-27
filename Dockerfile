# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the source code to the container
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose port 2025
EXPOSE 2025

# Run the application
ENTRYPOINT ["java", "-jar", "/app/target/rps-loan-calculator.jar"]
