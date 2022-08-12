package tests;

import org.junit.Test;

import pages.LoginPage;

public class LoginTest extends BasePageTest {
    public LoginPage loginPage;
    String emailAdress = "togrim7@gmail.com";
    String password = "Testiranje1";
    String emptyEmail = "";
    String wrongPassword = "testiranje";
    String errorEmptyEmail = "An email address required.";
    String errorWrongPassword = "Authentication failed.";

    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emailAdress, password);
        loginPage.verifySuccesfulLogin("MY ACCOUNT");
        loginPage.clickOnLogoutMenuItem();
        loginPage.verifySuccesfulLogout("AUTHENTICATION");

        try{
            Thread.sleep(5000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnSuccesfulLoginEmptyEmail(){
        loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emptyEmail, password);
        loginPage.verifyUnSuccesfulLogin(errorEmptyEmail);

        try{
            Thread.sleep(5000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    @Test
    public void verifyUnSuccesfulLoginWrongPassword(){
        loginPage = new LoginPage(driver);
        loginPage.basePage();
        loginPage.login(emailAdress, wrongPassword);
        loginPage.verifyUnSuccesfulLogin(errorWrongPassword);

        try{
            Thread.sleep(5000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
    
}
