Feature: Greeting Controller

  Scenario: Call service without parameters
#    Given the greeting service is running
    When the client requests /GET /greeting
    Then the response should be JSON:
    """
    {"id":1,"content":"Hello, World!"}
    """

#  Scenario: Call service without parameters
#    Given the greeting service is running
#    When the client requests /GET /greeting
#    Then the response should be JSON:
#    """
#    {"id":2,"content":"Hello, User!"}
#    """