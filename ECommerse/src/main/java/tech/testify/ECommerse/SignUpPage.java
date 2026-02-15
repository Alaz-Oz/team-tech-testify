package tech.testify.ECommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	WebDriver driver;
	private By nameTxt= By.xpath("//input[@placeholder='Name']");
	By emailTxt = By.xpath("//input[@data-qa='signup-email']");
	private By signUpBtn=By.xpath("//button[normalize-space()='Signup']");
	private By erroMsg=By.xpath("//p[normalize-space()='Email Address already exist!']");
	
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterName(String name) {
		driver.findElement(nameTxt).sendKeys(name);
	}
	public void enterEmail(String email) {
		driver.findElement(emailTxt).sendKeys(email);
	}
	public void clickSignup() {
		driver.findElement(signUpBtn).click();
	}
	public void signup(String name, String email) {
        driver.findElement(nameTxt).sendKeys(name);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(signUpBtn).click();
    }

	public boolean isEmailExistErrorDisplayed() {
		// TODO Auto-generated method stub
		String errMsg=driver.findElement(By.name("email")).getAttribute("validationMessage");
		return !errMsg.equals(null);

	}
	
}
