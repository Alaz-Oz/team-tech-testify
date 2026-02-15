package tech.testify.ECommerse;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By allProducts = By.xpath("//div[@class='features_items']/div");
    private By productImages = By.xpath("//div[@class='product-image-wrapper']//img");
    private By productNames = By.xpath("//div[@class='productinfo text-center']/p");
    private By productPrices = By.xpath("//div[@class='productinfo text-center']/h2");

    private By searchBox = By.id("search_product");
    private By searchButton = By.id("submit_search");
    private By searchedProductsTitle = By.xpath("//h2[contains(text(),'Searched Products')]");

    private By womenCategory = By.xpath("//a[@href='#Women']");
    private By womenDress = By.xpath("//a[@href='/category_products/1']");
    private By categoryTitle = By.xpath("//h2[@class='title text-center']");
    private By poloBrand = By.xpath("//a[@href='/brand_products/Polo']");
    private By brandTitle = By.xpath("//h2[@class='title text-center']");

    public void clickPoloBrand() {
        driver.findElement(poloBrand).click();
    }

    public String getBrandTitle() {
        return driver.findElement(brandTitle).getText();
    }


    public void clickWomenDressCategory() {
        driver.findElement(womenCategory).click();
        driver.findElement(womenDress).click();
    }

    public String getCategoryTitle() {
        return driver.findElement(categoryTitle).getText();
    }
    public int getProductCount() {
        return driver.findElements(allProducts).size();
    }

    public boolean areImagesDisplayed() {
        List<WebElement> images = driver.findElements(productImages);
        for (WebElement img : images) {
            if (!img.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void searchProduct(String keyword) {
        driver.findElement(searchBox).sendKeys(keyword);
        driver.findElement(searchButton).click();
    }

    public boolean isProductListDisplayed() {
        return driver.findElements(allProducts).size() > 0;
    }
    public boolean isNoRelevantProductDisplayed(String keyword) {

        List<WebElement> names = driver.findElements(productNames);

        for (WebElement name : names) {
            if (name.getText().toLowerCase().contains(keyword.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}

