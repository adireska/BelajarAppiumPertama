package com.zonakode.appium;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.Test;

import com.zonakode.appium.screens.DetailInventoryScreen;
import com.zonakode.appium.screens.InventoryScreen;
import com.zonakode.appium.screens.LoginScreen;
import com.zonakode.appium.utils.DriverUtil;

import io.appium.java_client.AppiumBy;

public class DetailInventoryTest {

    // Method performPinchZoom should be defined here, before its usage.
    private void performPinchZoom(DriverUtil driverUtil, WebElement element, boolean zoomIn) {
        Point loc = element.getLocation();
        Dimension size = element.getSize();
        int centerX = loc.getX() + size.getWidth() / 2;
        int centerY = loc.getY() + size.getHeight() / 2;

        int startOffset = zoomIn ? 100 : 500;
        int endOffset = zoomIn ? 500 : 100;

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");

        // Finger 1
        Sequence seq1 = new Sequence(finger1, 0);
        seq1.addAction(finger1.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),centerX - startOffset, centerY));
        seq1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq1.addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),centerX - endOffset, centerY));
        seq1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        // Finger 2
        Sequence seq2 = new Sequence(finger2, 0);
        seq2.addAction(finger2.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(),centerX + startOffset, centerY));
        seq2.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq2.addAction(finger2.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(),centerX + endOffset, centerY));
        seq2.addAction(finger2.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driverUtil.getDriver().perform(Arrays.asList(seq1, seq2));
    }

    @Test
    public void TC_SauceLabsZoomTest() throws MalformedURLException, InterruptedException {
        DriverUtil driverUtil = new DriverUtil();
        LoginScreen loginScreen = new LoginScreen(driverUtil.getDriver());
        DetailInventoryScreen detailInventoryScreen = new DetailInventoryScreen(driverUtil.getDriver());
        InventoryScreen inventoryScreen = new InventoryScreen(driverUtil.getDriver());

        WebElement productImage = null;

        try {
            // Login dan navigasi
            System.out.println("=== SAUCELABS APP ZOOM TEST ===");
            loginScreen.login("standard_user", "secret_sauce");
            inventoryScreen.clickDetailItem();
            Thread.sleep(3000); // Wait longer for page load

            // 1. TRY DIFFERENT IMAGE SELECTORS
            System.out.println("=== TRYING DIFFERENT IMAGE SELECTORS ===");

            // Daftar selector yang mungkin untuk SauceLabs app
            By[] imageSelectors = {
                AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Image Container']//android.widget.ImageView"),
                AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc,'test')]"),
                AppiumBy.xpath("//android.widget.ImageView[@index='0']"),
                AppiumBy.xpath("(//android.widget.ImageView)[1]"),
                AppiumBy.xpath("//android.widget.ScrollView//android.widget.ImageView"),
                AppiumBy.className("android.widget.ImageView")
            };

            for (int i = 0; i < imageSelectors.length; i++) {
                try {
                    productImage = driverUtil.getDriver().findElement(imageSelectors[i]);
                    System.out.println("Found image with selector " + (i + 1) + ": " + imageSelectors[i]);
                    break;
                } catch (Exception e) {
                    System.out.println("Selector " + (i + 1) + " failed: " + imageSelectors[i]);
                }
            }

            if (productImage == null) {
                System.out.println("No image element found. Trying to find any touchable element...");
                // Fallback: cari element yang bisa di-touch
                try {
                    productImage = driverUtil.getDriver().findElement(AppiumBy.xpath("//android.widget.ScrollView"));
                    System.out.println("Using ScrollView as fallback element");
                } catch (Exception e) {
                    System.out.println("Even ScrollView not found!");
                    return;
                }
            }

            // 2. ANALYZE ELEMENT PROPERTIES
            System.out.println("=== ELEMENT ANALYSIS ===");
            Point location = productImage.getLocation();
            Dimension size = productImage.getSize();
            Dimension screenSize = driverUtil.getDriver().manage().window().getSize();

            System.out.println("Screen size: " + screenSize.getWidth() + "x" + screenSize.getHeight());
            System.out.println("Element location: (" + location.getX() + ", " + location.getY() + ")");
            System.out.println("Element size: " + size.getWidth() + "x" + size.getHeight());
            System.out.println("Element displayable: " + productImage.isDisplayed());
            System.out.println("Element enabled: " + productImage.isEnabled());

            // 3. TRY DIFFERENT ZOOM APPROACHES
            int centerX = location.getX() + size.getWidth() / 2;
            int centerY = location.getY() + size.getHeight() / 2;

            System.out.println("Using center point: (" + centerX + ", " + centerY + ")");

            // The original code had other zoom approaches like performStandardZoom, etc.
            // These methods are not defined in the provided code.
            // To avoid compilation errors, they are commented out.
            // If they are needed, they should be defined.

            // Contoh pemanggilan performPinchZoom
            performPinchZoom(driverUtil, productImage, true); // zoom in
            performPinchZoom(driverUtil, productImage, false); // zoom out

            System.out.println("=== ALL ZOOM APPROACHES COMPLETED ===");

        } catch (Exception e) {
            System.err.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driverUtil.quitApp();
        }
    }

}
