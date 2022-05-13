package com.bank.testsuite;

import com.bank.pages.*;
import com.bank.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BankTest extends TestBase {

    //@Listeners(CustomListeners.class)
    HomePage homePage;
    AddCustomerPage addCustomerPage;
    BankManagerLoginPage bankManagerLoginPage;
    AccountPage accountPage;
    CustomerLoginPage customerLoginPage;
    CustomersPage customersPage;
    OpenAccountPage openAccountPage;

    @BeforeMethod(alwaysRun = true)
    public void initialization() {
        homePage = new HomePage();
        addCustomerPage = new AddCustomerPage();
        bankManagerLoginPage = new BankManagerLoginPage();
        accountPage = new AccountPage();
        customerLoginPage = new CustomerLoginPage();
        customersPage = new CustomersPage();
        openAccountPage = new OpenAccountPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void bankManagerShouldAddCustomerSuccessfully() {

        homePage.clickOnBankManagerLogin();
        bankManagerLoginPage.clickOnAddCustomerTab();
        addCustomerPage.inputFirstName("Ramesh");
        addCustomerPage.inputLastName("Patel");
        addCustomerPage.inputPostcode("151541");
        addCustomerPage.clickOnAddCustomerButton();
        addCustomerPage.verifyPopUpMessage();
        addCustomerPage.acceptPopUpMessage();
    }

    @Test(priority = 1, groups = {"sanity", "smoke", "regression"})
    public void bankManagerShouldOpenAccountSuccessfully() throws InterruptedException {
        bankManagerShouldAddCustomerSuccessfully();
        bankManagerLoginPage.clickOnOpenAccountTab();
        openAccountPage.selectCustomerName("Ramesh Patel");
        openAccountPage.selectCurrency("Pound");
        openAccountPage.clickOnProcessButton();
        openAccountPage.verifyAccountCreatedSuccessfullyText();
        addCustomerPage.acceptPopUpMessage();
        homePage.clickOnHomeButton();
    }

    @Test(priority = 2, groups = {"smoke", "regression"})
    public void customerShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        bankManagerShouldOpenAccountSuccessfully();
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerName("Ramesh Patel");
        customerLoginPage.clickOnLoginButton();
        accountPage.verifyLogoutTabVisible();
        accountPage.clickOnLogoutButton();
        accountPage.verifyYourNameTextVisible("Your Name");
    }

    @Test(priority = 3, groups = {"smoke", "regression"})
    public void customerShouldDepositMoneySuccessfully() throws InterruptedException {
        customerShouldLoginAndLogoutSuccessfully();
        customersPage.selectCustomerName("Ramesh Patel");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnDepositTab();
        accountPage.inputDepositAmount("1000000");
        accountPage.clickOnSubmitButton();
        accountPage.verifyDepositSuccessfulMessage("Deposit Successful");
    }

    @Test(priority = 4, groups = {"regression"})
    public void customerShouldWithdrawMoneySuccessfully() throws InterruptedException {
        customerShouldDepositMoneySuccessfully();
        homePage.clickOnHomeButton();
        homePage.clickOnCustomerLoginButton();
        customersPage.selectCustomerName("Ramesh Patel");
        customerLoginPage.clickOnLoginButton();
        accountPage.clickOnWithdrawalTab();
        accountPage.inputWithdrawAmount("50000");
        accountPage.clickOnWithdrawButton();
        accountPage.verifyTransactionSuccessfulMessage("Transaction Successful");
    }
}

