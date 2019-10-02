Feature: Login Testing Application

Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "artur" and passwrod "12345"
Then User accesses their profile page
And User can access his personal details

Scenario: Home Page Login
Given User is on the Home Page
When User logs in with a username "henry" and passwrod "pass"
Then User accesses their profile page
And User cannot access all personal details