require 'selenium-webdriver'

Given(/^I am on Collage homepage$/) do
	@browser = Selenium::WebDriver.for :chrome
	@browser.navigate.to 'http://google.com'
	# @browser.navigate.to 'http://localhost:8080/CSCI310Project1/InputServlet.jsp'
	# visit 'http://localhost:8080/CSCI310Project1/InputServlet.jsp'
end

When /^I add "(.*)" to the search box$/ do |item|
  @browser.find_element(:name, 'q').send_keys(item)
end
#
# And /^click the Search Button$/ do
#   @browser.find('input[type="submit"]').click
# end
#
# Then /^"(.*)" should be mentioned in the results$/ do |item|
#   @browser.title.should include(item)
#   @browser.quit
# end
