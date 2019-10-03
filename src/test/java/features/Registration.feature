Feature: Registration Testing Application

Background:
Given User is not registered
When User click the Registration Button
Then The Error Message is displayed
And User is redirected to the login page

# Usage of Data Table for multiple parameters
@RegistrationTest
Scenario: Home Page Registration
Given User is on the Home Page
When User register with following details
| jenny | jenny123 | jenny123@gmail.com | England |
| andy | andy26 | andy@gmail.com | Scotland |
| mark | mark88 | mark88@gmail.com | Wales |
Then User accesses their profile page
And User can access all personal details: "true"