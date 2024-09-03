package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WebviewScreen extends BaseScreen {
    private static final String MAIN_IMAGE_WEBVIEW = "UiSelector().text(\"WebdriverIO\")";
    private static final String LOGIN_BTN = "UiSelector().description(\"Login\")";

    @AndroidFindBy(uiAutomator = MAIN_IMAGE_WEBVIEW)
    private WebElement mainImageWebview;
    @AndroidFindBy(uiAutomator = LOGIN_BTN)
    private WebElement loginBtn;

    public String isMainImageWebviewEnabled() {
        waitElementVisibility(mainImageWebview);
        return mainImageWebview.getAttribute("enabled");
    }

    public LoginScreen tapLoginBtn() {
        loginBtn.click();
        return new LoginScreen(driver);
    }

    public WebviewScreen(AndroidDriver driver) {
        super(driver);
    }
}
