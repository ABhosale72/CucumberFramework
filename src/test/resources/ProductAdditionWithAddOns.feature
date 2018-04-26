Feature: Hub can be added by Sales User

  Scenario: CPQ can be used to add the products

    When user has logged into CPQ
    And user clicks add button
    Then he selects "<product>" on the product page
    Then he is on the config page
    And he enters the "<address>" on the  page
    Then he clicks on check connectivity button
    Then he should see 3 tabs of site address, site details and features
    Then he moves to site details
    And he chooses "<bandwidth>"
    Then he chooses "<resiliency>"
    Then he should see base price table
    Then he click on features
    And chooses OBH
    Then he should see base price and obh in the table below
    Then he clicks save to quote
    Then he should be in CPQ

    Examples
    | product | address                                      | bandwidth | resiliency |
    | hub     | 3, Julius-Tandler-Platz, Wien, Austria, Wien | 1 Gbps    | Protected  |
    | hub     | 3, Julius-Tandler-Platz, Wien, Austria, Wien | 1 Gbps    | Gold       |
    | hub     | 3, Julius-Tandler-Platz, Wien, Austria, Wien | 1 Gbps    | Platinum   |
