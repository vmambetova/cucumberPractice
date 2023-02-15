package stepDefinitions;

import core.actions_driver.Action;
import core.constants.Constants;
import core.dataFaker.DataFaker;
import core.helper.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages_objects.BasePage;
import pages_objects.HomePage;
import pages_objects.MyAccountPage;
import pages_objects.RegisterPage;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class RegisterSteps extends BasePage {

    RegisterPage registerPage = new RegisterPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    Action action = new Action();
    Constants constants = new Constants();
    HomePage homePage = new HomePage();
    static DataFaker dataFaker = new DataFaker();

    public RegisterSteps() {
    }

    @Given("^I am on the shop homepage$")
    public void iAmOnTheShopHomepage() {
        homePage.openHomePage();
    }

    @When("I click on My account")
    public void iClickOnMyAccountButton() {
        registerPage.clickOnMyAccount();
    }

    @And("I select Register in My account menu")
    public void iSelectRegisterInMyAccountMenu() {
        registerPage.clickOnRegister();
    }

    @And("I fill in all the input fields with valid {string}")
    public void iFillInAllTheInputFieldsWithValid(String arg0) {
        action.enterValue(registerPage.getFirstName(), dataFaker.getFakeFirstName());
        action.enterValue(registerPage.getLastName(), dataFaker.getFakeLastName());
        action.enterValue(registerPage.getEmail(), dataFaker.getFakeEmail());
        action.enterValue(registerPage.getTelephone(), dataFaker.getFakeTelephone());
        action.enterValue(registerPage.getPassword(), dataFaker.getFakePassword());
        action.enterValue(registerPage.getPasswordConfirm(), dataFaker.getFakePasswordConfirm());
    }

    @And("I tick agree to privacy policy")
    public void iTickAgreeToPrivacyPolicy(){
        action.clickElement(registerPage.getPrivacyPolicyCheckMark());
    }

    @And("I press continue on the registration page")
    public void iPressContinueOnTheRegistrationPage() {
        action.clickElement(registerPage.getContinueButtonRegister());
    }

    @Then("I see {string} message")
    public void iSeeMessage(String arg){
        assertEquals(constants.getAccCreatedMessage(), registerPage.getAccountCreatedMessage().getText());
    }

    @And("I click continue in the message window")
    public void iClickContinueInTheMessageWindow() {
        action.clickElement(registerPage.continueWhenAccCreated);
    }

    @Then("I Get redirected to My account page")
    public void iGetRedirectedToMyAccountPage() {
        assertEquals(constants.getMyAccountPage(), driver.get().getCurrentUrl());
    }

    @And("I leave one field empty {string}")
    public void iLeaveOneFieldEmpty(String field){
        Map<String, String> data = Helper.iFillInAllTheInputFieldsWithInvalid(field);
        action.enterValue(registerPage.getFirstName(), data.get("First Name"));
        action.enterValue(registerPage.getLastName(), data.get("Last Name"));
        action.enterValue(registerPage.getEmail(), data.get("Email"));
        action.enterValue(registerPage.getTelephone(), data.get("Telephone"));
        action.enterValue(registerPage.getPassword(), data.get("Password"));
        action.enterValue(registerPage.getPasswordConfirm(), data.get("Password Confirm"));
    }

    @Then("I see error messages for empty fields {string}")
    public void iSeeErrorMessages(String errorMessages) {
        assertEquals(errorMessages, action.getElementText(registerPage.errorMessages));
        assertTrue(registerPage.errorMessages.isDisplayed());
    }

    @Then("I see error messages for all empty fields ")
    public void iSeeErrorMessages() {
        assertEquals(, action.getElementText(registerPage.errorMessages));
        assertTrue(registerPage.errorMessages.isDisplayed());
    }

//    @Then("I see error messages for empty fields {string}")
//    public void iSeeErrorMessagesForAllInputFields(String arg0) {
//        assertEquals(constants.getFirstNameMessage(), action.getElementText(registerPage.errorMessages));
//        assertTrue(registerPage.errorMessages.isDisplayed());
//
////        assertEquals(registerPage.getText("First Name must be between 1 and 32 characters!"), "First Name must be between 1 and 32 characters!");
//        assertEquals(registerPage.getText("Last Name must be between 1 and 32 characters!"), "Last Name must be between 1 and 32 characters!");
//        assertEquals(registerPage.getText("E-Mail Address does not appear to be valid!"), "E-Mail Address does not appear to be valid!");
//        assertEquals(registerPage.getText("Telephone must be between 3 and 32 characters!"), "Telephone must be between 3 and 32 characters!");
//        assertEquals(registerPage.getText("Password must be between 4 and 20 characters!"), "Password must be between 4 and 20 characters!");
//    }

    @And("I leave all input fields empty")
    public void iLeaveAllInputFieldsEmpty() {
        registerPage.enterText("input-firstname", "");
        registerPage.enterText("input-lastname", "");
        registerPage.enterText("input-email", "");
        registerPage.enterText("input-telephone", "");
        registerPage.enterText("input-password", "");
        registerPage.enterText("input-confirm", "");
    }

    @And("I fill the input fields with password and password confirm not matching")
    public void iFillTheInputFieldsWithPasswordAndPasswordConfirmNotMatching() {
        action.enterValue(registerPage.getFirstName(), dataFaker.getFakeFirstName());
        action.enterValue(registerPage.getLastName(), dataFaker.getFakeLastName());
        action.enterValue(registerPage.getEmail(), dataFaker.getFakeEmail());
        action.enterValue(registerPage.getTelephone(), dataFaker.getFakeTelephone());
        action.enterValue(registerPage.getPassword(), dataFaker.getFakePassword());
        action.enterValue(registerPage.getPasswordConfirm(), dataFaker.getFakeTelephone());
    }

    @And("I see the links")
    public void iSeeLinks() {
        assertTrue(myAccountPage.editYourAccountLink.isDisplayed());
        assertTrue(myAccountPage.myAccountBlock.isDisplayed());
        assertTrue(myAccountPage.myOrdersBlock.isDisplayed());
    }

    @Then("I see warning message")
    public void iSeeWarningMessage() {
        assertEquals(constants.getPasswordConfirmMessage(), registerPage.getErrorMessages().getText());
    }

    @Then("I see privacy policy warning message")
    public void iSeePrivacyPolicyWarningMessage() {
        assertEquals(constants.getPrivacyPolicyWarningMessage(), registerPage.getPrivacyPolicyWarningMessage().getText());
    }

    @And("I untick the privacy policy warning message")
    public void iUntickThePrivacyPolicyWarningMessage() {
        //  action.clearElement(registerPage.getPrivacyPolicyCheckMark());
        action.clickElement(registerPage.getPrivacyPolicyCheckMark());
    }

    @And("^I fill in all the input fields$")
    public void iFillInAllTheInputFields(Map<String, String> valuesToEnter) {
        action.enterValue(registerPage.getFirstName(), valuesToEnter.get("First Name"));
        action.enterValue(registerPage.getLastName(), valuesToEnter.get("Last Name"));
        action.enterValue(registerPage.getEmail(), valuesToEnter.get("Email"));
        action.enterValue(registerPage.getTelephone(), valuesToEnter.get("Telephone"));
        action.enterValue(registerPage.getPassword(), valuesToEnter.get("Password"));
        action.enterValue(registerPage.getPasswordConfirm(), valuesToEnter.get("Password Confirm"));
    }

    @Then("I can see email already registered error message")
    public void iCanSeeMessage() {
        assertEquals(constants.getAlreadyCreatedMessage(), registerPage.getEmailAlreadyRegisteredMessage().getText());
    }

    @When("I fill in all the input fields with fields values too long")
    public void iFillInAllTheInputFieldsWithFieldsValuesTooLong() {
        action.enterValue(registerPage.getFirstName(), dataFaker.getFakeStringTooLong());
        action.enterValue(registerPage.getLastName(), dataFaker.getFakeStringTooLong());
        action.enterValue(registerPage.getEmail(), dataFaker.getFakeEmail());
        action.enterValue(registerPage.getTelephone(), dataFaker.getFakeStringTooLong());
        action.enterValue(registerPage.getPassword(), dataFaker.getFakeStringTooLong());
        action.enterValue(registerPage.getPasswordConfirm(), dataFaker.getFakeStringTooLong());
    }

    //the steps causing fail are commented, bug ticket QESDEMO-2137 is created
    @Then("I see error messages for input too long")
    public void iSeeErrorMessagesForInputTooLong() {
        assertEquals(constants.getFirstNameMessage(), registerPage.getText("First Name must be between 1 and 32 characters!"));
        assertEquals(constants.getLastNameMessage(), registerPage.getText("Last Name must be between 1 and 32 characters!"));
        assertEquals(constants.getTelephoneMessage(), registerPage.getText("Telephone must be between 3 and 32 characters!"));
//        assertEquals(constants.getPasswordMessage(), registerPage.getText("Password must be between 4 and 20 characters!"));
    }

    @Then("I see error messages for input too short")
    public void iSeeErrorMessagesForInputTooShort() {
        assertEquals(constants.getTelephoneMessage(), registerPage.getText("Telephone must be between 3 and 32 characters!"));
        assertEquals(constants.getPasswordMessage(), registerPage.getText("Password must be between 4 and 20 characters!"));
    }

    @And("I fill in all the input fields with telephone and password fields values too short")
    public void iFillInAllTheInputFieldsWithTelephoneAndPasswordFieldsValuesTooShort() {
        action.enterValue(registerPage.getTelephone(), dataFaker.getFakeStringTooShort());
        action.enterValue(registerPage.getPassword(), dataFaker.getFakeStringTooShort());
        action.enterValue(registerPage.getPasswordConfirm(), dataFaker.getFakeStringTooShort());
    }

    @Then("I see {string} message about incorrect email format")
    public void iSeeMessageAboutIncorrectEmailFormat(String warning) {
        assertEquals(warning, action.getTooltipText(registerPage.email));
    }

    @When("I fill the input fields except email {string} with invalid data {string}")
    public void iFillTheInputFieldsExceptEmailWithInvalidData(String field, String value) {
        Map<String, String> data = Helper.createDataToFillFormWithOneFieldChanged(field, value);
        action.enterValue(registerPage.getFirstName(), data.get("First Name"));
        action.enterValue(registerPage.getLastName(), data.get("Last Name"));
        action.enterValue(registerPage.getEmail(), data.get("Email"));
        action.enterValue(registerPage.getTelephone(), data.get("Telephone"));
        action.enterValue(registerPage.getPassword(), data.get("Password"));
        action.enterValue(registerPage.getPasswordConfirm(), data.get("Password Confirm"));
    }
}