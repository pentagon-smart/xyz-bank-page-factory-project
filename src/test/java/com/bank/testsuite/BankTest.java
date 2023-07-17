package com.bank.testsuite;

import com.bank.customlisteners.CustomListeners;
import com.bank.pages.*;
import com.bank.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class BankTest extends BaseTest {

    BankManagerLoginPage bankManagerLoginPage;
    AddCustomerPage addCustomerPage;
    OpenAccountPage openAccountPage;
    CustomersPage customersPage;
    CustomerLoginPage customerLoginPage;
    AccountPage accountPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT()
    {
        bankManagerLoginPage = new BankManagerLoginPage();
        addCustomerPage = new AddCustomerPage();
        openAccountPage = new OpenAccountPage();
        customersPage = new CustomersPage();
        customerLoginPage = new  CustomerLoginPage();
        accountPage = new AccountPage();

    }


    @Test(groups = {"sanity","regression"})
    public void bankManagerShouldAddCustomerSuccessfully() throws InterruptedException {
        // click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManager();
        Thread.sleep(1000);

        //	click On "Add Customer" Tab
        addCustomerPage.clickOnAddCustomer();
        Thread.sleep(1000);

        //	enter FirstName
        addCustomerPage.enterFirstName("Poonam");
        Thread.sleep(1000);

        //	enter LastName
        addCustomerPage.enterLastName("Ramavat");
        Thread.sleep(1000);

        //	enter PostCode
        addCustomerPage.enterPostCode("123456");
        Thread.sleep(1000);

        //	click On "Add Customer" Button
        addCustomerPage.clickOnAddCustomerButton();

        //	popup display
        //	verify message "Customer added successfully"
        addCustomerPage.getPopupText();

        //	click on "ok" button on popup.
        addCustomerPage.clickOnPopUp();
    }
    @Test(groups = {"sanity", "smoke","regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        //click On "Bank Manager Login" Tab
        bankManagerLoginPage.clickOnBankManager();
        Thread.sleep(1000);

        //	click On "Open Account" Tab
        openAccountPage.clickOnOpenAccount();
        Thread.sleep(1000);

        //	Search customer that created in first test
        openAccountPage.selectCustomerName("Hermoine Granger");
        Thread.sleep(1000);

        //	Select currency "Pound"
        openAccountPage.selectCurrency("Pound");
        Thread.sleep(1000);

        //	click on "process" button
        openAccountPage.clickOnProcess();
        Thread.sleep(1000);

        //	popup displayed
        //	verify message "Account created successfully"
        addCustomerPage.getPopupText();
        //	click on "ok" button on popup.
        addCustomerPage.clickOnPopUp();
    }

    @Test(groups = {"smoke","regression"})
    public void customerShouldLoginAndLogoutSuceessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customersPage.clickOnCustomerButton();
        Thread.sleep(1000);

        //	search customer that you created.
        customersPage.selectCustomerFromDropDown("Harry Potter");
        Thread.sleep(1000);

        //	click on "Login" Button
        customerLoginPage.clickOnLogin();
        Thread.sleep(1000);

        //	verify "Logout" Tab displayed.
        Assert.assertEquals(customerLoginPage.getComponentsText(),"Logout","Logout is not dispalyed");
        Thread.sleep(1000);

        //	click on "Logout"
        customerLoginPage.clickOnLogout();
        Thread.sleep(1000);

        //	verify "Your Name" text displayed.
        Assert.assertEquals(customerLoginPage.getYourNameText(),"Your Name :","text is not dispalyed");


    }

    @Test(groups = {"regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customersPage.clickOnCustomerButton();
        Thread.sleep(1000);

        //	search customer that you created.
        customersPage.selectCustomerFromDropDown("Harry Potter");
        Thread.sleep(1000);

        //	click on "Login" Button
        customerLoginPage.clickOnLogin();
        Thread.sleep(1000);

        //	click on "Deposit" Tab
        accountPage.clickOnDeposite();
        Thread.sleep(1000);

        //	Enter amount 100
        accountPage.enterAmount("100");
        Thread.sleep(1000);

        //	click on "Deposit" Button
        accountPage.clickOnDepositeButton();
        Thread.sleep(1000);

        //	verify message "Deposit Successful"
        Assert.assertEquals(accountPage.getDepositeText(),
                "Deposit Successful", "Deposit Successful is not displayed");

    }

    @Test(groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        //click on "Customer Login" Tab
        customersPage.clickOnCustomerButton();
        Thread.sleep(1000);
        //	search customer that you created.
        customersPage.selectCustomerFromDropDown("Harry Potter");
        Thread.sleep(1000);

        //	click on "Login" Button
        customerLoginPage.clickOnLogin();
        Thread.sleep(1000);

        //	click on "Withdrawl" Tab
        accountPage.clickOnWithdrawl();
        Thread.sleep(1000);

        //	Enter amount 50
        accountPage.enterAmountWithdraw("50");
        Thread.sleep(1000);

        //	click on "Withdrawl" Button
        accountPage.clickOnWithdraw();
//        Assert.assertEquals(accountPage.getWithdrawText(),
//                "Transaction Successful", "Transaction Successful is not displayed");
    }
}
