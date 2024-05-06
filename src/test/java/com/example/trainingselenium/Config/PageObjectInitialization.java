package com.example.trainingselenium.Config;

import com.example.trainingselenium.Pages.*;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * The goal of this class
 * Initialise all Pages
 */
@Slf4j
public class PageObjectInitialization {
    private WebDriver driver;
    private HomePage homePage;
    private ChooseCountryAndCurrencyForShoppingPopup chooseCountryAndCurrencyForShoppingPopup;
    private CookiesPopup cookiesPopup;
    private LoginPopup loginPopup;
    private YopMailWebSite yopMailWebSite;
    private ResetPasswordPage resetPasswordPage;

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

    public HomePage getHomePage() {
        return homePage;
    }

    public ChooseCountryAndCurrencyForShoppingPopup getChooseCountryAndCurrencyForShoppingPopup() {
        return chooseCountryAndCurrencyForShoppingPopup;
    }

    public CookiesPopup getCookiesPopup() {
        return cookiesPopup;
    }

    public LoginPopup getLoginPopup() {
        return loginPopup;
    }

    public YopMailWebSite getYopMailWebSite() {
        return yopMailWebSite;
    }

    public ResetPasswordPage getResetPasswordPage() {
        return resetPasswordPage;
    }
}
