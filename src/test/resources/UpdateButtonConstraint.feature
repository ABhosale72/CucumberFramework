Feature: Update button in config page is used to save changes

  Scenario Outline: Changes in the address field and site details will trigger constraint message

    When user is inside the commerce page
    Then he clicks the add button
    And he chooses ethernet hub in the product list page
    Then he is inside the config page
    Then he enters the "<address 1>" into the field
    Then he does connectivity check
    Then he should be seeing three tabs
    Then he enters the other "<address 2>" into the field
    Then he should see the "<message>"

    Examples:
    | address 1                                          | address 2                   | message                                                                                |
    | 3, Julius-Tandler-Platz, Wien, Austria, Wien, 1090 | 16 Rue Friant Paris, France | Message: Some of the fields have been changed. Click on Check Connectivity to continue |
