FROM openjdk:8
ADD /build/libs/uptake-vehicle-api-0.0.1-SNAPSHOT.jar uptake-vehicle-api.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","uptake-vehicle-api.jar"]
