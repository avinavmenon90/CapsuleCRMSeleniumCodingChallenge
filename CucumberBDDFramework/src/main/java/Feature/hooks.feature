Feature: AutomationTest Page Testing with Hooks


Scenario: Login with correct username and password
Given User is already on Login Page
When Title of login page is My Store
Then User clicks on Sign In Button
Then User enters "<username>" and "<password>"  
Then User clicks on Login Button
Then User is taken to home page
Then Close the Browser
