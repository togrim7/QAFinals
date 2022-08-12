package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePageTest {

    public WebDriver driver;

    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "/Volumes/Mac HDD/Code Academy QA/QAFinals/QAFinals/lib/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void teardown(){
        driver.quit();
    }
    
}
