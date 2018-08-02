import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class NewProductTest {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
    }


    @Test
    public void myNewProductTest() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.cssSelector("[name=username]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("admin");
        driver.findElement(By.cssSelector("[name=login]")).click();

        driver.findElement(By.cssSelector("ul#box-apps-menu li:nth-child(2) a")).click();
        driver.findElement(By.cssSelector("#content div a:last-child")).click();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i <5 ; i++) {
            Random random = new Random();
            int num = random.nextInt(10);

            builder.append(num);
        }



        String nameEn = "Product";
        String prodCode = "t" + builder;
        String quantity = "120";
        String dateFrom = "1282018";
        String dateTo = "7102019";
        String rubbish = "Lorem ipsum dolor sit amet";
        String desription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris neque elit, sodales eu augue non, " +
                "fermentum condimentum odio. Nulla gravida odio lectus, bibendum gravida elit ornare quis. Sed suscipit commodo scelerisque. " +
                "Nullam non ornare neque, ac finibus orci. Proin feugiat tempus tortor at luctus. Praesent viverra consectetur lectus nec lobortis.";
        String purchasePrice = "120";
        String priceUSD = "29";
        String priceEUR = "26";
        String tax = "1.6";

        driver.findElement(By.cssSelector("[name=status]")).click();
        driver.findElement(By.cssSelector("[name=name\\[en\\]]")).sendKeys(nameEn);
        driver.findElement(By.cssSelector("[name=code]")).sendKeys(prodCode);
        driver.findElement(By.cssSelector("[data-name=Rubber\\ Ducks]")).click();
        driver.findElement(By.xpath("//input[@value='1-3']")).click();
        driver.findElement(By.cssSelector("[name=quantity]")).clear();
        driver.findElement(By.cssSelector("[name=quantity]")).sendKeys(quantity);
        driver.findElement(By.cssSelector("[name=date_valid_from]")).sendKeys(dateFrom);
        driver.findElement(By.cssSelector("[name=date_valid_to]")).sendKeys(dateTo);

        driver.findElement(By.xpath("//a[contains(text(),'Information')]")).click();
        driver.findElement(By.xpath("//select[@name='manufacturer_id']")).click();
        driver.findElement(By.xpath("//select[@name='manufacturer_id']/option[2]")).click();
        driver.findElement(By.cssSelector("[name=keywords]")).sendKeys(rubbish);
        driver.findElement(By.cssSelector("[name=short_description\\[en\\]]")).sendKeys(rubbish);




    }

}
