package tech.testify.ECommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement emailTxt;
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement passwordTxt;
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginBtn;
	@FindBy(xpath = "//p[contains(text(),'Your email or password is incorrect!')]")
    WebElement errorMessage;
	private By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");
	
	public void enterEmail(String email) {
		emailTxt.clear();
		emailTxt.sendKeys(email);
	}
	public void enterPassword(String password) {
		passwordTxt.clear();
		passwordTxt.sendKeys(password);
	}
	public void clickLogin() {
		loginBtn.click();
	}
	public void login(String email, String password) {
		emailTxt.sendKeys(email);
		passwordTxt.sendKeys(password);
		loginBtn.click();
	}
	public boolean isErrorMessageDisplayed() {
		return errorMessage.isDisplayed();
	}
	 public String getLoggedInUsername() {
	        return driver.findElement(loggedInUser).getText();
	    }
	 public boolean isUserDisplayed() {
	        return driver.findElement(loggedInUser).isDisplayed();
	    }
}
