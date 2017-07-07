#Sample Karate Feature Definition Template
#More on karate here: https://github.com/intuit/karate

Feature: Sample Karate API Automation

  Scenario: Get Hello World
    Given url 'http://localhost:8080/greeting'
    When method get
    Then status 200
    And match response == { id: "#number", content: "Hello, World!" }

  Scenario: get custom greeting
    Given url 'http://localhost:8080/greeting'
    And param name = 'Koen'
    When method get
    Then status 200
    And match response == { id: '#number', content: 'Hello, Koen!' }
