package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LamdaTestUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    protected HomePage homePage;
    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLamdaTest;


    @Parameters({"browser","isLamdaTest","isHeadless"})
    @BeforeMethod(description = "Load homepage of the website")
    public void setUp(
            @Optional("chrome") String browser,
            @Optional("false") boolean isLamdaTest,
            @Optional("false") boolean isHeadless, ITestResult result){

        this.isLamdaTest = isLamdaTest;
        WebDriver lamdaDriver;
        if(isLamdaTest){
            lamdaDriver = LamdaTestUtility.initializeLamdaTestSession(browser,result.getMethod().getMethodName());
            homePage = new HomePage(lamdaDriver);
        }

        else {
            //Run test on local machine
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }
    }

    public BrowserUtility getInstance(){
        return homePage;
    }

    @AfterMethod(description = "close browser session")
    public void tearDown(){
        if(isLamdaTest){
            LamdaTestUtility.quitSession();
        }
        else {
            homePage.closeBrowser();
        }
    }
}
