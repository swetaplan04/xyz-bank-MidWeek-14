package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class OpenAccountPage extends Utility {

    public OpenAccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='userSelect']")
    WebElement customerName;

    @FindBy(xpath = "//select[@id='currency']")
    WebElement selectCurrency;

    @FindBy(xpath = "//button[contains(text(),'Process')]")
    WebElement processBtn;


    public void selectCustomerName(String name) throws InterruptedException {
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(customerName, name);
        CustomListeners.test.log(Status.PASS,"select customer name: "+name);
        Reporter.log("select customer name: "+name);
    }

    public void selectCurrency(String currency){
        selectByVisibleTextFromDropDown(selectCurrency, currency);
        CustomListeners.test.log(Status.PASS,"Select currency: " + currency);
        Reporter.log("Select currency: " + currency);
    }

    public void clickOnProcessButton(){
        clickOnElement(processBtn);
        CustomListeners.test.log(Status.PASS,"Click on process button ");
        Reporter.log("Click on process button ");
    }

    public void verifyAccountCreatedSuccessfullyText(){
        Reporter.log("Clicking on Process button"+"\n</br>");
        String expected = "Account created successfully with account Number :1016";
        String actual = getTextFromAlert();
        Assert.assertEquals(expected.substring(0,26),actual.substring(0,26),"wrong message");
        CustomListeners.test.log(Status.PASS,"Verifying 'account created successfully' popup text");
        Reporter.log("Verifying 'account created successfully' popup text");
    }
}

