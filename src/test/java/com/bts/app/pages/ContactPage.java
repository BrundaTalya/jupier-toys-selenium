package com.bts.app.pages;


import com.bts.app.helper.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static org.testng.Assert.assertFalse;


public class ContactPage {
    private WebDriver driver;
    private WaitHelper wait;




    private By headerMessage = By.xpath("//*[@id='header-message']/div/strong");
    private By submitButton = By.xpath("//a[contains(text(),'Submit')]");
    private By forenameErr = By.id("forename-err");
    private By emailErr = By.xpath("//*[@id='email-err']");
    private By msgErr = By.xpath("//*[@id='message-err']");
    private By forenameTextField = By.id("forename");
    private By emailTextField = By.xpath("//*[@id='email']");
    private By messageTextField = By.name("message");
    private By successMessage = By.xpath("//div[@class='alert alert-success']");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
    }


    public void validateContactPageHeader() {
        wait = new WaitHelper(driver);
        wait.waitForElement(headerMessage);
        String contactHeader = driver.findElement(headerMessage).getText();
        Assert.assertTrue(contactHeader.contains("We welcome your feedback"));
    }

    public void clickOnSubmitButton() {
        wait = new WaitHelper(driver);
        wait.waitForElement(submitButton);
        wait.waitForElementClick(submitButton);
        driver.findElement(submitButton).click();

    }

    public void verifyErrMessagesForMandantoryFields(){
       assert driver.findElement(forenameErr).isDisplayed();
       assert driver.findElement(emailErr).isDisplayed();
       assert driver.findElement(msgErr).isDisplayed();
    }

    public void populateMandatoryFields(String name, String email, String message){
        wait = new WaitHelper(driver);
        wait.waitForElement(forenameTextField);
        wait.waitForElement(emailTextField);
        wait.waitForElement(messageTextField);

        driver.findElement(forenameTextField).sendKeys(name);
        driver.findElement(emailTextField).sendKeys(email);
        driver.findElement(messageTextField).sendKeys(message);
    }


    public void verifyErrorMessagesForMandatoryFieldsAreGone(){
        wait = new WaitHelper(driver);
        wait.waitForElementInvisible(forenameErr);
        wait.waitForElementInvisible(emailErr);
        wait.waitForElementInvisible(msgErr);
        assertFalse(isElementPresent(forenameErr));
        assertFalse(isElementPresent(emailErr));
        assertFalse(isElementPresent(msgErr));
    }

    public boolean isElementPresent(By element){
        try {
            driver.findElement(element);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public void validateSuccessMessage() {
        wait = new WaitHelper(driver);
        wait.waitForElement(successMessage);
        String successMessageText = driver.findElement(successMessage).getText();
        Assert.assertTrue(successMessageText.contains(", we appreciate your feedback."));
    }

}
