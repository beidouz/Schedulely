# Schedulely

[![Build Status](https://travis-ci.org/codecentric/springboot-sample-app.svg?branch=master)](https://travis-ci.org/codecentric/springboot-sample-app)
[![License](http://img.shields.io/:license-apache-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html)

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Live Application deployed on AWS
- [Schedulely](http://schedulely.us-east-2.elasticbeanstalk.com/home)

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. 

One way is to execute the `main` method in SchedulelyApp.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## View the application locally

Home page `http://localhost:8080/home` 

Admin page `http://localhost:8080/admin`

Swagger UI `http://localhost:8080/swagger-ui.html#/`

## Flow Diagram
https://drive.google.com/file/d/1XcOMJ_Y0NCC6Escnwe6twRwWzQQxBTc5/view?usp=sharing

## SQL Diagram
https://dbdiagram.io/d/61dca25bf8370f0a2eef572e

## Trello Board
https://trello.com/b/fULQZQbD/scheduley
