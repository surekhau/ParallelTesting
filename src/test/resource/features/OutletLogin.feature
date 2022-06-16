Feature: Test Outlet login functionality
         As a User to be able to use Outlet functionality
         I want to be able to successfully login to Outlet
Background:
    Given I am on login page
    
@test
Scenario Outline: Validate if the user can login into outlet account
    When I login with valid user credentials
    |userRole|<userRole>|
    Then I can login successfully
    Examples:
    |userRole|
    |OUTLET|