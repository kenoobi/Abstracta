package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "search")
    private WebElement searchField;

    @FindBy(how = How.CSS, using = "button.btn.btn-default.btn-lg")
    private WebElement btn_Search;

    @FindBy(how = How.CLASS_NAME, using = "input-group-btn")
    private WebElement btn_Search2;

    public void clickOn_BtnLogin() {
        btn_Search.submit();
    }

    public void searchProduct(String textToSearch){
        searchField.sendKeys(textToSearch);
        btn_Search2.click();
    }

}
