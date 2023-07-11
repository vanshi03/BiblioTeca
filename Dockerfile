FROM openjdk:17
ARG VERSION=0.0.1-SNAPSHOT
COPY BiblioTeca-${VERSION}.jar BiblioTeca.jar
EXPOSE 8080
ENTRYPOINT ["/bin/sh", "-c", "java -jar BiblioTeca.jar"]
