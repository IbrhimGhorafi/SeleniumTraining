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

public class LoginPopup {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.FORGET_PASSWORD_LINK)
    private WebElement forgotPasswordLink;

    @FindBy(how = How.XPATH,using = Locators.EMAIL_RESET_PASSWORD_INPUT)
    private WebElement emailResetPasswordInput;

    @FindBy(how = How.XPATH,using = Locators.RESET_PASSWORD_BUTTON)
    private WebElement resetPasswordButton;

    @FindBy(how = How.XPATH,using = Locators.EMAIL_LOGIN_INPUT)
    private WebElement emailLoginInput;

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickOnForgetPasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        actions.moveToElement(forgotPasswordLink).click().perform();
    }
    public void enterEmailForResetPasswordInput(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailResetPasswordInput));
        actions.moveToElement(emailResetPasswordInput).click().perform();
//        actions.sendKeys(email).perform();
        actions.sendKeys(emailResetPasswordInput,email).build().perform();
    }
    public void clickOnResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton));
        actions.moveToElement(resetPasswordButton).click().perform();
    }


}
