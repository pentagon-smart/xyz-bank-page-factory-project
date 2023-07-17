package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class BankManagerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Bank Manager Login']")
    WebElement bankMangerLogin;

    public void clickOnBankManager() {
        clickOnElement(bankMangerLogin);
    }
}
