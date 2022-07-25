package stepDefs;/*
 * (C) Copyright 2020 Boni Garcia (http://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import page.LoginObj;


public class LoginStepDefs extends BaseConfig {

    protected LoginObj login;

    public LoginStepDefs() {
        login = new LoginObj(driver, wait);
    }

	  @Given("I should see the login form")
	  public void existLoginForm() {
		assertEquals(login.checkLoginForm(),true);
	  }

	  @When("I enter {string} as username")
  	public void enterEmail(String textEmail) throws InterruptedException {
		login.enterUsername(textEmail);
	}

  	@When("I enter {string} as a password")
 	  public void enterPassword(String textPassword) throws InterruptedException {
		login.enterPassword(textPassword);
	}

	  @When("I click to Login button")
	  public void clickLogin() throws InterruptedException {
		login.clickLoginButton();
	}

	  @Then("I should see {string} on the home page")
	  public void getWarningText(String warningText) {
		assertEquals(warningText, login.getWarningText());
	}

	@After
	public void closeDriver(){
		driver.quit();
	}
}
