Feature: Login Testing Application

@WebTest
Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "artur123@gmail.com" and passwrod "pass1"
Then User accesses their profile page
And User can access all personal details: "true"

@MobileTest
Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "henry" and passwrod "pass"
Then User accesses their profile page
And User can access all personal details: "false"

# Usage of Parameterisation
@SmokeTest
Scenario Outline: Home Page Login
Given User is on the Home Page
When User logs in with a username <username> and password <password>
Then User accesses their profile page
And User can access all personal details: "true"

Examples:
| username | password |
| artur123@gmail.com | pass1 |
#| anna | anna2 |
#| kate | kate3 |