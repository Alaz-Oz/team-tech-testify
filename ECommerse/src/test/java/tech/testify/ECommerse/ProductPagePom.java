package tech.testify.ECommerse;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPagePom {
  WebDriver driver;
  
    @FindBy(xpath = "//div[@class='product-image-wrapper']")
    List<WebElement> products;
    
    @FindBy(xpath = "//div[@class='productinfo text-center']/img")
    List<WebElement> images;
   
    @FindBy(xpath = "//div[@class='productinfo text-center']/h2")
    List<WebElement> price;
   
    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    List<WebElement> names;
   
	
	public ProductPagePom(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
   
	
}
