package com.ui.pages;

import com.constants.Browser;
import com.constants.Env;
import com.utility.BrowserUtility;
import com.utility.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//child class will always be final
public final class HomePage extends BrowserUtility {

    private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");


    public HomePage(Browser browserName) {
        super(browserName);  // To call parent class constructor from child class
      //  goToWebsite("http://www.automationpractice.pl/index.php");
        goToWebsite(PropertiesUtil.readProperty(Env.QA,"URL"));
    }

    public HomePage(Browser browserName, boolean isHeadless) {
        super(String.valueOf(browserName),isHeadless);  // To call parent class constructor from child class
        //  goToWebsite("http://www.automationpractice.pl/index.php");
        goToWebsite(PropertiesUtil.readProperty(Env.QA,"URL"));
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLoginPage(){  // These are called as Page Functions and Page Functions return type -
        //cannot be void, we will give the return type of that page which will be coming after action
        clickOn(SIGN_IN_LOCATOR);
        maximizeWindow();
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;
    }
}
