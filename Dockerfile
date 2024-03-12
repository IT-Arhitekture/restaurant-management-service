FROM openjdk:17-oracle

COPY build/libs/restaurant-management-service-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","/app.jar"]