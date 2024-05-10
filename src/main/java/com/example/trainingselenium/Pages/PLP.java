package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@Slf4j
public class PLP {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.ADD_TO_BAG_BUTTON)
    private WebElement addToBagButton;

    @FindBy(how = How.XPATH, using = Locators.LINK_PRODUCT_PDP)
    private WebElement linkOfProductToPDP;

    @FindBy(how = How.XPATH, using = "//div[@data-sku='2002657']")
    private WebElement product;


    public PLP(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickOnAddToBag() {
        wait.until(ExpectedConditions.elementToBeClickable(addToBagButton));
        actions.click(addToBagButton).perform();
    }


    public String getTitleOfProduct() {
        return linkOfProductToPDP.getText();
    }

    public void scrollToProduct() {
        wait.until(ExpectedConditions.visibilityOf(product));
        actions.moveToElement(product).perform();
    }
}
