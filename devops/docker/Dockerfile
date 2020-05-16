FROM gradle:latest AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle clean build --no-daemon

FROM openjdk:11-jre-slim AS run
EXPOSE 8080
COPY --from=build /home/gradle/src/build/libs/*.jar /app.jar

ENTRYPOINT ["java","-jar","/app.jar"]