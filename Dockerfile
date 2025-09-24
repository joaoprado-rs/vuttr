FROM openjdk:25-oracle
COPY target/vuttr-0.0.1-SNAPSHOT.jar application.jar
ENTRYPOINT ["java", "-jar", "application.jar"]
