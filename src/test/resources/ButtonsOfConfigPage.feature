Feature: Buttons of config page

  Scenario: Cancel Configuration Button should be working

    When user is in CPQ
    Then add product is clicked
    And user selects Hub
    And user clicks on "cancel" config button
    Then he should be back in CPQ

  Scenario: Start Over Button should be working

      When user is in CPQ
      Then add product is clicked
      And user selects Hub
      And user clicks on "start over" config button
      Then he should be back in CPQ