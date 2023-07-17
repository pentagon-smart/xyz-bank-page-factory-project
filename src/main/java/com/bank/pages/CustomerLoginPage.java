package com.bank.pages;


import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomerLoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement login;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logOut;
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement verifyYourName;

    public void clickOnLogin() {
        clickOnElement(login);
    }

    public String getComponentsText() {
        return getTextFromElement(logOut);
    }

    public void clickOnLogout() {
        clickOnElement(logOut);
    }

    public String getYourNameText() {
        return getTextFromElement(verifyYourName);
    }
}
