Given(/^I am on the home page$/) do
  visit "http://localhost:8080/CSCI310Servlet1.0/driver?login=text"
end

Then(/^I should see a field "([^"]*)"$/) do |arg1|
  page.find_by_id('username').should == arg1
end

Then(/^I should see a field "([^"]*)"$/) do |arg1|
  page.find_by_id('password').should == arg1
end
