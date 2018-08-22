import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


public class CartTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }


    @Test
    public void myCartTest() {

        int products = 3;

        for (int i = 1; i < (products + 1); i++ ) {

            String count = String.valueOf(i);
            driver.get("http://localhost/litecart/");
            driver.findElement(By.cssSelector("li a.link")).click();
            if (driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent").equals("Yellow Duck")) {
                driver.findElement(By.tagName("select")).click();
                driver.findElement(By.cssSelector("option[value=Small]")).click();
            }

            driver.findElement(By.cssSelector("[name=add_cart_product]")).click();


            wait.until(textToBePresentInElementLocated(By.cssSelector("span.quantity"), count));
        }

        driver.findElement(By.cssSelector("#cart a")).click();

        for (int j = 1; j < (products + 1); j++) {
            List<WebElement> td = driver.findElements(By.cssSelector("td.item"));
            wait.until(elementToBeClickable(By.name("remove_cart_item"))).click();
            wait.until(stalenessOf(td.get(0)));

        }


    }

    @After
    public void exit () {
        driver.quit();
        driver = null;
    }

}