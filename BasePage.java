package pages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage (WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitVisability(By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
    }
    
    public int countItems(By elementBy){
        waitVisability(elementBy);
        return driver.findElements(elementBy).size();
    }

    public void assertIntigerEquals(int expectedNumber, int actualNumber){
        Assert.assertEquals(expectedNumber, actualNumber);
    }

    public void click(By elementBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        driver.findElement(elementBy).click();
    }

    public String readText(By elementBy){
        waitVisability(elementBy);
        return driver.findElement(elementBy).getText();
    }

    public void writeText(By elementBy, String text){
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        driver.findElement(elementBy).clear();
        driver.findElement(elementBy).sendKeys(text);
    }

    public void assertTextEquals(String expectedText, String actualText){
        Assert.assertEquals(expectedText, actualText);
    }
}
