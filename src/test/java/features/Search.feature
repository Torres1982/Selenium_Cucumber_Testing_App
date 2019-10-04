Feature: Search and Place Orders for Clothes

@SeleniumTest
Scenario: Search for items and validate the result
Given User is on the eBay main page
When User search for "shoes" items
Then "shoes" results are displayed on the page

@SeleniumTest
Scenario: Select the item and navigate to a Checkout page
Given User is on the eBay main page
When User search for "nike" items
And added the items to a cart
And User proceeded to the Checkout page to buy the items
Then verified selected items are displayed on the Checkout page