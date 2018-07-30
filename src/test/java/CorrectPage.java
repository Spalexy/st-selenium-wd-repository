import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class CorrectPage {
    private WebDriver driver;

    @Before
    public void start() {
        driver = new ChromeDriver();
//        driver = new InternetExplorerDriver();
//        driver = new FirefoxDriver();

    }

    @Test
    public void myPageText(){
        driver.get("http://localhost/litecart/en/");

// Получаем свойства с главной страницы
        String productName = driver.findElement(By.cssSelector("#box-campaigns .name")).getAttribute("textContent");
        String regularPrice = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getAttribute("textContent");
        String campaignPrice = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getAttribute("textContent");

        String regularPriceColor = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("color");
        String regularPriceOutline = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getTagName();
        String regularPriceFontSize = driver.findElement(By.cssSelector("#box-campaigns .regular-price")).getCssValue("font-size");

        String campaignPriceColor = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("color");
        String campaignPriceOutline = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getTagName();
        String campaignPriceFontsize = driver.findElement(By.cssSelector("#box-campaigns .campaign-price")).getCssValue("font-size");

        driver.findElement(By.cssSelector("#box-campaigns .product a")).click();

// Получаем свойства со страницы товара
        String productNameProd = driver.findElement(By.cssSelector("h1.title")).getAttribute("textContent");
        String regularPriceProd = driver.findElement(By.cssSelector(".regular-price")).getAttribute("textContent");
        String campaignPriceProd = driver.findElement(By.cssSelector(".campaign-price")).getAttribute("textContent");

        String regularPriceColorProd = driver.findElement(By.cssSelector(".regular-price")).getCssValue("color");
        String regularPriceOutlineProd = driver.findElement(By.cssSelector(".regular-price")).getTagName();
        String regularPriceFontSizeProd = driver.findElement(By.cssSelector(".regular-price")).getCssValue("font-size");

        String campaignPriceColorProd = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("color");
        String campaignPriceOutlineProd = driver.findElement(By.cssSelector(".campaign-price")).getTagName();
        String campaignPriceFontsizeProd = driver.findElement(By.cssSelector(".campaign-price")).getCssValue("font-size");


        Assert.assertEquals(productName, productNameProd);
        Assert.assertEquals(regularPrice, regularPriceProd);
        Assert.assertEquals(campaignPrice, campaignPriceProd);

// Проверка формата обычной цены
        String[] subStr = regularPriceColor.replace("(", ",").replace(")", "").split(",");

        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = subStr[i].trim();
        }

        Assert.assertEquals(subStr[1], subStr[2]);
        Assert.assertEquals(subStr[2], subStr[3]);
        Assert.assertEquals(regularPriceOutline, "s");

// Проверка формата обычной цены на странице продукта
        subStr = regularPriceColorProd.replace("(", ",").replace(")", "").split(",");

        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = subStr[i].trim();
        }

        Assert.assertEquals(subStr[1], subStr[2]);
        Assert.assertEquals(subStr[2], subStr[3]);
        Assert.assertEquals(regularPriceOutlineProd, "s");


// Проверка формата акционной цены
        subStr = campaignPriceColor.replace("(", ",").replace(")", "").split(",");

        Assert.assertEquals(subStr[2], " 0");
        Assert.assertEquals(subStr[3], " 0");
        Assert.assertEquals(campaignPriceOutline, "strong");


// Проверка формата акционной цены  на странице продукта
        subStr = campaignPriceColorProd.replace("(", ",").replace(")", "").split(",");

        Assert.assertEquals(subStr[2], " 0");
        Assert.assertEquals(subStr[3], " 0");
        Assert.assertEquals(campaignPriceOutlineProd, "strong");


// Проверка размера цен
        campaignPriceFontsize = campaignPriceFontsize.substring(0,campaignPriceFontsize.length() - 2 );
        regularPriceFontSize = regularPriceFontSize.substring(0,regularPriceFontSize.length() - 2 );

        float regularPriceFont = Float.parseFloat(regularPriceFontSize);
        float campaignPriceFont = Float.parseFloat(campaignPriceFontsize);

        Assert.assertTrue(campaignPriceFont > regularPriceFont);



// Проверка размера цен  на странице продукта
        campaignPriceFontsizeProd = campaignPriceFontsizeProd.substring(0,campaignPriceFontsizeProd.length() - 2 );
        regularPriceFontSizeProd = regularPriceFontSizeProd.substring(0,regularPriceFontSizeProd.length() - 2 );

        regularPriceFont = Float.parseFloat(regularPriceFontSizeProd);
        campaignPriceFont = Float.parseFloat(campaignPriceFontsizeProd);

        Assert.assertTrue(campaignPriceFont > regularPriceFont);



    }

    @After
    public void Stop() {
        driver.quit();
        driver = null;
    }
}
