package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeScreen extends BaseScreen {
    private static final String DEMO_APP_FOR_APPIUM_TXT = "UiSelector().textContains(\"Demo app for the appium-boilerplate\")";
    private static final String WEBVIEW_BTN = "UiSelector().description(\"Webview\")";
    private static final String LOGIN_BTN = "UiSelector().description(\"Login\")";

    @AndroidFindBy(uiAutomator = DEMO_APP_FOR_APPIUM_TXT)
    private WebElement demoAppForAppiumTxt;
    @AndroidFindBy(uiAutomator = WEBVIEW_BTN)
    private WebElement webviewBtn;
    @AndroidFindBy(uiAutomator = LOGIN_BTN)
    private WebElement loginBtn;

    public boolean isDemoAppForAppiumTxtDisplayed() {
        return demoAppForAppiumTxt.isDisplayed();
    }

    public WebviewScreen tapWebviewBtn() {
        webviewBtn.click();
        return new WebviewScreen(driver);
    }

    public LoginScreen tapLoginBtn() {
        loginBtn.click();
        return new LoginScreen(driver);
    }

    public HomeScreen(AndroidDriver driver) {
        super(driver);
    }
}
