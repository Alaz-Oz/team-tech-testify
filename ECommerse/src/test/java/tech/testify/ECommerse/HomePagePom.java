package tech.testify.ECommerse;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePagePom {

	
	WebDriver driver;
	
	@FindBy(xpath = "//img[@alt='Website for automation practice']")
	WebElement  logo;
	
	@FindBy(xpath = "//a[contains(text(),'Home')]")
	WebElement Home;
	
	@FindBy(xpath = "//a[@href='/products']")
	WebElement product;
	
	@FindBy(xpath = "//a[@href='/view_cart']")
	WebElement viewcart;
	
	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	WebElement Login;
	
	@FindBy(xpath = "//a[contains(text(),'Test Cases')]")
	WebElement Testcase;
	
	@FindBy(xpath = "//a[normalize-space()='API Testing']")
	WebElement Apitesting;
	
	@FindBy(xpath = "//a[normalize-space()='Video Tutorials']")
	WebElement VideoTutorial;
	
	@FindBy(xpath = "//a[normalize-space()='Contact us']")
	WebElement contactus;
	
	@FindBy(xpath = "//div[@class='footer-widget']")
	WebElement footer;
	
	
	
	public HomePagePom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		
	}
	public boolean  verifyIconvisible() {
		List<WebElement> icons = new ArrayList<>();
		icons.add(logo);
		icons.add(Home);
		icons.add(product);
		icons.add(viewcart);
		icons.add(Login);
		icons.add(Apitesting);
		icons.add(VideoTutorial);
		icons.add(contactus);
	
		 for(WebElement icon:icons) {
			 if(!icon.isDisplayed())
			return false;
		 }
		return true;
	}
	
	public boolean verifylinkTest() {
		List<WebElement> links = new ArrayList<>();
		links.add(Home);
		links.add(product);
		links.add(viewcart);
		links.add(Login);
		links.add(Apitesting);
		links.add(VideoTutorial);
		links.add(contactus);
		for(WebElement link: links) {
			if(!link.isEnabled()) {
				return false;
			}
		}
		return true;
	}
	
	public boolean verifyFooter() {
		 return footer.isDisplayed();
	}
}
