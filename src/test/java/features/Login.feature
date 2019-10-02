Feature: Login Testing Application

Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "artur" and passwrod "12345"
Then User accesses their profile page
And User can access all personal details: "true"

Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "henry" and passwrod "pass"
Then User accesses their profile page
And User can access all personal details: "false"

# Usage of Data Table for multiple parameters
Scenario: Home Page Registration
Given User is on the Home Page
When User register with following details
| jenny | jenny123 | jenny123@gmail.com | England |
| andy | andy26 | andy@gmail.com | Scotland |
| mark | mark88 | mark88@gmail.com | Wales |
Then User accesses their profile page
And User can access all personal details: "true"

# Usage of Parameterisation
Scenario Outline: Home Page Login
Given User is on the Home Page
When User logs in with a username <username> and password <password>
Then User accesses their profile page
And User can access all personal details: "true"

Examples:
| username | password |
| john | john1 |
| anna | anna2 |
| kate | kate3 |