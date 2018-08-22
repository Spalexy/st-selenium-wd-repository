package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MainPage extends PageBase {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        driver.get("http://localhost/litecart/");
        return this;
    }

    public ProductPage chooseProduct() {
        driver.findElement(By.cssSelector("li a.link")).click();
        return new ProductPage(driver);
    }


}