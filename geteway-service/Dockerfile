FROM maven as gateway
COPY . /gatewayservice/

WORKDIR /gatewayservice

RUN mvn package -Dmaven.test.skip

FROM openjdk
COPY --from=gateway /gatewayservice/target/*.jar /gatewayservice/app.jar
EXPOSE 8888

#s'execute au lancement de l'image d'un container de l'image (docker run)
CMD ["java", "-jar", "/gatewayservice/app.jar"]