FROM adoptopenjdk/openjdk11:alpine-jre
EXPOSE 8083
ARG JAR_FILE=target/cars-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]