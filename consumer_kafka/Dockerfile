FROM openjdk:17

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8084

CMD ["java", "-jar", "target/ConsumerKafka-0.0.1-SNAPSHOT.jar"]
