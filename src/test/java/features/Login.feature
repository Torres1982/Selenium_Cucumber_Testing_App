Feature: Login Testing Application

# Usage of Parameterisation
#@SeleniumTest
Scenario Outline: User Login
Given User is on the Home Page
When User logs in with a username <username> and password <password>
Then User accesses their profile page

Examples:
| username 				| password |
| artur123@gmail.com 	| pass1    |
#| andy654321@gmail.com | pass1    |