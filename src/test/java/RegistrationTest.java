import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

public class RegistrationTest {
    private WebDriver driver;

    @Before
    public void start(){
        driver = new ChromeDriver();

    }


    @Test
    public void myRegistrationTest() {
        driver.get("http://localhost/litecart/en/");

        driver.findElement(By.cssSelector(".content tbody a")).click();

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i <5 ; i++) {
            Random random = new Random();
            int num = random.nextInt(100);

            builder.append(num);
        }

        String mailName = builder.toString();


        String email = mailName + "@m.mail";
        String firstName = "TestName";
        String lastName = "TestName";
        String address = "Test str.";
        String postcode = "01234";
        String city = "Test City";
        String country = "United States";
        String phone = "+79041234567";
        String password = "password";

        driver.findElement(By.cssSelector("input[name=firstname]")).sendKeys(firstName);
        driver.findElement(By.cssSelector("input[name=lastname]")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[name=address1]")).sendKeys(address);
        driver.findElement(By.cssSelector("input[name=postcode]")).sendKeys(postcode);
        driver.findElement(By.cssSelector("input[name=city]")).sendKeys(city);
        driver.findElement(By.cssSelector("[name=country_code]")).sendKeys(country  + Keys.ENTER);
        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[name=phone]")).sendKeys(phone);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("input[name=confirmed_password]")).sendKeys(password);

        driver.findElement(By.cssSelector("button")).click();

        driver.findElement(By.xpath("//div[@id=\"box-account\"]//li[4]/a")).click();

        driver.findElement(By.cssSelector("[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=login]")).click();

        driver.findElement(By.xpath("//div[@id=\"box-account\"]//li[4]/a")).click();
        }


    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
