package tech.testify.ECommerse;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInUser).isDisplayed();
    }
}

