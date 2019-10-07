Feature: Search and Place Orders for Clothes

Scenario: Search for items and validate the result
Given User is on the eBay main page
When User search for "Shoes" items
Then "Shoes" results are displayed on the page

@SeleniumTest
Scenario: Select the item and navigate to a Checkout page
Given User is on the eBay main page
When User search for "Nike" items
Then "Nike" results are displayed on the page
And User proceeded to the Checkout page to buy the items
Then verified selected "Nike" items are displayed on the Checkout page