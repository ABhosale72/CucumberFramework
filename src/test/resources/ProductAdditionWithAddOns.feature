Feature: Building types are specific to addresses used

  Scenario Outline: Correct building types are shown for relevant address

    When user has logged into CPQ
    And user clicks add button
    Then he selects "<product>" on the product page
    Then he is on the config page
    And he enters the "<address>" on the  page
    Then he clicks on check connectivity button
    Then he should see three tabs of site address, site details and features
    Then he moves to site details
    And he chooses "<bandwidth>" bandwidth
    Then he chooses "<resiliency>" resiliency
    Then building type should be "<type>"
    Then end address should be "<address>"
    Then he should see base price table
    Then he click on features
    And chooses OBH
    Then he clicks save to quote
    Then he should be in CPQ

    Examples:
    | product | address                                                                   | bandwidth | resiliency | type            |
    | hub     | 3, Julius-Tandler-Platz, Wien, Austria, Wien, 1090                        | 1 Gbps    | Protected  | Retail Building |
    | hub     | 34, Rue des Gardinoux, Aubervilliers, France, Île-de-France, 93300        | 1 Gbps    | Gold       | DC- Standard    |
    | hub     | 93, Avenue du Prado, Marseille, France, Provence-Alpes-Côte d'Azur, 13008 | 1 Gbps    | Platinum   | DC - Key        |

