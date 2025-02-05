FROM openjdk:23

WORKDIR /app

COPY target/onlineshop-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app/app.jar"]