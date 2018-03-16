FROM maven:3.3.9-jdk-8

WORKDIR /code
COPY *.xml /code/
COPY src /code/src
RUN ["mvn", "clean", "package"]

EXPOSE 8080
CMD ["java", "-jar", "target/jersey-grizzly-jar-with-dependencies.jar"]

