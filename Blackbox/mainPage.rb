Given(/^I am on the page "([^"]*)"$/) do |arg1|
  visit arg1
end

Then(/^I should see a text field "([^"]*)"$/) do |arg1|
  page.find_by_id('topic').should == arg1
end

Then(/^I should see a text field "([^"]*)"$/) do |arg1|
  page.find_by_id('shape').should == arg1
end

Then(/^I should see a select field named "([^"]*)"$/) do |arg1|
  page.find_by_id('options').should == arg1
end

Then(/^I should see a button named "([^"]*)"$/) do |arg1|
  page.find_by_id('save').should == arg1
end

Then(/^I should see a button named "([^"]*)"$/) do |arg1|
  page.find_by_id('build').should == arg1
end
