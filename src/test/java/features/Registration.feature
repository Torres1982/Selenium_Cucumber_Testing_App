Feature: Registration Testing Application

Background:
Given User is not registered
When User click the Registration Button
Then The Error Message is displayed
And User is redirected to the login page

# Usage of Data Table for multiple parameters
#@SeleniumTest
Scenario: User Registration
Given User is on the Home Page
When User register with following details
| Artur  | Torres | artur123@gmail.com | 0876451325 | Wojska Polskiego 8  | 0876451325 | Gdansk | pass1 | pass1  |
#| andy  | green  | andy@gmail.com     | 0833271845 |
#| mark  | slater | mark88@gmail.com   | 0856251727 |

Then User accesses their profile page