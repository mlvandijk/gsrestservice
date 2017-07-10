# Getting started with REST Service and Spring
This project was started when I wanted to create a simple REST service with Spring, just for practice.

## Description
Practice building a REST Web Service with Spring from tutorial:
https://spring.io/guides/gs/rest-service/

## How to run the project
If you are using Maven, you can run the application using 'mvn spring-boot:run'.

## How to test the service (manually)
Once the project is running, go to: http://localhost:8080/greeting
Expected result: `{"id":1,"content":"Hello, World!"}`

Provide a name query string parameter with http://localhost:8080/greeting?name=User
Expected result: `{"id":2,"content":"Hello, User!"}`

# Overview of some test frameworks to test REST Services
This simple service was used in a POC to compare several test frameworks for testing REST services.

## How to test the service using cucumber from IntelliJ
* Install the Cucumber for java plugin in IntelliJ
* Edit run configurations: set Glue to "cucumber.stepdefs"
* Run the feature file
Note: The application is started from the test

## How to test the service using restassured
* start the application
* run the test (HelloWorldTest.java) in the test/java/restassured folder

## How to test the service using karate
* start the application
* run the test either by running the .feature file from the test/resources folder
or by running the test file in the test/java/karate folder
