# Use an official OpenJDK runtime as a parent image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /usr/src/app

# Copy the Gradle Wrapper files to the container
COPY gradlew ./
COPY gradle ./gradle

# Copy the build.gradle and settings.gradle files to cache dependencies
COPY build.gradle settings.gradle ./

# Copy the application source code
COPY src ./src

# Install a JDK to compile the code (adjust version as needed)
RUN apt-get update && apt-get install -y openjdk-11-jdk

# Set the JAVA_HOME environment variable
ENV JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64

# Run Gradle to download dependencies and build the application
RUN ./gradlew build

# Copy the application JAR file
COPY build/libs/Gerenciador-de-membros-0.0.1-SNAPSHOT.jar ./

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "Gerenciador-de-membros-0.0.1-SNAPSHOT.jar"]
