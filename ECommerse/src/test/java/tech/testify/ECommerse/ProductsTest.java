package tech.testify.ECommerse;

import org.testng.annotations.Test;



import org.testng.Assert;
import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {

    @Test(priority = 1)
    public void verifyAllProductsDisplayed() {
        driver.get("https://automationexercise.com/products");

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.getProductCount() > 0,
                "Products are not displayed!");
    }

    @Test(priority = 2)
    public void verifyProductImagesVisible() {
        driver.get("https://automationexercise.com/products");

        ProductsPage products = new ProductsPage(driver);
        Assert.assertTrue(products.areImagesDisplayed(),
                "Some product images are not visible!");
    }

    @Test(priority = 3)
    public void searchProductValid() {
        driver.get("https://automationexercise.com/products");

        ProductsPage products = new ProductsPage(driver);
        products.searchProduct("Dress");

        Assert.assertTrue(products.isProductListDisplayed(),
                "Search results not displayed!");
    }

    @Test(priority = 4)
    public void searchProductInvalid() {

        driver.get("https://automationexercise.com/products");

        ProductsPage products = new ProductsPage(driver);
        String keyword = "xyzabc123";

        products.searchProduct(keyword);

        Assert.assertTrue(products.isNoRelevantProductDisplayed(keyword),
                "Invalid search still showing matching products!");
    }
    @Test(priority=5)
    public void filterByCategory() {

        driver.get("https://automationexercise.com/products");

        ProductsPage products = new ProductsPage(driver);
        products.clickWomenDressCategory();

        String title = products.getCategoryTitle();

        Assert.assertTrue(title.contains("WOMEN - DRESS"),
                "Category filter not working!");
    }
    @Test(priority=6)
    public void filterByBrand() {

        driver.get("https://automationexercise.com/products");

        ProductsPage products = new ProductsPage(driver);
        products.clickPoloBrand();

        String title = products.getBrandTitle();

        Assert.assertTrue(title.contains("BRAND - POLO PRODUCTS"),
                "Brand filter not working!");
    }


}
