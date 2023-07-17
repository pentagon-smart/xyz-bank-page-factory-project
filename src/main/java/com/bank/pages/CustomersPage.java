package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class CustomersPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Customer Login']")
    WebElement customerButton;
    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement searchCustomer;

    public void clickOnCustomerButton(){
        clickOnElement(customerButton);
    }
    public void selectCustomerFromDropDown(String name){
        selectByVisibleTextFromDropDown(searchCustomer, name);
    }
}
