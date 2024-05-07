package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.ChooseCountryAndCurrencyForShoppingPopup;
import com.example.trainingselenium.Pages.CookiesPopup;
import com.example.trainingselenium.Pages.HomePage;
import com.example.trainingselenium.Pages.LoginPopup;
import com.example.trainingselenium.Utils.CustomListener;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

@Slf4j
public class LoginStepDefs {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPopup loginPopup;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        log.info("Setup Driver" + driver);
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        loginPopup = pageObjectInitialization.getLoginPopup();
    }

    @When("the user attempts to login with valide {} and {}")
    public void theUserAttemptsToLoginWithValideEmailAndPassword(String email, String password) {
        loginPopup.enterEmailLoginInput(email);
        loginPopup.enterPasswordLoginInput(password);
        loginPopup.clickOnLoginButton();
    }

    @Then("the user is successfully logged in")
    public void theUserIsSuccessfullyLoggedIn() {
        String messageSuccessLoggedIn = loginPopup.getMessageSuccessLoggedIn();
        Assert.assertEquals(messageSuccessLoggedIn, "You are logged in!");
    }

    @And("the user access to the Account page")
    public void theUserAccessToTheAccountPage() {
        homePage.navigateToDetailsPage();

    }
}
