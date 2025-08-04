package com.zonakode.appium;

import java.net.MalformedURLException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zonakode.appium.screens.InventoryScreen;
import com.zonakode.appium.screens.LoginScreen;
import com.zonakode.appium.utils.DriverUtil;

import io.appium.java_client.android.AndroidDriver;

public class LoginTest {
    AndroidDriver driver;
    DesiredCapabilities capabilities;


    @Test
    public void TC001() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        this.driver = driverUtil.getDriver(); 

        LoginScreen loginScreen = new LoginScreen(this.driver); 
        InventoryScreen inventoryScreen = new InventoryScreen(this.driver); 

        loginScreen.login("standard_user", "secret_sauce");

        String actual = inventoryScreen.getHeaderText();
        String expected = "PRODUCTS";

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test
    public void TC002() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();

        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        loginScreen.login("standard_user123", "secret_sauce");

        String actual = loginScreen.getErrorMessage();
        String expected = "Username and password do not match any user in this service.";

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test
    public void TC003() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();

        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        loginScreen.login("standard_user", "secret_sauce123");

        String actual = loginScreen.getErrorMessage();
        String expected = "Username and password do not match any user in this service.";

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test
    public void TC004() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();

        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        loginScreen.login("", "secret_sauce");

        String actual = loginScreen.getErrorMessageEmail();
        String expected = "Username is required";

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test
    public void TC005() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();

        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        loginScreen.login("standard_user", "");

        String actual = loginScreen.getErrorMessagePassword();
        String expected = "Password is required";

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

    @Test
    public void TC006() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();

        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

        loginScreen.login("locked_out_user", "secret_sauce");   
        
        String actual = loginScreen.getErrorMessageLokedUser();
        String expected = "Sorry, this user has been locked out.";  

        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

}
