Feature: Main Page

Background:

	Given I am on the main page

Scenario: Topic Box

	Then I should see a text field named "topic"

Scenario: Shape Box

	Then I should see a text field named "shape"

Scenario: Collage Width

	Then I should see a text field named "width"

Scenario: Collage Height

	Then I should see a text field named "height"

Scenario: Borders Box

	Then I should see a checkbox named "bordersBox"

Scenario: Rotation Box

	Then I should see a checkbox named "rotationsBox"

Scenario: Save Box

	Then I should see a checkbox named "saveBox"

Scenario: Collage matches topic input

	  Then I should see a collage that matches the topic input
