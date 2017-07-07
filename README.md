# Getting started with REST Service and Spring

## Description
Practice building a REST Web Service with Spring from tutorial:
https://spring.io/guides/gs/rest-service/

## How to run the project
If you are using Maven, you can run the application using 'mvn spring-boot:run'. 
Or you can build the JAR file with 'mvn clean package'. 

Then you can run the JAR file:
'java -jar target/gs-rest-service-0.1.0.jar'

## How to test the service
Once the project is running, go to: http://localhost:8080/greeting
Expected result: `{"id":1,"content":"Hello, World!"}`

Provide a name query string parameter with http://localhost:8080/greeting?name=User
Expected result: `{"id":2,"content":"Hello, User!"}`

## How to test the service using cucumber from IntelliJ
* Install the Cucumber for java plugin in IntelliJ
* Edit run configurations: set Glue to "cucumber.stepdefs"
* Run the feature file
