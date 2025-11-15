package com.ui.tests;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;
import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest2 {

    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();
       // BrowserUtility browserUtility =  new BrowserUtility(wd); --not possible because we cannot create object of Abstract class

        HomePage homePage = new HomePage(Browser.CHROME); // because we create object of child class which is HomePage
        //homePage.goToWebsite("http://www.automationpractice.pl/index.php");

        //We have commented above line because now we are navigating directly inside HomePage constructor
        LoginPage loginPage= homePage.goToLoginPage();
        loginPage.doLoginWith("16abhisingh@gmail.com","Abhi@12345");

    }
}
