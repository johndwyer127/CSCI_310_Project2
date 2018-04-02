Given(/^I am on the page "([^"]*)"$/) do |arg1|
  visit arg1
end

Then(/^I should see a field "([^"]*)"$/) do |arg1|
  page.find_by_id('username').should == arg1
end

Then(/^I should see a field "([^"]*)"$/) do |arg1|
  page.find_by_id('password').should == arg1
end
