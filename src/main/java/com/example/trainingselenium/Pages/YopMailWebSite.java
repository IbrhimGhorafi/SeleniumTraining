package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
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
public class YopMailWebSite {

    private static WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_YOP_MAIL_INPUT)
    private WebElement emailInput;

    @FindBy(how = How.XPATH, using = Locators.LOGIN_TO_YOP_MAIL_BUTTON)
    private WebElement loginYopMailButton;


    private String nameOfIframeContentMessage = Locators.NAME_IFRAME_MESSAGE_CONTENT;

    public YopMailWebSite(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void navigateToYopMailWebSite() {
        driver.navigate().to("https://yopmail.com/fr/");
    }

    public void enterEmail(String email) {
        log.info("Entering email address: " + email);
        wait.until(ExpectedConditions.elementToBeClickable(emailInput));
        actions.moveToElement(emailInput).click().perform();
        actions.sendKeys(emailInput, email).build().perform();
    }

    public void clickLoginYopMailButton() {
        WebElement yopMailButton = wait.until(ExpectedConditions.elementToBeClickable(loginYopMailButton));
        yopMailButton.click();
    }

    private WebDriver switchToIframe() {
        return driver.switchTo().frame(nameOfIframeContentMessage);
    }

    public String recuperateTheHrefOfResetPasswordPage() {
        WebDriver iframeMessage = switchToIframe();
        String href = iframeMessage.findElement(By.xpath(Locators.LINK_BUTTON_RESET_PASSWORD)).getAttribute("href");
        log.info("Link reset password link is {}", href);
        return href;
    }

    public void navigateToResetPasswordPage() {
        String linkOfResetPasswordPage = recuperateTheHrefOfResetPasswordPage();
        driver.get(linkOfResetPasswordPage);
    }
}
