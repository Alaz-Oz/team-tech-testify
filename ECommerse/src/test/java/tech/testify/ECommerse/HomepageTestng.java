package tech.testify.ECommerse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTestng {
	WebDriver driver;
	HomePagePom hp;
  @Test
  public void test1() {
	  Assert.assertTrue(hp.verifyIconvisible(), "One or more homepage icons are not visible");  
  }
  @Test
  public void test2() {
	  Assert.assertTrue(hp.verifylinkTest(), "Each link is in working mode");
  }
  @Test
  public void test3() {
	  Assert.assertTrue(hp.verifyFooter(), "Each link is in working mode");
  }
  @BeforeMethod
  public void beforeMethod() {
	  driver = new ChromeDriver();
	  driver.get("https://automationexercise.com/");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  hp = new HomePagePom(driver);  
  }
  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
