Feature: Orange HRM
  Scenario: Login to Orange HRM website

    Given I launch chrome browse
    When I open Orange HRM homepage and enter the login details
    Then  I should be able to login successfully
    And I will print the page title
    And I will close the browser
