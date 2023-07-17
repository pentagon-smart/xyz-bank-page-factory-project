package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement deposite;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement ammount;

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submit;
    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyDeposite;
    @CacheLookup
    @FindBy(xpath = "//span[@class='error ng-binding']")
    WebElement verifyWithdraw;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawl;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdraw;

    public void clickOnDeposite(){
        clickOnElement(deposite);
    }
    public void enterAmount(String amount){
        sendTextToElement(ammount,amount);
    }
    public void enterAmountWithdraw(String amount){
        sendTextToElement(ammount, amount);
    }
    public void clickOnDepositeButton(){
        clickOnElement(submit);
    }

    public String getDepositeText() {
        return getTextFromElement(verifyDeposite);
    }

    public String getWithdrawText() {
        return getTextFromElement(verifyWithdraw);
    }
    public void clickOnWithdrawl(){
        clickOnElement(withdrawl);
    }
    public void clickOnWithdraw(){
        clickOnElement(withdraw);
    }
}
