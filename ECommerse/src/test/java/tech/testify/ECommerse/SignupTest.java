package tech.testify.ECommerse;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test(priority = 1)
    public void registerWithValidDetails() {
        driver.get("https://automationexercise.com/login");

        String email = "ashu" + System.currentTimeMillis() + "@gmail.com";

        SignUpPage signup = new SignUpPage(driver);
        signup.signup("Ashutosh", email);

        AccountInformationPage account = new AccountInformationPage(driver);
        account.fillAccountDetails();

        Assert.assertTrue(account.isAccountCreatedDisplayed());

        account.clickContinue();

        HomePage home = new HomePage(driver);
        Assert.assertTrue(home.isUserLoggedIn());
    }
    @Test(priority = 2)
    public void registerWithExistingEmail() {

        driver.get("https://automationexercise.com/login");

        SignUpPage signup = new SignUpPage(driver);

        signup.signup("Ashutosh", "ashutosh@gmail.com");

        Assert.assertTrue(signup.isEmailExistErrorDisplayed());
    }


}

