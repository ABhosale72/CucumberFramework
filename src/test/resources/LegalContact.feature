Feature: Commerce page carries legal contact details of the account

  Scenario: Legal contact details get populated in the commerce page

    When logged into CPQ
    Then user should see first name
    Then user should see last name
    Then user should see email
    Then user should see phone number
    And user should see address