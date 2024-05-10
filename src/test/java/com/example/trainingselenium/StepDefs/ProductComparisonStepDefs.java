package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class ProductComparisonStepDefs {

    private WebDriver driver;
    private PLP plp;
    private CartPage cartPage;
    private HomePage homePage;
    private static String titleOfProductInPLP;
    private static String titleOfProductInCart;
    private static String priceOfSingleProduct;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        plp = pageObjectInitialization.getPlp();
        cartPage = pageObjectInitialization.getCartPage();
        homePage = pageObjectInitialization.getHomePage();
    }


    @And("the user hovers over the first product on the PLP")
    public void theUserHoversOverTheFirstProductOnThePLP() {
        plp.scrollToProduct();
    }

    @And("the user retrieves the name of the product")
    public void theUserRetrievesTheNameOfTheProduct() {
        titleOfProductInPLP = plp.getTitleOfProduct();
        log.info("title of product {}", titleOfProductInPLP);
    }

    @And("the user clicks on the Add to Bag button")
    public void theUserClicksOnTheButton() {
        plp.clickOnAddToBag();
    }

    @Then("the user gets the title of the product from the cart")
    public void theUserGetsTheTitleOfTheProductFromTheCart() {
        homePage.clickOnBagIcon();
        titleOfProductInCart = cartPage.getTitleOfProduct();
        log.info("title product from cart {}", titleOfProductInCart);

    }

    @And("the user adds the quantity {} of the product from the cart")
    public void theUserAddsTheQuantityOfTheProductFromTheCart(String quantity) {
        cartPage.addQuantity(quantity);
    }

    @And("the user gets the price of a single product")
    public void theUserGetsThePriceOfASingleProduct() {
        priceOfSingleProduct = cartPage.getPrice();
        log.info("the price of single product {}", priceOfSingleProduct);
    }

    @Then("the user moves the element to the wish list")
    public void theUserMovesTheElementToTheWishList() {
        cartPage.clickOnAddWishList();
        log.info("doneeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
    }

    @And("the user retrieves the quantity of the product from the wish list")
    public void theUserRetrievesTheQuantityOfTheProductFromTheWishList() {
        homePage.clickOnWishListIcon();
    }

}
