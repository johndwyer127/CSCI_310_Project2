Given(/^I am on the page "([^"]*)"$/) do |arg1|
  visit arg1
end

Then(/^I should see a text field named "topic"/) do
  expect(page).to have_field("topic")
end

Then(/^I should see a text field named "shape"$/) do
  expect(page).to have_field("shape")
end

Then(/^I should see a text field named "width"$/) do
  expect(page).to have_field("width")
end

Then(/^I should see a text field named "height"$/) do
  expect(page).to have_field("height")
end

Then(/^I should see a checkbox named "bordersBox"$/) do
  expect(page).to have_field("bordersBox")
end

Then(/^I should see a checkbox named "rotationsBox"$/) do
  expect(page).to have_field("rotationsBox")

Then(/^I should see a checkbox named "saveBox"$/) do
    expect(page).to have_field("saveBox")
