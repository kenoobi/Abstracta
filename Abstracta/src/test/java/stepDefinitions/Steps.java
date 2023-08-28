package stepDefinitions;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pageObjects.CartPage;
import pageObjects.MainPage;
import pageObjects.SearchResult;

import java.time.Duration;

public class Steps {

    private WebDriver driver;

    // Start variables
    @Given("start the web")
    public void start_the_web() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        driver = new FirefoxDriver();
        driver.get("http://opencart.abstracta.us/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Behavior
    @When("search product {string}")
    public void SearchProduct(String textToSearch) {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchProduct(textToSearch);
    }

    // Asserts
    @When("validate that the search works")
    public void productValidation(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(true, driver.findElement(By.className("product-thumb")).isDisplayed());
    }

    @When("select the product")
    public void selectTheProduct() {
        SearchResult result = new SearchResult(driver);
        result.selectProduct();
    }

    @Then("validate that the button Add to Cart exist")
    public void validateThatTheButtonAddToCartExist() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(true, driver.findElement(By.id("button-cart")).isDisplayed());
    }

    @When("send the product to the basket")
    public void sendTheProductToTheBasket() {
        SearchResult result = new SearchResult(driver);
        result.sendToCart();
    }

    @Then("validate that the product was add to the card")
    public void validateThatTheProductWasAddToTheCard() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertEquals(true, driver.findElement(By.cssSelector("div.alert.alert-success.alert-dismissible")).isDisplayed());
    }

    @But("select cart")
    public void selectCart() {
        SearchResult result = new SearchResult(driver);
        result.selectCart();
    }

    @And("send to view cart")
    public void sendToViewCart() {
        SearchResult result = new SearchResult(driver);
        result.viewCartButton();
    }

    @And("Validate that the product {string} is in the cart")
    public void validateThatTheProductIsInTheCart(String productName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.xpath("//table[@class='table table-striped']//td[@class='text-left']/a[contains(text(), '" + productName + "')]")).isDisplayed());
    }

    @But("validate the product {string} in the cart page")
    public void validateTheProductInTheCartPage(String productName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.findElement(By.linkText(productName)).isDisplayed());
    }

    @And("delete product of cart page")
    public void deleteProductOfCartPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct();
    }

    @Then("validate that the shopping cart is empty")
    public void validateEmptyShoppingCart() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Assert.assertTrue(driver.getPageSource().contains("Your shopping cart is empty!"));
    }
}
