# Etapa de construcción
#[builder 1/8]
FROM openjdk:17-alpine as builder

#[builder 2/8]
WORKDIR /app/api-rest

#[builder 3/8]
COPY ./pom.xml .

#[builder 4/8]
RUN apk --no-cache add maven

#[builder 5/8]
RUN mvn dependency:purge-local-repository

# Compilación sin ejecutar las pruebas
#[builder 6/8]
RUN mvn clean package -Dmaven.test.skip=true -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/


#[builder 7/8]
COPY ./src/ ./src

# Compilación final
#[builder 8/8]
RUN mvn clean package -Dmaven.test.skip=true

# Etapa de construcción final
FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY --from=builder /app/api-rest/target/app.jar .

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "app.jar"]

