# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine
# copy WAR into image
#COPY fullstackapp-0.0.1-SNAPSHOT.jar /app.jar
COPY target/fullstackapp-0.0.1-SNAPSHOT.jar /app.jar
# run application with this command line
CMD ["java", "-jar", "-Dspring.profiles.active=fullstackapp", "/app.jar"]