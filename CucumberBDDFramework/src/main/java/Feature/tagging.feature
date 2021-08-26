@FunctionalTest
Feature: AutomationTest Page Testing

@SmokeTest @RegressionTest
Scenario: Login with correct username and password
Given This is a valid login test

@SmokeTest
Scenario: Login with incorrect username and password
Given This is an invalid login test

@RegressionTest
Scenario: Search for a product
Given This is a Search for a product test  

@End2end
Scenario: Add a product to Cart
Given This is an Add a product to Cart test  