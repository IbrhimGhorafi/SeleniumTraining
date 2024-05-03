package com.example.trainingselenium.PagesTest;

import com.example.trainingselenium.Utils.CustomListener;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Listeners(CustomListener.class)
public class TestBase {
    public static RemoteWebDriver driver = null;

    @BeforeSuite
    public RemoteWebDriver initialize() throws Exception {
        ChromeOptions browserOptions = getChromeOptions();

        URL url = new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub");
        driver = new RemoteWebDriver(url, browserOptions);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://fr-fr.facebook.com/reg/");
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 10");
        browserOptions.setBrowserVersion("124");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-ibrahim.ghorafi-5876c");
        sauceOptions.put("accessKey", "a4b582b8-2a4b-4234-87f2-fe65fec55de0");
        sauceOptions.put("build", "your_build_id");
        sauceOptions.put("name", "facebook_login_registration_test");
        browserOptions.setCapability("sauce:options", sauceOptions);
        return browserOptions;
    }

    @AfterSuite
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}

