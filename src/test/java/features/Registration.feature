Feature: Registration Testing Application

# Usage of Data Table for multiple parameters
@SeleniumTest
Scenario: User Registration
Given User is on the Home Page
When User register with following details
#| Artur  | Torres | artur123@gmail.com | 0876451325 | Wojska Polskiego 8  | 0876451325 | Gdansk | pass1 | pass1  |
| Andy  | Green  | andy654321@gmail.com     | 0833271845 | 5 Permbroke Rd | 0833271845 | Kilkenny | pass1 | pass1 |
#| mark  | slater | mark88@gmail.com   | 0856251727 |

Then User accesses their profile page