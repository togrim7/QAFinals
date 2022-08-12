package pages;

import static org.junit.Assert.assertEquals;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingPage extends BasePage {

    public ShoppingPage(WebDriver driver){
        super(driver);
    }

    String baseURL = "http://automationpractice.com/index.php?id_category=5&controller=category";
    By product = By.xpath("//*[@id='center_column']/ul/li");
    By addToCartButton = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");
    By totalPrice = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[3]/span");
    By price = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[1]/span");
    By tax = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[2]/span");

    public ShoppingPage basePage(){
        driver.get(baseURL);
        return this;
    }

    public ShoppingPage clickOnAddToCartButton(){
        click(addToCartButton);
        return this;
    }

    public ShoppingPage clickOnProduct(){
        click(product);
        return this;
    }

    public ShoppingPage checkPrice () throws ParseException{
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.US);
        Number priceNum = format.parse(readText(price));
        Number taxNum = format.parse(readText(tax));
        Number totalPriceNum = format.parse(readText(totalPrice));

        assertEquals(totalPriceNum.doubleValue(), priceNum.doubleValue() + taxNum.doubleValue(), 0);
        return this;
    }

}
