#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:8-jre-slim
COPY --from=build /home/app/target/micro-imdb.jar /usr/local/lib/micro-imdb.jar
EXPOSE 8089
ENTRYPOINT ["java","-jar","/usr/local/lib/micro-imdb.jar"]
