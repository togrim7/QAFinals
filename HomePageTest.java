package tests;

import org.junit.Test;

import pages.HomePage;

public class HomePageTest extends BasePageTest {

    public HomePage homePage;

    String emailAdress = "togrim7@gmail.com";
    String password = "Testiranje1";
    int numberOfPopularItems = 7;
    int numberOfBestSellerItems = 7;

    @Test
    public void numberOfPopularItems(){
        homePage = new HomePage(driver);
        homePage.basePage();
        homePage.numberOfPopularItems(numberOfPopularItems);

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void numberOfBestSellerItems(){
        homePage = new HomePage(driver);
        homePage.basePage();
        homePage.clickOnBestSellerButton();
        homePage.numberOfBestSellerItems(numberOfBestSellerItems);

        try{
            Thread.sleep(10000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
