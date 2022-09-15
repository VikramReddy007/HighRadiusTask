Feature: Test 2

  Scenario: Elemental Selenium link click on Herokuapp

    Given I open the herokuapp website
    When I click on Dropdown Link
    And Select option 2 in dropdown and validate if the option is selected
    When I click on Elemental Selenium and new tab is opened
    Then Assert that "Elemental Selenium" text is displayed