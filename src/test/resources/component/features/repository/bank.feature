Feature: CRUD operations for bank

  Scenario: Get All banks
    Given I have the following banks
      | id   | description         |
      | 0001 | Banco De Chile      |
      | 0009 | Banco Internacional |
    When I get all the banks
    Then I should have 2 banks

  Scenario: Search Bank by name
    Given I have the following banks
      | id   | description         |
      | 0001 | Banco De Chile      |
      | 0009 | Banco Internacional |
    When I search by bank with Chile
    Then I should have 1 banks
    And I should have bank description as "Banco De Chile"

  Scenario: Search Banks by name
    Given I have the following banks
      | id   | description         |
      | 0001 | Banco De Chile      |
      | 0009 | Banco Internacional |
      | 0011 | BCI                 |
    When I search by bank with Banco
    Then I should have 2 banks

  Scenario: Get All banks sorted
    Given I have the following banks
      | id   | description         |
      | 0003 | Banco De Chile      |
      | 0009 | Banco Internacional |
      | 0001 | Banco Internacional |
    When I get all the banks sorted by id
    Then I should have 2 banks
    And the first one is 0001

  Scenario: Get banks paginated
    Given I have the following banks
      | id   | description         |
      | 0003 | Banco De Chile      |
      | 0009 | Banco Internacional |
      | 0004 | BCI                 |
      | 0005 | Banco estado        |
      | 0006 | Banco Paris         |
      | 0007 | Banco Falabella     |
      | 0008 | Scotiabank          |
      | 0010 | Banco Viña          |
    When I get banks paginated from 2 to 4
    Then I should have 2 banks
    And the first one is 0004