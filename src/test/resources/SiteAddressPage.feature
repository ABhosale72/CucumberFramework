Feature: Site Address page

  Scenario: Site Address page validations

    Given I have logged into CPQ
    Then I click on add product and select HUB
    When I am inside config page
    Then currency should be same as the one in commerce page
    Then update, start over, cancel configuration buttons should be present
    Then hub site details drop down should populate entry fields with proper message
    Then Google should show suggestions in drop down for entered address
    Then user should be able to select the address
    And address drop down fields should get populated
    And check connectivity button should get generated
    And Site Details, Features tab should not be present
    When check connectivity button is clicked it should generate three tabs
    When new address is selected it should show message to recheck connectivity


