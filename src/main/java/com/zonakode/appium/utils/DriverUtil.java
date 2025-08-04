package com.zonakode.appium.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverUtil {
    private AndroidDriver driver;
    private DesiredCapabilities capabilities;

    public DriverUtil() throws MalformedURLException {
         capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:deviceName", "22021211RG");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), capabilities);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.hideKeyboard();
    }

    public AndroidDriver getDriver() {
        return driver;
    }


    public void quitApp() {
        if (driver != null) {
            driver.quit();
        }
    }

}
