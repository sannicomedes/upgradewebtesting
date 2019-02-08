package com.upgrade.UpgradeWebTesting.pages;

import com.upgrade.UpgradeWebTesting.utils.Logger;
import com.upgrade.UpgradeWebTesting.utils.WriteJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.json.simple.JSONObject;

import java.io.File;

public class offerPage extends PageBase
{
    private By loanAmount = By.cssSelector("span[data-auto='userLoanAmount']");
    private By apr = By.cssSelector("div[data-auto='defaultMoreInfoAPR']");
    private By loanTerm = By.cssSelector("div[data-auto='defaultLoanTerm']");
    private By monthlyPayment = By.cssSelector("span[data-auto='defaultMonthlyPayment']");
    private By menu = By.cssSelector("label[class='header-nav__toggle']");
    private By signOut = By.cssSelector("a[href='/phone/logout']");

    public offerPage(WebDriver driver) {
        super(driver);
    }

    public JSONObject storeInfo(){
        JSONObject json = new JSONObject();

        json.put("loanAmount",driver.findElement(loanAmount).getText());
        json.put("apr",driver.findElement(apr).getText());
        json.put("loanTerm",driver.findElement(loanTerm).getText());
        json.put("monthlyPayment",driver.findElement(monthlyPayment).getText());
        WriteJson.setJson(new File("jsons\\loan.json"), json);
        return json;
    }

    public void clickOnSignOut ()
    {
        driver.findElement(menu).click();
        driver.findElement(signOut).click();
    }

    public boolean validateData(JSONObject json){
        boolean matched = false;

        if(json.get("loanAmount").toString().equalsIgnoreCase(driver.findElement(loanAmount).getText()))
            if (json.get("apr").toString().equalsIgnoreCase(driver.findElement(apr).getText()))
                if(json.get("loanTerm").toString().equalsIgnoreCase(driver.findElement(loanTerm).getText()))
                    if(json.get("monthlyPayment").toString().equalsIgnoreCase(driver.findElement(monthlyPayment).getText())) {
                        matched = true;
                        Logger.printInfo("Data matched with stored data");
                    }
        return matched;
    }
    public boolean isOfferPageDisplayed(){
        boolean displayed = false;

        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.credify.tech/phone/offer-page")) {
            displayed = true;
            Logger.printInfo("Offer Page is Displayed");
        }
        return displayed;
    }
    public boolean isUserSignedOut(){
        boolean displayed = false;

        if(driver.getCurrentUrl().equalsIgnoreCase("https://www.credify.tech/phone/logout")) {
            displayed = true;
            Logger.printInfo("User is Signed Out");
        }
        return displayed;
    }

}

