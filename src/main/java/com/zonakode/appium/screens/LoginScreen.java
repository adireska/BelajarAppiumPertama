package com.zonakode.appium.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver; // Corrected import
import org.openqa.selenium.WebElement; // Needed for interacting with elements
import org.openqa.selenium.support.ui.ExpectedConditions; // For explicit waits
import org.openqa.selenium.support.ui.WebDriverWait; // For explicit waits
import org.openqa.selenium.By; // Import for By class

import java.time.Duration; // For Duration in WebDriverWait

public class LoginScreen {
    // Locators remain the same, but using 'By' is more standard and adding 'Locator' suffix for clarity
    private By usernameLocator = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Username\"]");
    private By passwordLocator = AppiumBy.xpath("//android.widget.EditText[@content-desc=\"test-Password\"]");
    private By loginButtonLocator = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]");
    private By errorMessageLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Username and password do not match any user in this service.\"]");
    private By ErrorMessageEmail = AppiumBy.xpath("//android.widget.TextView[@text=\"Username is required\"]");
    private By ErrorMessagePassword = AppiumBy.xpath("//android.widget.TextView[@text=\"Password is required\"]");
    private By ErrorMessageLokedUser = AppiumBy.xpath("//android.widget.TextView[@text=\"Sorry, this user has been locked out.\"]");


    private WebDriverWait wait; 

    public LoginScreen(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
    }

    public void enterUsername(String username) {
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        usernameField.sendKeys(username);
    }

   
    public void enterPassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButtonLocator));
        loginBtn.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // public void login() {
    //     // Default login method with hardcoded credentials
    //     enterUsername("standard_user");
    //     enterPassword("secret_sauce");
    // }

    public String getErrorMessage() {
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return errorMessage.getText();
    }

    public String getErrorMessageEmail() {
        WebElement errorMessageEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageEmail));
        return errorMessageEmail.getText();
    }

    public String getErrorMessagePassword() {
        WebElement errorMessagePassword = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessagePassword));
        return errorMessagePassword.getText();
    }

    public String getErrorMessageLokedUser() {
        WebElement errorMessageLokedUser = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorMessageLokedUser));
        return errorMessageLokedUser.getText();
    }

}
