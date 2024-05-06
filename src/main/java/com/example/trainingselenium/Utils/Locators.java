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
    public static final String ICON_PERSON_IN_HEADER = "//img[contains(@id,'account-link')]";
    public static final String FORGET_PASSWORD_LINK = "//form//span[contains(text(),'Forgotten the password?')]";
    public static final String EMAIL_RESET_PASSWORD_INPUT = "//div[contains(@class,'forgot-password-wrapper')]//input[contains(@name,'email')]";
    public static final String RESET_PASSWORD_BUTTON = "//div[contains(@class,'forgot-password-wrapper')]//button[contains(@aria-label,'Reset Password')]";
    public static final String EMAIL_YOP_MAIL_INPUT = "//div[contains(@class,'forgot-password-wrapper')]//button[contains(@aria-label,'Reset Password')]";
    public static final String LOGIN_TO_YOP_MAIL_BUTTON = "//button[contains(@title,'Vérifier les mails @yopmail.com')]";
    public static final String NAME_IFRAME_MESSAGE_CONTENT = "ifmail";
    public static final String LINK_BUTTON_RESET_PASSWORD = "//div[@id='mail']//a[text()='Set a New Password']";
    public static final String NEW_PASSWORD_INPUT = "//input[@name='password']";
    public static final String REPEAT_PASSWORD_INPUT = "//input[@name='repeatPassword']";
    public static final String SAVE_NEW_PASSWORD_BUTTON = "//button[@aria-label='Save New password']";
    public static final String EMAIL_LOGIN_INPUT = "//div[contains(@class,'login-form')]//input[contains(@name,'email')]";
}
