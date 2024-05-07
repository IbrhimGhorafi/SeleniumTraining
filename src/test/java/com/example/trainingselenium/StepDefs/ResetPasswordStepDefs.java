package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.*;
import com.example.trainingselenium.Utils.CustomListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.Assertion;


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

    @And("the user inserts a valid email {} and clicks the reset button")
    public void theUserInsertsAValidEmailAndClicksTheResetButton(String email) {
        loginPopup.enterEmailForResetPasswordInput(email);
        loginPopup.clickOnResetPasswordButton();
    }

    @Then("the user should see a popup message indicating that an email has been sent for resetting the password")
    public void theUserShouldSeeAPopupMessageIndicatingThatAnEmailHasBeenSentForResettingThePassword() {
        String messageReceivedEmailForResetPassword = loginPopup.getMessageReceivedEmail();
        Assert.assertEquals(messageReceivedEmailForResetPassword,
                "We've sent password reset instructions to your email. Check your inbox and follow the link.");
        loginPopup.clickOnBackToLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @And("the user accesses the Yopmail website")
    public void theUserAccessesTheYopmailWebsite() {
        yopMailWebSite.navigateToYopMailWebSite();
    }

    @And("the user logs in with the email {} used for password reset")
    public void theUserLogsInWithTheEmailUsedForPasswordReset(String email) {
        yopMailWebSite.enterEmail(email);
        yopMailWebSite.clickLoginYopMailButton();
    }

    @And("the user retrieves the latest email")
    public void theUserRetrievesTheLatestEmail() {
        yopMailWebSite.navigateToResetPasswordPage();
    }

    @And("the user inserts a new password {} and confirms it")
    public void theUserInsertsANewPasswordAndConfirmsIt(String newPassword) {
        resetPasswordPage.enterNewPassword(newPassword);
        resetPasswordPage.enterRepeatPassword(newPassword);
        resetPasswordPage.clickSaveNewPasswordButton();
    }

    @And("the user sees a popup confirming that the password has been successfully changed")
    public void theUserSeesAPopupConfirmingThatThePasswordHasBeenSuccessfullyChanged() {
        String messageForPasswordChangedSuccess = resetPasswordPage.getMessageForPasswordChangedSuccess();
        Assert.assertEquals(messageForPasswordChangedSuccess, "Your password has been reset successfully!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    @After
    public void tearDown() {
        WebDriverConfiguration.quitDriver();
    }
}
