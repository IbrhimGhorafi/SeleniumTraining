package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.ChooseCountryAndCurrencyForShoppingPopup;
import com.example.trainingselenium.Pages.CookiesPopup;
import com.example.trainingselenium.Pages.HomePage;
import com.example.trainingselenium.Utils.CustomListener;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import java.util.Locale;


@Slf4j
@Getter
public class SubscribeStepDefs {

    private WebDriver driver;
    private HomePage homePage;
    private ChooseCountryAndCurrencyForShoppingPopup chooseCountryAndCurrencyForShoppingPopup;
    private CookiesPopup cookiesPopup;

    /**
     * In package Config You will find
     * Te configuration of sauce lab in WevDriverConfiguration
     * and in PageObjectInitialisation you will find the intailston of the class represnte the page object models
     * Goals :
     */
    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        log.info("Setup Driver" + driver);
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        chooseCountryAndCurrencyForShoppingPopup = pageObjectInitialization.getChooseCountryAndCurrencyForShoppingPopup();
        cookiesPopup = pageObjectInitialization.getCookiesPopup();
    }

    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() {
        Locale locale = Locale.getDefault();
        String lang = locale.getDisplayLanguage();
        String country = locale.getDisplayCountry();
        log.info("Lang: {} Country: {}", lang, country);
        cookiesPopup.acceptAllCookies();
        homePage.changeDestination();
    }

    @And("the user select the Non EU country switcher {} and {}")
    public void theUserSelectTheNonEUCountrySwitcherCountry(String countryName, String currency) {
        chooseCountryAndCurrencyForShoppingPopup.clickCountryDropdown();
        chooseCountryAndCurrencyForShoppingPopup.enterCountryInput(countryName);
        chooseCountryAndCurrencyForShoppingPopup.selectCountry(countryName);
        chooseCountryAndCurrencyForShoppingPopup.clickCurrencyDropdown();
        chooseCountryAndCurrencyForShoppingPopup.selectCurrency(currency);
        chooseCountryAndCurrencyForShoppingPopup.clickStartShoppingButton();
    }

    @And("the user has accessed the sign-up bloc")
    public void theUserHasAccessedTheSignUpBloc() {
        log.info("the user has accessed the sign-up bloc");
        homePage.scrollToSubscriptionSection();
    }

    @When("the user inserts a valid email {} and attempts to subscribe")
    public void theUserInsertsAValidEmailAndAttemptsToSubscribe(String email) {
        log.info("the user inserts a valid email and attempts to subscribe");
        homePage.enterSubscriptionEmail(email);
    }

    @And("the user selects the country where they live {}")
    public void theUserSelectsTheCountryWhereTheyLiveCountry(String countryName) {
        log.info("the user selects the country where they live {}", countryName);
        homePage.selectCountry(countryName);
    }

    @And("the user selects the most exciting topic from the world of Fortnums {}")
    public void theUserSelectsTheMostExcitingTopicFromTheWorldOfFortnumsFortnumTopic(String topicName) {
        log.info("the user selects the most exciting topic from the world of Fortnums {}", topicName);
        homePage.selectGeneralInterest(topicName);
    }

    @And("the user selects the Fortnums product {} they would take to a desert island")
    public void theUserSelectsTheFortnumsProductProductTheyWouldTakeToADesertIsland(String productName) {
        log.info("the user selects the Fortnums product {} they would take to a desert island", productName);

        homePage.selectProductInterest(productName);
    }

    @And("the user attemps to subscribe")
    public void theUserAttempsToSubscribe() {
        homePage.subscribeButton();
    }


    @Then("the user is successfully subscribed")
    public void theUserIsSuccessfullySubscribed() {
        log.info("I am in last method : theUserIsSuccessfullySubscribed");
        String message = homePage.messageOfSuccessSubscribe();
        Assert.assertEquals(message, "Thank you for your subscription.");
    }

    /**
     * this methode will run after all methode finished ther runs
     * Gals : close the browser
     */
    @After
    public void tearDown() {
        WebDriverConfiguration.quitDriver();
    }
}