Feature: Address field has certain fields which are mandatory

  Scenario: Absence of any mandatory field throws warning message and connectivity cannot be checked

    When user is inside CPQ
    Then user clicks on the add button
    And user chooses ethernet hub and is inside config page
    And he can enter the address in the address entry and choose google suggestion
    Then he can see check connectivity button
    Then he clicks on the detail dropdown and removes mandatory building number field
    Then there should be a warning message about mandatory field
    Then there should be no check connectivity button
