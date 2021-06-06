FROM openjdk:8-jdk-alpine
RUN apk add skopeo && ln -s /usr/bin/skopeo /skopeo
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]