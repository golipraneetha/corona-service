FROM adoptopenjdk/openjdk11:alpine-slim
ARG JAR_FILE=target/corona-tracker-*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENV SPRING_PROFILES_ACTIVE=default
ENTRYPOINT ["java","-jar","/app.jar"]