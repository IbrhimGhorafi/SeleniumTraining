package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class CartPage {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.PRODUCT_PRICE_CART)
    private WebElement productPrice;

    @FindBy(how = How.XPATH, using = Locators.PRODUCT_NAME_CART)
    private WebElement productName;

    @FindBy(how = How.XPATH, using = Locators.PRODUCT_QUANTITY_INPUT_CART)
    private WebElement productQuantity;

    @FindBy(how = How.XPATH, using = Locators.PRODUCT_TOTAL_CART)
    private WebElement productTotal;

    @FindBy(how = How.XPATH,using = Locators.ADD_WISHLIST_CART)
    private WebElement addWshListButton;


    public CartPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public String getTitleOfProduct() {
        return productName.getText();
    }
    public String getPrice(){
        return productPrice.getText();
    }

    public void addQuantity(String quantityValue){
        wait.until(ExpectedConditions.elementToBeClickable(productQuantity));
        actions.moveToElement(productQuantity).click().perform();
        productQuantity.clear();
        actions.sendKeys(productQuantity,quantityValue).build().perform();
    }

    public String getTotalPrice(){
        return productTotal.getText();
    }

    public void clickOnAddWishList(){
        wait.until(ExpectedConditions.elementToBeClickable(addWshListButton));
        actions.moveToElement(addWshListButton).click().perform();
    }
}
