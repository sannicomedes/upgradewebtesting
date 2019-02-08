package com.upgrade.UpgradeWebTesting.core;

import com.upgrade.UpgradeWebTesting.data.UserData;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;


public class SetUp {
    private WebDriver driver;
    Log log = LogFactory.getLog(getClass());

    public void setup() throws MalformedURLException {
        log.info("Webdriver is setting up ");
        ChromeDriverManager.getInstance().forceCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(GlobalParameters.DEFAULT_DRIVER_TIMEOUT, TimeUnit.SECONDS);
        driver.get(UserData.URL1);
    }
    public WebDriver getDriver()
    {
        return driver;
    }
}

