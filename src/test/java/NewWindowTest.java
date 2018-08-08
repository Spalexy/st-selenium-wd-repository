import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class NewWindowTest {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    @Test
    public void testNewWindow() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("input[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("button[name=login]")).click();

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("td#content div a")).click();


        List<WebElement> elements = driver.findElements(By.cssSelector("i.fa.fa-external-link"));
        int elementsQty = elements.size();

        for (int i = 0; i < elementsQty; i++) {

            String parentHandle = driver.getWindowHandle(); // get the current window handle
            elements.get(i).click(); // click the link that opens a new window

            for (String winHandle : driver.getWindowHandles()) {
                driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
            }

            driver.findElement(By.cssSelector("div"));



            driver.close(); // close newly opened window when done with it
            driver.switchTo().window(parentHandle); // switch back to the original window

        }

    }

    @After
    public void exit(){
        driver.quit();
        driver = null;
    }
}
