package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojos.User;
import org.testng.Assert;
import org.testng.annotations.*;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest5_6_LamdaTest extends BaseTest{

    @BeforeMethod(description = "Load homepage of the website")
    public void setUp(){

        homePage = new HomePage(Browser.CHROME,true);
    }


@Test(description = "Verify valid user is able to login into the application", groups = {"smoke","e2e"},
        dataProviderClass = com.ui.dataProviders.LoginDataProvider.class,dataProvider = "LoginTestDataProvider")
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
