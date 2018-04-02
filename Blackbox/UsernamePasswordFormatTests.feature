Feature: UsernameAndPassword Formatting Tests

Background:

	Given I am on the page "http://localhost:8080/CSCI310Servlet1.0/driver?login=text"

Scenario: Username and Password Formatting

        Then I should see a field "username"

        And I should see a field "password"
