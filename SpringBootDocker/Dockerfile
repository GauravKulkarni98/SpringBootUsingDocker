FROM openjdk:11
ADD target//SpringBootDocker/target/day20_spring_mvc_hibernate-0.0.1-SNAPSHOT.war day20_spring_mvc_hibernate-0.0.1-SNAPSHOT.war
EXPOSE 8085
ENTRYPOINT ["java","-war","day20_spring_mvc_hibernate-0.0.1-SNAPSHOT.war"]