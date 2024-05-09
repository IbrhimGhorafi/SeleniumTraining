package com.example.trainingselenium.Config;

import com.example.trainingselenium.Pages.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * The goal of this class
 * Initialise all Pages
 */
@Slf4j
@Getter
public class PageObjectInitialization {
    private final WebDriver driver;
    private final HomePage homePage;
    private final ChooseCountryAndCurrencyForShoppingPopup chooseCountryAndCurrencyForShoppingPopup;
    private final CookiesPopup cookiesPopup;
    private final LoginPopup loginPopup;
    private final YopMailWebSite yopMailWebSite;
    private final ResetPasswordPage resetPasswordPage;

    public PageObjectInitialization(WebDriver driver) {
        this.driver = driver;
        this.homePage = PageFactory.initElements(driver, HomePage.class);
        log.info("Initializing PageObjectInitialization");

        this.chooseCountryAndCurrencyForShoppingPopup = PageFactory
                .initElements(driver, ChooseCountryAndCurrencyForShoppingPopup.class);
        this.cookiesPopup = PageFactory.initElements(driver, CookiesPopup.class);
        this.loginPopup = PageFactory.initElements(driver, LoginPopup.class);
        this.yopMailWebSite = PageFactory.initElements(driver, YopMailWebSite.class);
        this.resetPasswordPage = PageFactory.initElements(driver, ResetPasswordPage.class);
    }

}
