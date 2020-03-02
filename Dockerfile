FROM openjdk:latest

COPY target/pdp_spring-0.0.1-SNAPSHOT.jar /usr/src/pdp_spring-0.0.1-SNAPSHOT.jar

CMD java -jar /usr/src/pdp_spring-0.0.1-SNAPSHOT.jar sg.whirl.pdp_spring.main.PdpSpringApplication