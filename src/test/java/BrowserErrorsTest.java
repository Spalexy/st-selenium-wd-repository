import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserErrorsTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void testBrowserErrors () {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin");
        driver.findElement(By.xpath("//button[@value='Login']")).click();

        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");

        List<WebElement> elements = driver.findElements(By.xpath("//tr/td[3]/a"));
        List<String> products = new ArrayList<String>();


        for (WebElement i : elements) {
            if (!i.getText().equals("Subcategory")){
                products.add(i.getAttribute("textContent"));
            }

        }

        for (String p : products) {
            driver.findElement(By.linkText(p)).click();
            Assert.assertTrue(driver.manage().logs().get("browser").getAll().isEmpty());
            driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        }


    }

    @After
    public void exit() {
        driver.quit();
        driver = null;
    }
}
