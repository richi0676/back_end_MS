FROM maven as eureka
COPY . /eurekaservice/

WORKDIR /eurekaservice

RUN mvn package -Dmaven.test.skip

FROM openjdk
COPY --from=eureka /eurekaservice/target/*.jar /eurekaservice/app.jar
EXPOSE 9090

#s'execute au lancement de l'image d'un container de l'image (docker run)
CMD ["java", "-jar", "/eurekaservice/app.jar"]