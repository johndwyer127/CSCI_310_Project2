Feature: Find website

Scenario: Search for website
	Given I am on Collage homepage
	When I add "cats" to the search box
	And click the Search Button
	Then "cats" should be mentioned in the results
