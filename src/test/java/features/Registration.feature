Feature: Registration Testing Application

# Usage of Data Table for multiple parameters
@SmokeTest
Scenario: Home Page Registration
Given User is on the Home Page
When User register with following details
| jenny | jenny123 | jenny123@gmail.com | England |
| andy | andy26 | andy@gmail.com | Scotland |
| mark | mark88 | mark88@gmail.com | Wales |
Then User accesses their profile page
And User can access all personal details: "true"