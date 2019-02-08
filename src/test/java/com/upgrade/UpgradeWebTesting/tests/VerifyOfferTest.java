package com.upgrade.UpgradeWebTesting.tests;

import com.upgrade.UpgradeWebTesting.commons.TestBase;
import com.upgrade.UpgradeWebTesting.data.UserData;
import com.upgrade.UpgradeWebTesting.pages.checkYourRatePage;
import com.upgrade.UpgradeWebTesting.pages.loginPage;
import com.upgrade.UpgradeWebTesting.pages.offerPage;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyOfferTest extends TestBase {
    JSONObject json = new JSONObject();

    @Test(priority = 0, description = "Check Your Rate")
    public void checkYourRate()
    {   checkYourRatePage borrower = new checkYourRatePage(driver);
        offerPage offer = new offerPage(driver);

        borrower.typeOnAmount(UserData.AMOUNT);
        borrower.selectAnyPurpose();
        borrower.clickOnCheckYourRateButton();
        borrower.typeOnFirstName(UserData.FIRSTNAME);
        borrower.typeOnLastName(UserData.LASTNAME);
        borrower.typeOnHomeAddress(UserData.HOMEADDRESS);
        borrower.typeOnCity(UserData.CITY);
        borrower.typeOnState(UserData.STATE);
        borrower.typeOnZipCode(UserData.ZIPCODE);
        borrower.typeOnDOB(UserData.DOB);
        borrower.typeOnIndivIncome(UserData.ANNUALINCOME);
        borrower.typeOnAdditionalIncome(UserData.ADDITIONALINCOME);
        borrower.typeOnEmail(UserData.EMAIL);
        borrower.typeOnPassword(UserData.PASSWORD);
        borrower.clickOnAgreements();
        borrower.clickOnSubmitPersonalInfo();
        json = offer.storeInfo();
        offer.clickOnSignOut();
    }
    @Test(priority = 1, description = "Make Sure you are in Offer Page")
    public void checkOfferPage()
    {   loginPage user = new loginPage(driver);
        offerPage offer = new offerPage(driver);

        driver.get(UserData.URL2);
        user.typeOnEmail(UserData.EMAIL);
        user.typeOnPassword(UserData.PASSWORD);
        user.clickOnSignIn();
        Assert.assertTrue(offer.isOfferPageDisplayed());
    }
    @Test(priority = 2, description = "Make Sure the data matches with store one")
    public void checkData()
    {   offerPage offer = new offerPage(driver);

        Assert.assertTrue(offer.validateData(json));
    }

}
