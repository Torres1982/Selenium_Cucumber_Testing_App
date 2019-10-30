Feature: Logout Testing Application

@SeleniumTest
Scenario: User Logs out of the Profile page
Given User is on the Home Page
When User logs in with credentials retrieved from the Excel file
Then User accesses their profile page
And User logs out
Then the Login Page should display