package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class ProductPage extends PageBase
{

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public ProductPage addToCart(int i) {
        wait.until(visibilityOfElementLocated(By.cssSelector("#cart .quantity")));
        if (driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent").equals("Yellow Duck")) {
            driver.findElement(By.tagName("select")).click();
            driver.findElement(By.cssSelector("option[value=Small]")).click();
        }

        driver.findElement(By.cssSelector("[name=add_cart_product]")).click();

        String count = String.valueOf(i);
        wait.until(textToBePresentInElementLocated(By.cssSelector("span.quantity"), count));

        return this;
    }

    public CheckoutPage openCheckout() {
        driver.findElement(By.cssSelector("#cart a")).click();
        return new CheckoutPage(driver);
    }

}