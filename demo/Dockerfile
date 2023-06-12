FROM openjdk:17

WORKDIR /app

COPY . .

RUN ./mvnw clean package -DskipTests

EXPOSE 8085

CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]
