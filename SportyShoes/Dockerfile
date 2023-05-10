FROM openjdk:17-slim
COPY target/SportyShoes-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.datasource.url = jdbc:mysql://52.207.135.229:3306/newdb","app.jar"]