package tests;

import org.junit.Test;
import pages.CheckoutPage;
import pages.MainPage;
import pages.ProductPage;


public class AddCartTest extends TestBase {

    @Test
    public void test()
    {
        MainPage mainPage  = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        int products = 3;


        for (int i = 1; i  <(products + 1); i++) {
            mainPage.open();
            productPage = mainPage.chooseProduct();
            productPage.addToCart(i);
        }

        checkoutPage = productPage.openCheckout();
        checkoutPage.removeCartItems(products);

    }
}
