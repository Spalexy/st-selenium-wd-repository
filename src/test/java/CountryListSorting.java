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


public class CountryListSorting {
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

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");


        List<WebElement> elements = driver.findElements(By.cssSelector("tr.row"));
        List<String> countries = new ArrayList<>();
        List<String> fewZoneCountries = new ArrayList<>();

        for (WebElement i : elements) {
            countries.add(i.findElement(By.cssSelector("td:nth-child(5) a")).getAttribute("text"));
            if (!(i.findElement(By.cssSelector("td:nth-child(6)")).getAttribute("textContent").equals("0"))) {
                fewZoneCountries.add(i.findElement(By.cssSelector("td:nth-child(5) a")).getAttribute("text"));
            }

        }

        List<String> sorted = countries;
        Collections.sort(sorted);
        Assert.assertEquals(countries, sorted);

        for (String j : fewZoneCountries) {
            driver.findElement(By.linkText(j)).click();
            elements = driver.findElements(By.cssSelector("#content td:nth-child(3)"));
            List<String> timezones = new ArrayList<>();

            for (WebElement k : elements){
                timezones.add(k.getAttribute("textContent"));
            }
            sorted = timezones;
            Collections.sort(sorted);
            Assert.assertEquals(sorted,timezones);

            driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        }







    }

    @After
    public void Stop() {
        driver.quit();
        driver = null;
    }

}
