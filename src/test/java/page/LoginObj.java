package page;/*
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

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginObj {

    ChromeDriver driver;
    WebDriverWait wait;

	  @FindBy(css = "#flash-messages")
	  private WebElement loginWarningObj;

	  @FindBy(css = "#content")
	  private WebElement formObj;


    public LoginObj(ChromeDriver _driver, WebDriverWait _wait) {
        driver = _driver;
        wait = _wait;
    }


	  private WebElement loginWarningObj() {
		  return driver.findElement(By.cssSelector("#flash-messages"));
	}

	  private WebElement formObj() {
		return driver.findElement(By.cssSelector("#content"));
	}


	   public boolean checkLoginForm() {
			 WebElement e1 = formObj().findElement(By.cssSelector(".example"));
			 wait.until(ExpectedConditions.visibilityOf(e1));
			 return e1.isDisplayed();

	}
	   public void enterUsername(String textUsername) throws InterruptedException {
			 		formObj().findElement(By.cssSelector("#username")).sendKeys(textUsername);
			 Thread.sleep(300);
	}

     public void enterPassword(String textPassword) throws InterruptedException {
		   formObj().findElement(By.cssSelector("#password")).sendKeys(textPassword);
		   Thread.sleep(300);
	}

	   public void clickLoginButton() throws InterruptedException {
			 formObj().findElement(By.cssSelector("button.radius:nth-child(3)")).click();
			 Thread.sleep(1000);

	}

	   public String getWarningText() {
			 WebElement e2 = loginWarningObj().findElement(By.cssSelector("#flash"));
			 wait.until(ExpectedConditions.visibilityOf(e2));
			 return e2.getText().replace('\n', ' ');
	}
}
