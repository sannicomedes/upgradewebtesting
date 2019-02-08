package com.upgrade.UpgradeWebTesting.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class checkYourRatePage extends PageBase
{
    private By amount = By.name("desiredAmount");
    private By purpose = By.cssSelector("select[data-auto='dropLoanPurpose']");
    private By checkyourrate = By.cssSelector("button[data-auto='CheckYourRate']");
    private By firstName = By.cssSelector("input[data-auto='borrowerFirstName']");
    private By lastName = By.cssSelector("input[data-auto='borrowerLastName']");
    private By homeAddress = By.name("borrowerStreet");
    private By city = By.name("borrowerCity");
    private By state = By.name("borrowerState");
    private By zip = By.name("borrowerZipCode");
    private By dob = By.name("borrowerDateOfBirth");
    private By individualIncome = By.name("borrowerIncome");
    private By additionalIncome = By.name("borrowerAdditionalIncome");
    private By agreements = By.xpath("//*[@id='root']/div/main/div/div[1]/div[3]/div[1]/div/div/form/div[3]/div/label/div[1]");
    private By submit = By.cssSelector("button[data-auto='submitPersonalInfo']");
    public checkYourRatePage(WebDriver driver) {
        super(driver);
    }

    public void  typeOnAmount(String qty)
    {
        driver.findElement(amount).sendKeys(qty);
    }
    public void selectAnyPurpose()
    {   Select purposeDropdown = new Select(driver.findElement(purpose));

        purposeDropdown.selectByValue("CREDIT_CARD");

    }
    public void clickOnCheckYourRateButton ()
    {
        driver.findElement(checkyourrate).click();
    }
    public void typeOnFirstName(String name)
    {
        driver.findElement(firstName).sendKeys(name);
    }
    public void typeOnLastName(String last)
    {
        driver.findElement(lastName).sendKeys(last);
    }
    public void typeOnHomeAddress(String address){
        driver.findElement(homeAddress).sendKeys(address);
    }
    public void typeOnCity(String ct){
        driver.findElement(city).sendKeys(ct);
    }
    public void typeOnState(String st){
        driver.findElement(state).sendKeys(st);
    }
    public void typeOnZipCode(String code){
        driver.findElement(zip).sendKeys(code);
    }
    public void typeOnDOB(String birth){
        driver.findElement(dob).sendKeys(birth);
    }
    public void typeOnIndivIncome(String income){
        driver.findElement(individualIncome).sendKeys(income);
    }
    public void typeOnAdditionalIncome(String income){
        driver.findElement(additionalIncome).sendKeys(income);
    }
    public void clickOnAgreements ()
    {
        driver.findElement(agreements).click();
    }
    public void clickOnSubmitPersonalInfo(){
        driver.findElement(submit).click();
    }
}

