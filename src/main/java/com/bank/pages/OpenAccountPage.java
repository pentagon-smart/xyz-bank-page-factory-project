package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class OpenAccountPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Open Account']")
    WebElement openAccount;

    @CacheLookup
    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customer;
    @CacheLookup
    @FindBy(xpath = "//select[@id='currency']")
    WebElement pound;

    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement process;
    public void clickOnOpenAccount(){
        clickOnElement(openAccount);
    }

    public void selectCustomerName(String Text){
        selectByVisibleTextFromDropDown(customer,Text);
    }
    public void selectCurrency(String Text){
        selectByVisibleTextFromDropDown(pound,Text);
    }
    public void clickOnProcess(){
        clickOnElement(process);
    }

}
