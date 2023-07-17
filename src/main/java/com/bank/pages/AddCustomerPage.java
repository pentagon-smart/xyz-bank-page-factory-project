package com.bank.pages;

import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class AddCustomerPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add Customer']")
    WebElement addCustomer;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement fName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lName;
    @CacheLookup
    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postcode;
    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement addCustomerButton;


    public void clickOnAddCustomer(){
        clickOnElement(addCustomer);
    }
    public void enterFirstName(String name){
        sendTextToElement(fName,name);
    }
    public void enterLastName(String surname){
        sendTextToElement(lName,surname);
    }
    public void enterPostCode(String pcode){
        sendTextToElement(postcode,pcode);
    }
    public void clickOnAddCustomerButton(){
        clickOnElement(addCustomerButton);
    }

    public void getPopupText(){
       String actualText = getTextFromAlert();
       String expectedText = getTextFromAlert();
        Assert.assertEquals(actualText,expectedText,"text is not displayed");
    }

    public void clickOnPopUp(){
        switchToAlert();
    }
}
