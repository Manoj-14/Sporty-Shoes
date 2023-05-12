FROM openjdk:17-slim
COPY target/SportyShoes-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","-Dspring.datasource.url = jdbc:mysql://34.239.133.5:3306/newdb","app.jar"]