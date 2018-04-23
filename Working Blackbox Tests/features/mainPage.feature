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

Scenario: Collage matches topic and shape input

		When I enter "dog" into the topic box
		And I enter "usc" into the shape box
		And press Build Collage
	  Then I should see a collage for the topic "dog" and in the shape of "usc"
