package tests;

import java.text.ParseException;

import org.junit.Test;
import pages.ShoppingPage;

public class ShoppingTest extends BasePageTest {

    public ShoppingPage shoppingPage;

    @Test
    public void verifySuccesfullAddToCart() throws ParseException{
        shoppingPage = new ShoppingPage(driver);
        shoppingPage.basePage();
        shoppingPage.clickOnProduct();
        shoppingPage.clickOnAddToCartButton();
        shoppingPage.checkPrice();
    }
    
}
