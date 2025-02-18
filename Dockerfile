FROM openjdk:21

LABEL authors="Yacine"

WORKDIR /app

#Copie du ficher JAR recuperer de l'artefact de votre projet dans le conteneur
COPY webSpringboot-0.0.1-SNAPSHOT.jar /app/webSpringboot-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]

