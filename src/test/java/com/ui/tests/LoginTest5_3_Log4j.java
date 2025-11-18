package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojos.User;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest5_3_Log4j {

    HomePage homePage;


    @BeforeMethod(description = "Load homepage of the website")
    public void setUp(){
        homePage = new HomePage(Browser.CHROME);
    }


@Test(description = "Verify valid user is able to login into the application", groups = {"smoke","e2e"},
        dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) {
        //WebDriver wd = new ChromeDriver();

        //HomePage homePage = new HomePage(Browser.CHROME);
//        String userName = homePage.goToLoginPage().doLoginWith("16abhisingh@gmail.com","Abhi@12345").getUserName();
//        Assert.assertEquals(userName,"Abhishek Singh");

    Logger logger = LoggerUtility.getLogger(this.getClass());
    logger.info("Started my login test");
        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Abhishek Singh");
    logger.info("Completed my login test");
    }

@AfterMethod
    public void quitBrowser(){
        homePage.closeBrowser();
}

}
