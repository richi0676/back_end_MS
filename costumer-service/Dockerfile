FROM maven as customer
COPY . /customerservice/

WORKDIR /customerservice

RUN mvn package -Dmaven.test.skip

FROM openjdk
COPY --from=customer /customerservice/target/*.jar /customerservice/app.jar
EXPOSE 9090

#s'execute au lancement de l'image d'un container de l'image (docker run)
CMD ["java", "-jar", "/customerservice/app.jar"]