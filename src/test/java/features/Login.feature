Feature: Login Testing Application

# Usage of Parameterisation
#@SeleniumTest
Scenario Outline: Successfull User Login using Parameterisation
Given User is on the Home Page
When User logs in with a username <username> and password <password>
Then User accesses their profile page "true"

Examples:
| username 				| password |
| artur123@gmail.com 	| pass1    |
| andy654321@gmail.com  | pass1    |

# This Login example uses Excel Data Driven to retrieve login credentials from the Excel file
@SeleniumTest
Scenario: Successful User Login using Excel Data Driven API
Given User is on the Home Page
When User logs in with credentials retrieved from the Excel file
Then User accesses their profile page "true"

# This Login example uses JDBC Connection to DB to get login credentials
#@SeleniumTest
Scenario: Successful User Login using MySql DB
Given User is on the Home Page
When User logs in with credentials retrieved from DB
Then User accesses their profile page "true"

# User Login Failure
#@SeleniumTest
Scenario Outline: User Login Failure using Parameterisation
Given User is on the Home Page
When User logs in with a username <username> and password <password>
Then User accesses their profile page "false"

Examples:
| username 				| password 	  |
| emma@gmail.com 		| emma1234    |
| izabelle@gmail.com    | iza123456   |
