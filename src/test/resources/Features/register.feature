@EcommerceRegister
Feature: Registration to ecommerce site
  Scenario: Register a new user into ecommerce site

    Given I launch chrome browse
    When I open nopcommerce homepage and select new user
    And I enter the valid details to register and click on register
    Then  I should be able to register successfully