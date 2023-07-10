Feature: Login functionality

Scenario Outline: Login with valid credentials
Given User navigates to login page
When User enters valid email address <username> into email field
And User enters valid password <password> into password field
And User clicks on login button
Then User should login successfully
Examples:
|username             |password|
|jeevasai707@gmail.com|12345   |
|amotooricap1@gmail.com|12345  |
|amotooricap2@gmail.com|12345  |
|amotooricap3@gmail.com|12345  |

Scenario: Login with invalid credentials
Given User navigates to login page
When User enters invalid email address into email field
And User enters invalid password "1234" into password field
And User clicks on login button
Then User should get proper warning message like invalid credentials

Scenario: Login with valid email and invalid password
Given User navigates to login page
When User enters valid email address "amotooricap9@gmail.com" into email field
And User enters invalid password "12345678" into password field
And User clicks on login button
Then User should get proper warning message like invalid credentials

Scenario: Login with invalid email and valid password 
Given User navigates to login page
When User enters invalid email address into email field
And User enters valid password "12345" into password field
And User clicks on login button
Then User should get proper warning message like invalid credentials

Scenario: Login with empty credentials
Given User navigates to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on login button
Then User should get proper warning message like invalid credentials