Feature: Registration Functionality

Scenario: Register with all mandatory fields
Given User navigates to register page
When User enters the details into the below fields
|firstname          |Sai|
|lastname           |Kumar|
|email              |geetha.sai10@gmail.com|
|telephone          |1234567|
|password           |12345|
And User selects privacy policy
And User clicks on continue button
Then User account should get successfully created

Scenario: Register with all fields
Given User navigates to register page
When User enters the details into the below fields
|firstname            |Sai|
|lastname             |Kumar|
|email                |saisravs8@gmail.com|
|telephone            |1234567|
|password             |12345|
And User selects yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User account should get successfully created

Scenario: Register with duplicate email address
Given User navigates to register page
When User enters the details into the below fields with duplicate email address
|firstname            |Sai|
|lastname             |Kumar|
|email                |jeevasai707@gmail.com|
|telephone            |1234567|
|password             |12345|
And User selects yes for newsletter
And User selects privacy policy
And User clicks on continue button
Then User should proper warning message email already exists

Scenario: Register by not providing any details
Given User navigates to register page
When User dont enter any details any field
And User clicks on continue button
Then User should get proper warning message