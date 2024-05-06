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

public class ResetPasswordPage {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;
    @FindBy(how = How.XPATH, using = Locators.NEW_PASSWORD_INPUT)
    private WebElement newPasswordInput;

    @FindBy(how = How.XPATH, using = Locators.REPEAT_PASSWORD_INPUT)
    private WebElement repeatPasswordInput;

    @FindBy(how = How.XPATH, using = Locators.SAVE_NEW_PASSWORD_BUTTON)
    private WebElement saveNewPasswordButton;

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void enterNewPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(newPasswordInput)).click();
        actions.sendKeys(newPasswordInput, password).build().perform();
    }

    public void enterRepeatPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(repeatPasswordInput)).click();
        actions.sendKeys(repeatPasswordInput, password).build().perform();
    }

    public void clickSaveNewPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(saveNewPasswordButton)).click();
    }
}
