@product
Feature: Verifying flipkart Module

  Scenario Outline: Verifying flipkart Module
    Given User is on the flipkart page
    When User login with phone number "<mobileNo>"
    Then User should verify after navigate to home page and verify My account is present in the catalog "Account"
    When User seach product "<productName>"
    Then User should verify same product listed in the search option  "<productName>"
    When User add the product into cart
    And User add the delivery address "<name>","<mobileNo>","<pinCode>","<locality>","<address>" and "<addressType>"
    And User enter the order confirmation details "<emailId>"
    And User enter the payment details "<cardNo>","<month>","<year>" and "<cvv>"
    And User logout from the application
    Then User should verify "Login" text to check if user is  successfully logout 

    Examples: 
      | mobileNo   | productName | name    | pinCode | locality | address                         | addressType | emailId                    | cardNo           | month | year | cvv |
      | 9962313925 | Iphone      | Nivetha |  600095 | Chennai  | City Centre Mall, Krishna Nagar | Home        |nivedhathangiah@gmail.com| 4017041082072656 |    11 |   29 | 123 |
