Feature: Task1
  @testone
  Scenario: Add user successfully
    Given Login to opensource website
    And Go to admin tab
    When I click on Admin tab to add user
    And Enter values in all required fields and click Add
    Then Verify Success message
