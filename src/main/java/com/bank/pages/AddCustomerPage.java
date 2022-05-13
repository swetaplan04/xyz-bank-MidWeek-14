package com.bank.pages;

import com.aventstack.extentreports.Status;
import com.bank.customlisteners.CustomListeners;
import com.bank.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AddCustomerPage extends Utility {
    public AddCustomerPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement getFirstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement getLastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement getPostCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement getAddCustomerBtn;

    public void inputFirstName(String fName) {
        sendTextToElement(getFirstName, fName);
        CustomListeners.test.log(Status.PASS,"Enter first name: " + fName);
        Reporter.log("Enter first name: " + fName);
    }

    public void inputLastName(String lName) {
        sendTextToElement(getLastName, lName);
        CustomListeners.test.log(Status.PASS,"Enter last name: " + lName);
        Reporter.log("Enter last name: " + lName);
    }

    public void inputPostcode(String postcode) {
        sendTextToElement(getPostCode, postcode);
        CustomListeners.test.log(Status.PASS,"Enter postcode: " + postcode);
        Reporter.log("Enter postcode: " + postcode);
    }

    public void clickOnAddCustomerButton() {
        clickOnElement(getAddCustomerBtn);
        CustomListeners.test.log(Status.PASS,"Click on add customer button ");
        Reporter.log("Click on add customer button ");
    }

    public void acceptPopUpMessage(){
        acceptAlert();
        CustomListeners.test.log(Status.PASS,"Accept the alert ");
        Reporter.log("Accept the alert ");
    }

    public void verifyPopUpMessage(){

        String actual = getTextFromAlert();
        String expected = "Customer added successfully with customer id :6";
        Assert.assertEquals(actual.substring(0,25),expected.substring(0,25),"wrong popup message");
        CustomListeners.test.log(Status.PASS,"Verifying 'customer added successfully' popup text");
        Reporter.log("Verifying 'customer added successfully' popup text");
    }
}


