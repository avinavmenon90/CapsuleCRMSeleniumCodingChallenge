Feature: Add to Cart

Scenario: Automation Practice Add Products to Cart

Given User is already on Login Page
When Title of login page is My Store
Then User clicks on Sign In Button
Then User enters username and password
| avinavmenon@outlook.com | test@123 |
Then User clicks on Login Button
Then User is taken to home page
Then user moves to Search bar
Then user types keyword
| chiffon |
Then user cliks on add to cart
Then user clicks on Proceed to Checkout
Then Title of Cart Page is Order - My Store
Then Close the browser