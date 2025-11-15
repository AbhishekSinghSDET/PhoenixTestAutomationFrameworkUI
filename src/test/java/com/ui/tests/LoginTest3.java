package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;


public class LoginTest3 {

    public static void main(String[] args) {
        //WebDriver wd = new ChromeDriver();

        HomePage homePage = new HomePage(Browser.CHROME);
        String userName = homePage.goToLoginPage().doLoginWith("16abhisingh@gmail.com","Abhi@12345").getUserName();
        System.out.println(userName);
    }
}
