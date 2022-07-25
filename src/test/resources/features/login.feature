@login
Feature: Login

	Background:
		Given I should see the login form

	@test1
	Scenario: Check login works properly (positive test)
		When  I enter "tomsmith" as username
		When  I enter "SuperSecretPassword!" as a password
	  When  I click to Login button
		Then  I should see 'You logged into a secure area! ×' on the home page

	@test2
	Scenario: Check entering wrong user name (negative test)
		When  I enter "tomsmith1" as username
		When  I enter "SuperSecretPassword!" as a password
		When  I click to Login button
		Then  I should see "Your username is invalid! ×" on the home page

	@test3
	Scenario: Check entering wrong user name (negative test)
		When  I enter "tomsmith" as username
		When  I enter "SuperSecretPassword!1" as a password
		When  I click to Login button
		Then  I should see "Your password is invalid! ×" on the home page








