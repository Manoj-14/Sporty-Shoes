FROM openjdk:17-slim
COPY target/SportyShoes-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.datasource.url = jdbc:mysql://3.86.167.195:3306/newdb","app.jar"]