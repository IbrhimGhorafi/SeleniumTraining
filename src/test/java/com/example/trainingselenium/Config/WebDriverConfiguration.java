package com.example.trainingselenium.Config;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * the goals of this class
 * configure the connection with sauce lab
 */
@Slf4j
public class WebDriverConfiguration {
    private WebDriver driver;

    public void setup() throws Exception {
        log.info("Setting up WebDriver");
        ChromeOptions browserOptions = getChromeOptions();

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
        return driver;
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("124");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-ibrahim.ghorafi-5876c");
        sauceOptions.put("accessKey", "a4b582b8-2a4b-4234-87f2-fe65fec55de0");
        sauceOptions.put("build", "your_build_id");
        sauceOptions.put("name", "fortnums_scenario_test");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }
}
