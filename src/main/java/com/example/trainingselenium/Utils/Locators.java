package com.example.trainingselenium.Utils;

public class Locators {
    public static final String ACCEPT_ALL_COOKIES = "button[data-testid='uc-accept-all-button']";
    public static final String REFUSE_ALL_COOKIES = "button[data-testid='uc-deny-all-button']";
    public static final String COUNTRY_DROPDOWN = "//span[contains(@class,'country-container ')]//span[contains(@class,'p-dropdown-trigger-icon')]";
    public static final String COUNTRY_INPUT = "//input[contains(@class,'p-inputtext p-component')]";
    public static final String CURRENCY_DROPDOWN = "//div[contains(@class,'currency-container')]//span[contains(@class,'p-dropdown-trigger-icon')]";
    public static final String START_SHOPPING_BUTTON = "//button[text()='Start Shopping']";
    public static final String COUNTRY_DROPDOWN_ITEM = "//li[contains(@class,'p-dropdown-item')][text()='%s']";
    public static final String CURRENCY_ITEM = "//div[contains(@class,'currency-switcher-panel')]//li[contains(@aria-label,'%s')]";
    public static final String SUBSCRIPTION_EMAIL_INPUT = "//input[contains(@id,'subscription-email')]";
    public static final String SELECT_COUNTRY = "//select[contains(@name,'country')]";
    public static final String SELECT_GENERAL_INTEREST = "//select[contains(@name,'general_interest')]";
    public static final String SELECT_PRODUCT_INTEREST = "//select[contains(@name,'product_interest')]";
    public static final String SUBSCRIBE_BUTTON = "//button[contains(@aria-label,'Sign Up')]";
    public static final String COUNTRY_OPTION_XPATH = SELECT_COUNTRY + "//option[text()='%s']";
    public static final String GENERAL_INTEREST_OPTION_XPATH = SELECT_GENERAL_INTEREST + "//option[text()='%s']";
    public static final String PRODUCT_INTEREST_OPTION_XPATH = SELECT_PRODUCT_INTEREST + "//option[text()='%s']";
    public static final String SELECT_COUNTRY_CURRENCY_SHOPPING = "//header//span[contains(text(),'Change')]";
    public static final String POPUP_MESSAGE_SUCCESS_OF_SUBSCRIBE = "//div[text()='Thank you for your subscription.']";
    public static final String ICON_PERSON_IN_HEADER = "//header//img[contains(@id,'account-link')]";

}
