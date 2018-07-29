import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class MyFirstTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }


    @Test
    public void myFirstTest() {
        driver.navigate().to("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        int menuSize = driver.findElements(By.xpath("//*[@id=\"box-apps-menu\"]/li/a")).size();

        for (int i = 0; i < menuSize; i++) {
            List<WebElement> menuItems = driver.findElements(By.xpath("//*[@id=\"box-apps-menu\"]/li/a"));
            menuItems.get(i).click();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebElement element = driver.findElement(By.cssSelector("h1"));

            int subMenuSize = driver.findElements(By.cssSelector("li#app- ul a")).size();

            for (int j = 0; j < subMenuSize; j++) {

                List<WebElement> subMenuItems = driver.findElements(By.cssSelector("li#app- ul a"));
                subMenuItems.get(j).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                WebElement internalElement = driver.findElement(By.cssSelector("h1"));
            }
        }






    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }


}
