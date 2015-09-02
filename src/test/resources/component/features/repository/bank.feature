Feature: CRUD operations for bank

  Scenario: Get All banks
    Given I have the following banks
      | id    | description         |
      | 0001  | Banco De Chile      |
      | 0009  | Banco Internacional |
    When I get all the banks
    Then I should have 2 banks