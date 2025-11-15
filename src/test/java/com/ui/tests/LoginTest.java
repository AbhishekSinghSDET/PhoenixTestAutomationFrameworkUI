package com.ui.tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    public static void main(String[] args) {
        WebDriver wd = new ChromeDriver();

        wd.get("http://www.automationpractice.pl/index.php");

        wd.manage().window().maximize();

        By signInLinkLocator = By.xpath("//a[contains(text(),'Sign in')]");
        WebElement signInLinkWebElement = wd.findElement(signInLinkLocator);
        signInLinkWebElement.click();

        By emailTextBoxLocator = By.id("email");
        WebElement emailWebElement = wd.findElement(emailTextBoxLocator);
        emailWebElement.sendKeys("16abhisingh@gmail.com");

        By passwordTextBoxLocator = By.id("passwd");
        WebElement passwordWebElement = wd.findElement(passwordTextBoxLocator);
        passwordWebElement.sendKeys("Abhi@12345");

        By submitBtnLocator = By.id("SubmitLogin");
        WebElement submitBtnWebElement = wd.findElement(submitBtnLocator);
        submitBtnWebElement.click();

        wd.quit();

    }
}
