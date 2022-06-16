Feature: Test Supplier login functionality
         As a User to be able to use supplier functionality
         I want to be able to successfully login to supplier
Background:
    Given I am on login page
    
@test
Scenario Outline: Validate if the user can login into supplier account
    When I login with valid user credentials
    |userRole|<userRole>|
    Then I can login successfully
    Examples:
    |userRole|
    |SUPPLIER|