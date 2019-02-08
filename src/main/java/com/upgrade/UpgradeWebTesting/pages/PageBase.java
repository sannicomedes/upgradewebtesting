package com.upgrade.UpgradeWebTesting.pages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageBase {
    protected By email = By.name("username");
    protected By password = By.name("password");
    protected static Log log = LogFactory.getLog(PageBase.class);
    protected WebDriver driver;

    public PageBase(WebDriver driver)
    {
        this.driver=driver;
    }

    public void typeOnEmail(String mail){
        driver.findElement(email).sendKeys(mail);
    }
    public void typeOnPassword(String pass){
        driver.findElement(password).sendKeys(pass);
    }

}


