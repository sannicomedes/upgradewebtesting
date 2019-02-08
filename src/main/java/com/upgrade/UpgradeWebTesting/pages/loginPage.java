package com.upgrade.UpgradeWebTesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage extends PageBase {

    private By signIn = By.cssSelector("button[data-auto='login']");

    public loginPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnSignIn(){driver.findElement(signIn).click();}
}
