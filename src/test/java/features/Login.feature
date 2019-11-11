Feature: Login Testing Application

# Usage of Parameterisation
#@SeleniumTest
Scenario Outline: Successfull User Login
Given User is on the Home Page
When User logs in with a username <username> and password <password>
Then User accesses their profile page

Examples:
| username 				| password |
| artur123@gmail.com 	| pass1    |
#| andy654321@gmail.com | pass1    |

# This Login example uses Excel Data Driven to retrieve login credentials from the Excel file
@SeleniumTest
Scenario: Successful User Login Excel Data Driven
Given User is on the Home Page
When User logs in with credentials retrieved from the Excel file
Then User accesses their profile page