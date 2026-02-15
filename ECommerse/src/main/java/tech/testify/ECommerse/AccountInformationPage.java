package tech.testify.ECommerse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AccountInformationPage {

    WebDriver driver;

    public AccountInformationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By titleMr = By.id("id_gender1");
    private By password = By.id("password");
    private By days = By.id("days");
    private By months = By.id("months");
    private By years = By.id("years");

    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipcode = By.id("zipcode");
    private By mobileNumber = By.id("mobile_number");

    private By createAccountBtn = By.xpath("//button[@data-qa='create-account']");

    private By accountCreatedMessage = By.xpath("//b[contains(text(),'Account Created!')]");
    private By continueBtn = By.xpath("//a[@data-qa='continue-button']");


    public void fillAccountDetails() {

        driver.findElement(titleMr).click();
        driver.findElement(password).sendKeys("Test@123");

        new Select(driver.findElement(days)).selectByValue("10");
        new Select(driver.findElement(months)).selectByValue("5");
        new Select(driver.findElement(years)).selectByValue("1995");

        driver.findElement(firstName).sendKeys("Ashutosh");
        driver.findElement(lastName).sendKeys("Kumar");
        driver.findElement(address).sendKeys("India Address");

        new Select(driver.findElement(country)).selectByVisibleText("India");

        driver.findElement(state).sendKeys("UP");
        driver.findElement(city).sendKeys("Noida");
        driver.findElement(zipcode).sendKeys("201301");
        driver.findElement(mobileNumber).sendKeys("9999999999");

        driver.findElement(createAccountBtn).click();
    }

    public boolean isAccountCreatedDisplayed() {
        return driver.findElement(accountCreatedMessage).isDisplayed();
    }
    public void clickContinue() {
        driver.findElement(continueBtn).click();
    }

}
