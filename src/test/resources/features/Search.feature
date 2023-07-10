Feature: Search Functionality

Scenario: User searches for a valid product
Given User opens the application
When User enters valid product "Hp" into search box field
And User clicks on search button
Then User should get valid product displayed in search results

Scenario: User seaches for an invalid product
Given User opens the application
When User enters invalid product "honda" into search box field
And User clicks on search button
Then User should get a message no product matching

Scenario: User searches without any product
Given User opens the application
When User do not enter any text into search field
And User clicks on search button
Then User should get a message no product matching