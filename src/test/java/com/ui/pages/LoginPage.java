package com.ui.pages;

import com.utility.BrowserUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtility {

    final static By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    final static By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    final static By SUBMIT_BTN_LOCATOR = By.id("SubmitLogin");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public MyAccountPage doLoginWith(String username, String password){
        enterText(EMAIL_TEXT_BOX_LOCATOR,username);
        enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
        clickOn(SUBMIT_BTN_LOCATOR);
        MyAccountPage myAccountPage = new MyAccountPage(getDriver());
        return myAccountPage;
    }
}
