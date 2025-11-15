package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import org.testng.annotations.Test;


public class LoginTest4 {

@Test(description = "Verify valid user is able to login into the application", groups = {"smoke","e2e"})
    public void loginTest() {
        //WebDriver wd = new ChromeDriver();

        HomePage homePage = new HomePage(Browser.CHROME);
        String userName = homePage.goToLoginPage().doLoginWith("16abhisingh@gmail.com","Abhi@12345").getUserName();
        System.out.println(userName);
        homePage.closeBrowser();
    }


}
