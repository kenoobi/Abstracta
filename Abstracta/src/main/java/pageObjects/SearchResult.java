package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class SearchResult {

    public SearchResult(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "product-thumb")
    private WebElement product;

    @FindBy(how = How.ID, using = "button-cart")
    private WebElement addProductToCart;

    @FindBy(how = How.ID, using = "cart")
    private WebElement cartButtont;

    @FindBy(how = How.CSS, using = "a[href*='route=checkout/cart']")
    private WebElement viewCartButton;

    public void selectProduct(){
        product.click();
    }
    public void sendToCart() {
        addProductToCart.click();
    }
    public void selectCart(){
        cartButtont.click();
    }
    public void viewCartButton(){
        viewCartButton.click();
    }
}
