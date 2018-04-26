Feature: Commerce Page gets populated with the complete details from the account in C4C

  Scenario: Correct details should be populated in the Commerce Page

    When User login to CPQ
    Then Opportunity ID should be populated
    And User sees Opportunity Name
    And Opportunity Name should be either New Business or Existing Business
    And Opportunity created by should be populated
    And Technical complexity should be either 01 or 02
    And Legal Complexity should be Standard or Non-Standard
    And Deal class should be either gold, silver or bronze
    And go0 approval should either be Y or N