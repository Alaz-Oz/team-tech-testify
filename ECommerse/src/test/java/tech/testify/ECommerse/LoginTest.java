package tech.testify.ECommerse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
  @Test(priority=1)
  public void validCredentials() {
	  driver.get("https://automationexercise.com/login");
	  LoginPage lp= new LoginPage(driver);
	  lp.enterEmail("ashu123@hms.com");
	  lp.enterPassword("password123");
  }
  @Test(priority=2)
  public void isUserDisplayed() {
	  driver.get("https://automationexercise.com/login");
	  LoginPage lp= new LoginPage(driver);
	  lp.enterEmail("ashu123@hms.com");
	  lp.enterPassword("password123");
	  lp.clickLogin();
	  Assert.assertTrue(lp.isUserDisplayed(), "Logged in username is not displayed. ");
	  String actualText=lp.getLoggedInUsername();
	  Assert.assertTrue(actualText.contains("ashutosh"), "Username does not match");
  }
  @Test(priority=3)
  public void loginWithInvalidPassword() {
	  driver.get("https://automationexercise.com/login");
	  LoginPage lp= new LoginPage(driver);
	  lp.login("ashu123@hms.com", "wrong_password");
	  Assert.assertTrue(lp.isErrorMessageDisplayed(), "Error message not displayed for invalid password");
  }
  @Test(priority=4)
  public void loginWithInvalidEmail() {
	  driver.get("https://automationexercise.com/login");
	  LoginPage lp= new LoginPage(driver);
	  lp.login("wrng@gmail.com", "password123");
	  Assert.assertTrue(lp.isErrorMessageDisplayed(), "Error message not displayed for invalid email");
  }
  @Test(priority=5)
  public void loginWithBlankFields() {
	  driver.get("https://automationexercise.com/login");
	  LoginPage lp= new LoginPage(driver);
	  lp.login("", "");
	  Assert.assertTrue(lp.isErrorMessageDisplayed(), "Error message not displayed for blank fields");
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver= new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
