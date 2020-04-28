FROM gradle:jdk11

COPY . .

RUN ./gradlew build

EXPOSE 8080

ENTRYPOINT ["java", "-jar" ,"build/libs/recipe-api-0.0.1-SNAPSHOT.jar"]