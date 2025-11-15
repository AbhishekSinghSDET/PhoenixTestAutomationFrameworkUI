package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LoginTest5 {
    HomePage homePage;


    @BeforeMethod(description = "Load homepage of the website")
    public void setUp(){
        homePage = new HomePage(Browser.CHROME);
    }

@Test(description = "Verify valid user is able to login into the application", groups = {"smoke","e2e"})
    public void loginTest() {
        //WebDriver wd = new ChromeDriver();

        //HomePage homePage = new HomePage(Browser.CHROME);
//        String userName = homePage.goToLoginPage().doLoginWith("16abhisingh@gmail.com","Abhi@12345").getUserName();
//        Assert.assertEquals(userName,"Abhishek Singh");

        Assert.assertEquals(homePage.goToLoginPage().doLoginWith("16abhisingh@gmail.com","Abhi@12345").getUserName(),"Abhishek Singh");
    }

@AfterMethod
    public void quitBrowser(){
        homePage.closeBrowser();
}

}
