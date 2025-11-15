package com.ui.tests;

import com.com.ui.pojos.User;
import com.constants.Browser;
import com.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest5_1 {
    HomePage homePage;


    @BeforeMethod(description = "Load homepage of the website")
    public void setUp(){
        homePage = new HomePage(Browser.CHROME);
    }

@Test(description = "Verify valid user is able to login into the application", groups = {"smoke","e2e"},dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
    public void loginTest(User user) {
        //WebDriver wd = new ChromeDriver();

        //HomePage homePage = new HomePage(Browser.CHROME);
//        String userName = homePage.goToLoginPage().doLoginWith("16abhisingh@gmail.com","Abhi@12345").getUserName();
//        Assert.assertEquals(userName,"Abhishek Singh");

        Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(),"Abhishek Singh");
    }

@AfterMethod
    public void quitBrowser(){
        homePage.closeBrowser();
}

}
