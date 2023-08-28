package stepDefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class seleniumTest {
    private WebDriver driver;

    @BeforeAll
    public static void setDriver(){
        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setup(){
        driver = new FirefoxDriver();
    }

    @AfterEach
    public void quit(){
        driver.quit();
    }

    @Test
    public void instructions(){
        driver.get("http://opencart.abstracta.us/");
    }
}
