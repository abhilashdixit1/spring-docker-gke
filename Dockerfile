FROM openjdk:11-jdk
VOLUME /tmp
COPY target/docker-kubernetes-gke-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]