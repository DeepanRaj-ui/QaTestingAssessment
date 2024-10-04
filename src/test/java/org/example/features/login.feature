Feature: Login functionality

  Scenario:Verifying the Login Functionality
    Given I navigate to login Page and logged in using valid credentials
    Then User verifies logged in successfully


  Scenario:Verifying to add the User in the Portal
    Given I navigate to login Page and logged in using valid credentials
    Then User verifies logged in successfully
    Then User click admin from side bar
    And User click add button
    And User click user role from the drop down


