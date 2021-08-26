Feature: FreeCRM Login Feature


 #Data Driven Testing (without Examples keyword) - use Scenario
#Scenario: Free CRM Login Test Scenario
#
#Given User is already on Login Page
#When Title of login page is My Store
#Then User clicks on Sign In Button
#Then User enters "avinavmenon@outlook.com" and "test@123"  
#Then User clicks on Login Button
#Then User is taken to home page

 #Data Driven Testing (with Examples keyword) - use Scenario Outline
Scenario Outline: Free CRM Login Test Scenario

Given User is already on Login Page
When Title of login page is My Store
Then User clicks on Sign In Button
Then User enters "<username>" and "<password>"  
Then User clicks on Login Button
Then User is taken to home page
Then Close the Browser

Examples:
	| username | password |
	| avinavmenon@outlook.com | test@123 |
	| tom@gmail.com | test@456 |