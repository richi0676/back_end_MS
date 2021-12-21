FROM maven as billing
COPY . /billingservice/

WORKDIR /billingservice

RUN mvn package -Dmaven.test.skip

FROM openjdk
COPY --from=billing /billingservice/target/*.jar /billingservice/app.jar
EXPOSE 9090

#s'execute au lancement de l'image d'un container de l'image (docker run)
CMD ["java", "-jar", "/billingservice/app.jar"]