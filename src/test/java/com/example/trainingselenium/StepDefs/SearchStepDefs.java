package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@Slf4j
public class SearchStepDefs {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        log.info("Setup Driver" + driver);
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
    }

    @And("the user click on search button")
    public void theUserClickOnSearchButton() {
        homePage.clickOnIconSearch();
    }

    @When("the user fill the search field by {}")
    public void theUserFillTheSearchFieldByCategory(String category) {
        homePage.enterSearchInput(category);
        homePage.clickOnSearchButton();
    }

    @Then("the value searched should be the same as the value entered {}")
    public void theValueSearchedShouldBeTheSameAsTheValueEnteredCategory(String category) {
        String searchResultText = homePage.getSearchResultText();
        Assert.assertEquals(searchResultText,category);
    }
}
