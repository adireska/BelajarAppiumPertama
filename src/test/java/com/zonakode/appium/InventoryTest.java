package com.zonakode.appium;


import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zonakode.appium.components.HeaderComponent;
import com.zonakode.appium.screens.InventoryScreen;
import com.zonakode.appium.screens.LoginScreen;
import com.zonakode.appium.utils.DragPositionUtil;
import com.zonakode.appium.utils.DriverUtil;

public class InventoryTest {

    @Test(enabled = false)
    public void TC007() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());

        loginScreen.login("standard_user", "secret_sauce");

        int actual = inventoryScreen.getTotalProductDisplayed();
        inventoryScreen.scrollDown(3);
        actual += inventoryScreen.getTotalProductDisplayed();

        int expected = 8;

        Assert.assertEquals(actual, expected);  
        

        System.out.println(actual);
        driverUtil.quitApp();
    }

    @Test()
    public void TC0008() throws MalformedURLException {
        DriverUtil driverUtil = new DriverUtil();
        HeaderComponent headerComponent = new HeaderComponent(driverUtil.getDriver());
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());

    InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver(), headerComponent);
        // Pre condition (sebelum melakukan test)
        loginScreen.login("standard_user", "secret_sauce");

        inventoryScreen.drag(new DragPositionUtil(200, 100));

        String expected = "1";
        String actual = inventoryScreen.getTotalCart();
        Assert.assertEquals(actual, expected);

        driverUtil.quitApp();
    }

}
