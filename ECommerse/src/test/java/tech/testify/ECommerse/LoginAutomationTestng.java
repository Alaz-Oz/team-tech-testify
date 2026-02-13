package tech.testify.ECommerse;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAutomationTestng {
	WebDriver driver;
	Loginpagepom lat;
  @Test
  public void Rightpassword() {
	 lat.loginpage("aayushjha@gmail.com", "Aayush@123");  
  }
  
  @Test
  public void Wrongpassword() {
	 lat.loginpage("aayush@gmail.com", "Aayush@123");  
	 Assert.assertTrue(lat.isincorrectmsgshown());
	 System.out.println("Your email or password is incorrect");
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  driver = new ChromeDriver();
	  driver.get("https://automationexercise.com/login");
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  lat = new Loginpagepom(driver);
	  
  }

  @AfterMethod
  public void afterMethod() {
	 driver.quit();
	  
	  
  }

}
