Given(/^I am on the collage display page$/) do
  visit 'http://localhost:8080/CSCI310Project1/CollageDisplay.jsp'
end

Then(/^I should see an export as png button$/) do
    expect(page).find_by_id('exportButtonPNG').value = "exportButtonPNG"
  # expect(page).to have_selector("button", :id =>"exportButtonPNG")
end

Then(/^I should see an export as pdf button$/) do
  expect(page).to have_selector("button", :id =>"exportButtonPDF")
end

Then(/^I should have a secure connection$/) do
  expect(page).to have_current_path("https", url: true)
end

Then(/^I should see a gallery for past collages created$/) do
  expect(page).to have_selector("div", :id =>"previousCollage")
end
