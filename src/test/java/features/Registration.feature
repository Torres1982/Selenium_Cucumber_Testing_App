Feature: Registration Testing Application

# Usage of Data Table for multiple parameters
#@SeleniumTest
Scenario: Successful User Registration
Given User is on the Home Page
When User register with following details
#| Artur  | Torres | artur123@gmail.com | 0876451325 | Wojska Polskiego 8  | 0876451325 | Gdansk   	| pass1 | pass1 |
#| Mick   | Malloy  | mick654321@gmail.com | 0859264823 | 5 Green Hills Rd    | 0859264823 | Waterford | pass1 | pass1 |
| Andy   | Sterns  | andy197535@gmail.com | 0876253811 | 74 Ford Avenue    	 | 0876253811 | Galway    | pass1 | pass1 |

Then User accesses their profile page "true"

@SeleniumTest
Scenario: User Registration Failure - Required Fields Empty
Given User is on the Home Page
When User register with following details
||||||||||

Then User accesses their profile page "false_registration_empty_fields"