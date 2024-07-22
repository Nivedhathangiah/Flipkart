@register
Feature: Verifying User Registration Module

  Scenario Outline: Verifying User Registration Module
    Given User is on the flipkart page
    When User navigate to flipkart registration page
    And User enters phone number "<mobileNo>" to register
    Then User should verify after navigate to home page and verify My account is present in the catalog "Account"

    Examples: 
      | mobileNo   |
      | 9042753367 |
