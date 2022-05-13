package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class AccountPage extends Utility {

    public AccountPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[contains(text(),'Logout')]")
    WebElement logoutBtn;

    @FindBy(xpath = "//label[contains(text(),'Your Name :')]")
    WebElement yourNameText;

    @FindBy(xpath = "//button[normalize-space()='Deposit']")
    WebElement depositTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy(xpath = "//span[contains(text(),'Deposit Successful')]")
    WebElement depositMessage;

    @FindBy(xpath = "//button[normalize-space()='Withdrawl']")
    WebElement withdrawlTab;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawAmount;

    @FindBy(xpath = "//button[normalize-space()='Withdraw']")
    WebElement withdrawButton;

    @FindBy(xpath = "//span[contains(text(),'Transaction successful')]")
    WebElement transactionSuccessText;

    public void clickOnLogoutButton(){
        clickOnElement(logoutBtn);
        CustomListeners.test.log(Status.PASS,"Click on logout ");
        Reporter.log("Click on logout "+"<br>");
    }

    public void verifyYourNameTextVisible(String text){
        verifyThatTextIsDisplayed(yourNameText, text);
        CustomListeners.test.log(Status.PASS,"Verify 'Your Name' Text "+text);
        Reporter.log("Verify 'Your Name' Text "+text+"<br>");
    }

    public void clickOnDepositTab(){
        clickOnElement(depositTab);
        CustomListeners.test.log(Status.PASS,"Click on deposit tab ");
        Reporter.log("Click on deposit tab "+"<br>");
    }

    public void inputDepositAmount(String amount){
        sendTextToElement(depositAmount, amount);
        CustomListeners.test.log(Status.PASS,"Enter the deposit amount " + amount);
        Reporter.log("Enter the deposit amount: "+amount+ "<br>");
    }

    public void clickOnSubmitButton(){
        clickOnElement(submitBtn);
        CustomListeners.test.log(Status.PASS,"Click on deposit submit button ");
        Reporter.log("Click on deposit submit button"+"<br>");
    }

    public void verifyDepositSuccessfulMessage(String message){
        verifyThatTextIsDisplayed(depositMessage, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Deposit Successfully' message " + message);
        Reporter.log("Verify 'Deposit Successfully' message"+ "<br>");

    }

    public void clickOnWithdrawalTab(){
        clickOnElement(withdrawlTab);
        CustomListeners.test.log(Status.PASS,"Click on withdrawal button ");
        Reporter.log("Click on withdrawal button"+ "<br>");
    }

    public void inputWithdrawAmount(String amount){
        sendTextToElement(withdrawAmount, amount);
        CustomListeners.test.log(Status.PASS,"Enter withdraw amount: " + amount);
        Reporter.log("Enter withdraw amount: "+amount+"<br>");
    }

    public void clickOnWithdrawButton(){
        clickOnElement(withdrawButton);
        CustomListeners.test.log(Status.PASS,"Click on withdraw button ");
        Reporter.log("Click on withdraw button"+ "<br>");
    }

    public void verifyTransactionSuccessfulMessage(String message){
//        Reporter.log("verify 'Transaction Successful' message " + transactionSuccessText.toString() + "<br>");
        verifyThatTextIsDisplayed(transactionSuccessText, message);
        CustomListeners.test.log(Status.PASS,"Verify 'Transaction Successfully' message " + message);
        Reporter.log("Verify  'Transaction Successfully' message"+ "<br>");
    }
    public void verifyLogoutTabVisible(){
        verifyThatElementIsDisplayed(logoutBtn);
        CustomListeners.test.log(Status.PASS,"Verify logout tab visible ");
        Reporter.log("Verify logout tab is visible"+ "<br>");
    }

}

