import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.List;



public class stickerTest {

    private WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void myStickerTest() {
        driver.get("http://localhost/litecart/en/");

        List<WebElement> stickers = driver.findElements(By.cssSelector(".product"));


        for (WebElement i : stickers) {
            Assert.assertTrue(i.findElements(By.cssSelector(".sticker")).size() == 1);
        }
    }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
