package com.utility;

import com.constants.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//parent class are always marked as abstract
public abstract class BrowserUtility {

    private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public WebDriver getDriver() {
        return driver;
    }

    public BrowserUtility(WebDriver driver) {
        this.driver = driver;
    }

    public BrowserUtility(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if(browserName.equalsIgnoreCase("Edeg")){
            driver = new EdgeDriver();
        }
        else {
            System.err.print("Invalid Browser Name");
        }

    }

    //Because we created enum Browser
    public BrowserUtility(Browser browserName){
        if(browserName==Browser.CHROME){
            driver = new ChromeDriver();
        }
        else if(browserName==Browser.EDGE){
            driver = new EdgeDriver();
        }
        else {
            System.err.print("Invalid Browser Name");
        }

    }


    public void goToWebsite(String url){
        driver.get(url);
    }

    public void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement element = driver.findElement(locator);
        element.click();
    }

    public void enterText(By locator, String textToEnter){
        WebElement element = driver.findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator){
       // wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public void closeBrowser(){
        driver.quit();
    }
}
