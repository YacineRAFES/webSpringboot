FROM openjdk:21

ENV FR.AFPA.POMPEY.APPWEB.APIURL=http://API:9001

LABEL authors="Yacine"

WORKDIR /app

#Copie du ficher JAR recuperer de l'artefact de votre projet dans le conteneur
COPY target/AppWeb-0.0.1-SNAPSHOT.jar /app/AppWeb-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "AppWeb-0.0.1-SNAPSHOT.jar"]

