package com.example.trainingselenium.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * the goals of this class
 * configure the connection with sauce lab
 */
@Slf4j
public class WebDriverConfiguration {

    private static WebDriver driver;

    private WebDriverConfiguration() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            log.warn("===============================================================");
            log.info("Getting driver");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www-preprod3.fortnums.net/");

        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
