package tech.testify.ECommerse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpagepom {

	
WebDriver driver;
	
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement logemail;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	WebElement logpassword;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement logbtn;
	
	@FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
	WebElement incorrect;
	
	@FindBy(xpath = "//b[normalize-space()='aayushjha']")
	WebElement loggedInUser;
	
	public Loginpagepom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public  void loginpage(String mail, String pass) {
		
		logemail.sendKeys( mail);
		logpassword.sendKeys(pass);
		logbtn.click();
		
	}
	
	public boolean isuserloggedin() {
		return loggedInUser.isDisplayed();		
	}
	public boolean isincorrectmsgshown() {
		return incorrect.isDisplayed();
	}
}
