Feature: Hello

  Scenario: It should get a greeting message from Hello controller
    Given my application is running
    When I hit hello controller
    Then I get a 200
    And I see "Greetings from Spring Boot!" as a message from the controller