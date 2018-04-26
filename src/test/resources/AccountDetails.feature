Feature: Account Details should be present in Commerce Page

  Scenario: Commerce page fields should be populated with details of the account

    When user logs into CPQ
    Then user should be able to see OCN Number
    And user should be able to see Account Name
    And user should be able to see Account Address
    And user should be able to see Pricing Segment
