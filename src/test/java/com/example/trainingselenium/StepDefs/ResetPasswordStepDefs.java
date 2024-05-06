package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ResetPasswordStepDefs {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPopup loginPopup;
    private YopMailWebSite yopMailWebSite;
    private ResetPasswordPage resetPasswordPage;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        loginPopup = pageObjectInitialization.getLoginPopup();
        yopMailWebSite = pageObjectInitialization.getYopMailWebSite();
        resetPasswordPage = pageObjectInitialization.getResetPasswordPage();
    }

    @And("the user has accessed the login form")
    public void theUserHasAccessedTheLoginForm() {
        homePage.clickOnIconPersonButton();
    }

    @When("the user attempts to reset the password")
    public void theUserAttemptsToResetThePassword() {
        loginPopup.clickOnForgetPasswordLink();
    }

    @And("the user inserts a valid email and clicks the reset button")
    public void theUserInsertsAValidEmailAndClicksTheResetButton() {
        loginPopup.enterEmailForResetPasswordInput("boijautrissas7@yopmail.com");
        loginPopup.clickOnResetPasswordButton();
    }

    @Then("the user should see a popup message indicating that an email has been sent for resetting the password")
    public void theUserShouldSeeAPopupMessageIndicatingThatAnEmailHasBeenSentForResettingThePassword() {

    }

    @And("the user accesses the Yopmail website")
    public void theUserAccessesTheYopmailWebsite() {
        yopMailWebSite.navigateToYopMailWebSite();
    }

    @And("the user logs in with the email used for password reset")
    public void theUserLogsInWithTheEmailUsedForPasswordReset() {
        yopMailWebSite.enterEmail("boijautrissas7@yopmail.com");
        yopMailWebSite.clickLoginYopMailButton();
    }

    @And("the user retrieves the latest email")
    public void theUserRetrievesTheLatestEmail() {
        yopMailWebSite.navigateToResetPasswordPage();
    }

    @And("the user inserts a new password and confirms it")
    public void theUserInsertsANewPasswordAndConfirmsIt() {
        resetPasswordPage.enterNewPassword("boijautrissas7@yopmail.com");
        resetPasswordPage.enterRepeatPassword("boijautrissas7@yopmail.com");
        resetPasswordPage.clickSaveNewPasswordButton();
    }

    @And("the user sees a popup confirming that the password has been successfully changed")
    public void theUserSeesAPopupConfirmingThatThePasswordHasBeenSuccessfullyChanged() {
    }

    @Then("the user logs in with the new password")
    public void theUserLogsInWithTheNewPassword() {
    }

    @And("the user sees a popup confirming that they have successfully logged in")
    public void theUserSeesAPopupConfirmingThatTheyHaveSuccessfullyLoggedIn() {
    }

    @And("the user successfully accesses their account")
    public void theUserSuccessfullyAccessesTheirAccount() {
    }

    @After
    public void tearDown() {
        WebDriverConfiguration.quitDriver();
    }
}
