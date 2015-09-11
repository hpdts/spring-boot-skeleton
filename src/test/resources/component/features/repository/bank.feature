Feature: CRUD operations for bank

  Scenario: Get All banks
    Given I have the following banks
      | id   | description         |
      | 0001 | Banco De Chile      |
      | 0009 | Banco Internacional |
    When I get all the banks
    Then I should have 2 banks

  Scenario: Get banks paginated
    Given I have the following banks
      | id   | description         |
      | 0001 | Banco De Chile      |
      | 0009 | Banco Internacional |
      | 0002 | Banco Estado        |
      | 0003 | Banco Santander     |
      | 0004 | Banco BCI           |
      | 0005 | Banco Scotiabank    |
      | 0006 | Banco Falabella     |
      | 0007 | Banco Ripley        |
      | 0008 | Banco De Chile      |
      | 0010 | Banco Itau          |
    And page size is 2
    When I get bank page number 2
    Then I should have 2 banks
    And one bank should be 0004
    And one bank should be 0005
    And one bank should not be 0001

  Scenario: Get banks first page
    Given I have the following banks
      | id   | description         |
      | 0001 | Banco De Chile      |
      | 0009 | Banco Internacional |
      | 0002 | Banco Estado        |
      | 0003 | Banco Santander     |
      | 0004 | Banco BCI           |
      | 0005 | Banco Scotiabank    |
      | 0006 | Banco Falabella     |
      | 0007 | Banco Ripley        |
      | 0008 | Banco De Chile      |
      | 0010 | Banco Itau          |
    And page size is 2
    When I get bank page number 0
    Then I should have 2 banks
    And one bank should be 0001
    And one bank should be 0009
    And one bank should not be 0010


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

