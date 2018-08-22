package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;


public class CheckoutPage extends PageBase {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage removeCartItems(int products) {
        for (int j = 1; j < (products + 1); j++) {
            wait.until(elementToBeClickable(By.name("remove_cart_item"))).click();
            List<WebElement> td = driver.findElements(By.cssSelector("td.item"));
            wait.until(stalenessOf(td.get(0)));

        }

        return this;

    }



}