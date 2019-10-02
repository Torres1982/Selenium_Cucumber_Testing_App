Feature: Login Testing Application

@RegTest
Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "artur" and passwrod "12345"
Then User accesses their profile page
And User can access all personal details: "true"

@RegTest
Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "henry" and passwrod "pass"
Then User accesses their profile page
And User can access all personal details: "false"

# Usage of Parameterisation
@RegTest
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