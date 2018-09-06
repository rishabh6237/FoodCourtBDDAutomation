Feature: User is registered as an employee

Scenario: User Registration Scenario

Given Admin is on login page
When Admin logs in with credentials
Then Admin is on home page
Then Admin navigates to schedule tab
Then Admin Adds New Employee
Then User email is check for invite
Then User signs up as employee
