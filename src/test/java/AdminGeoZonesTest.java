import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdminGeoZonesTest {
    private WebDriver driver;


    @Before
    public void start() {
        driver = new ChromeDriver();
    }

    @Test
    public void mySortingTest() {
        driver.get("http://localhost/litecart/admin");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");


        int countriesQnt = driver.findElements(By.cssSelector("tr.row")).size();

        for (int i = 0; i < countriesQnt; i++) {
            List<WebElement> menuItems = driver.findElements(By.cssSelector(".row td:nth-child(3) a"));
            menuItems.get(i).click();

            List<String> zones = new ArrayList<>();
            List<WebElement> elements = driver.findElements(By.cssSelector(".dataTable tr td:nth-child(3) *:checked"));

            for (WebElement j : elements) {
                zones.add(j.getAttribute("textContent"));

            }

            List<String> sorted = zones;
            Collections.sort(sorted);
            Assert.assertEquals(zones, sorted);

            driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        }

    }

    @After
    public void Stop() {
        driver.quit();
        driver = null;
    }
}
