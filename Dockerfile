FROM openjdk:17-jdk-alpine as builder

WORKDIR /app/api-rest

COPY ./.mvn ./.mvn
COPY ./mvnw .
COPY ./pom.xml .

RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/

COPY ./src/ ./src
RUN ./mvnw clean package -DskipTests

FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/api-rest/target/app.jar .
EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]