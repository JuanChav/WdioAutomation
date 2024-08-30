package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {
    private static final String MAIN_TEXT_WEBVIEW_TXT = "UiSelector().text(\"Next-gen browser and mobile automation test framework for Node.js\")";
    private static final String LOGIN_BTN = "UiSelector().description(\"Login\")";

    @AndroidFindBy(uiAutomator = MAIN_TEXT_WEBVIEW_TXT)
    private WebElement mainTextWebviewTxt;
    @AndroidFindBy(uiAutomator = LOGIN_BTN)
    private WebElement loginBtn;

    public boolean isMainTextWebviewTxtDisplayed() {
        return isElementDisplayed(mainTextWebviewTxt);
    }

    public LoginScreen tapLoginBtn() {
        loginBtn.click();
        return new LoginScreen(driver);
    }

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }
}
