# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY . /app
RUN javac App.java
CMD ["java","App"]