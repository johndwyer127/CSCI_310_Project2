Given(/^I am on the collage display page$/) do
  visit #put servlet address here
end

Then(/^I should see an export as png button$/) do
  expect(page).to have_selector("button", :id =>"exportButtonPNG")
end

Then(/^I should see an export as pdf button$/) do
  expect(page).to have_selector("button", :id =>"exportButtonPDF")
end

Then(/^I should have a secure connection$/) do
  expect(page).to have_current_path("https", url: true)
end

Then(/^I should see a gallery for past collages created$/) do
  expect(page).to have_selector("div", :id =>"previousCollage")
