package com.zonakode.appium.screens;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class DetailInventoryScreen {
    private AndroidDriver driver;
    private By getProductImage = AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Image Container']//android.widget.ImageView");
    private By altProductImage = AppiumBy.xpath("//android.widget.ScrollView[@content-desc=\"test-Inventory item page\"]/android.view.ViewGroup");


    public DetailInventoryScreen(AndroidDriver driver, By getProductImage, By altProductImage) {
        this.driver = driver;
        this.getProductImage = getProductImage;
    }

    public DetailInventoryScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    public By getProductImage() {
        return getProductImage;
    }

    public By altProductImage() {
        return altProductImage;
    }

}
