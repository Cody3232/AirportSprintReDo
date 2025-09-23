# Use an official Java 23 JDK as the base image
FROM eclipse-temurin:23-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR file from your target directory into the container
COPY target/AirportSprintReDo-1.0-SNAPSHOT.jar app.jar

# Expose port 8080 (Spring Boot runs on 8080 by default)
EXPOSE 8080

# Command to run your Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
