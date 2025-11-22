package com.utility;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

//parent class are always marked as abstract
public abstract class BrowserUtility {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public String takeScreenShot(String name){
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
        File screenshotData = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir")+"/screenshots/"+name+".png";
        File screenshotFile = new File(path);
        try {
            FileUtils.copyFile(screenshotData,screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
    }

    public BrowserUtility(String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            driver.set(new ChromeDriver());
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            driver.set(new EdgeDriver());
        }
        else {
            System.err.print("Invalid Browser Name");
        }

    }

    //To run in normal or headless, creating same constructor as above with extra headless as parameter;
    public BrowserUtility(String browserName, boolean isHeadless){

        if(browserName.equalsIgnoreCase("chrome")){
            if(isHeadless){
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=new");
                options.addArguments("--window-size=1920,1080");
                driver.set(new ChromeDriver(options));
            }
            else {
                driver.set(new ChromeDriver());
            }
        }
        else if(browserName.equalsIgnoreCase("Edeg")){
            if(isHeadless){
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");
                driver.set(new EdgeDriver(options));
            }
            else {
                driver.set(new EdgeDriver());
            }
        }
        else {
            System.err.print("Invalid Browser Name");
        }

    }

    //Because we created enum Browser
    public BrowserUtility(Browser browserName){
        if(browserName==Browser.CHROME){
            driver.set(new ChromeDriver());
        }
        else if(browserName==Browser.EDGE){
            driver.set(new EdgeDriver());
        }
        else {
            System.err.print("Invalid Browser Name");
        }

    }


    public void goToWebsite(String url){
        driver.get().get(url);
    }

    public void maximizeWindow(){
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator){
        WebElement element = driver.get().findElement(locator);
        element.click();
    }

    public void enterText(By locator, String textToEnter){
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By locator){
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement element = driver.get().findElement(locator);
        return element.getText();
    }

    public void closeBrowser(){
        driver.get().quit();
    }
}
