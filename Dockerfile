## Alpine Linux with OpenJDK JRE
#FROM openjdk:8-jre-alpine
## copy WAR into image
##COPY fullstackapp-0.0.1-SNAPSHOT.jar /app.jar
#COPY buildoutput/fullstackapp-0.0.1-SNAPSHOT.jar /app.jar
## run application with this command line
#CMD ["java", "-jar", "-Dspring.profiles.active=fullstackapp", "/app.jar"]

FROM maven:3.6.3-jdk-8-openj9
COPY . /app
WORKDIR /app
RUN mvn -P fullstackapp clean install package
CMD ["sh", "-c", "java -jar -Dspring.profiles.active=fullstackapp -Xms256m -Xmx768m ./buildoutput/fullstackapp-0.0.1-SNAPSHOT.jar"]
