package com.bts.app.stepdefinitions;


import com.bts.app.helper.DriverHelper;
import com.bts.app.pages.ContactPage;
import com.bts.app.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;



public class ContactPageStepdefinition {

    private HomePage homePage = new HomePage(DriverHelper.getDriver());
    private ContactPage contactPage;



    @Given("user is on home page")
    public void user_is_on_home_page() {
        homePage.navigateToHomePage();
    }

    @Then("navigate to contact page")
    public void navigate_to_contact_page() {
        contactPage = homePage.clickOnContactPage();
        contactPage.validateContactPageHeader();
    }

    @And("click on Submit button")
    public void click_on_Submit_button() {
        contactPage.clickOnSubmitButton();
    }

    @Then("error messages should be displayed")
    public void error_messages_should_be_displayed(){
        contactPage.verifyErrMessagesForMandantoryFields();
    }

    @And("populate the mandatory fields {string},{string},{string}")
    public void populate_the_mandatory_fields(String foreName, String email, String message) {
        contactPage.populateMandatoryFields(foreName, email, message);
    }

    @Then("errors should be gone")
    public void errors_should_be_gone(){
        contactPage.verifyErrorMessagesForMandatoryFieldsAreGone();
    }

    @And("populate mandatory fields {string},{string},{string}")
    public void populate_mandatory_fields(String foreName, String email, String message) {
        contactPage.populateMandatoryFields(foreName, email, message);
    }

    @Then("successful submission message should be displayed")
    public void successful_submission_message_should_be_displayed(){
        contactPage.validateSuccessMessage();
    }


}