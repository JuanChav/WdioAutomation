package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginScreen extends BaseScreen {
    private static final String MAIN_TEXT_LOGIN_TXT = "UiSelector().text(\"Login / Sign up Form\")";
    private static final String FORMS_BTN = "UiSelector().description(\"Forms\")";

    @AndroidFindBy(uiAutomator = MAIN_TEXT_LOGIN_TXT)
    private WebElement mainTextLoginTxt;
    @AndroidFindBy(uiAutomator = FORMS_BTN)
    private WebElement formsBtn;

    public boolean isMainTextLoginTxtDisplayed() {
        return isElementDisplayed(mainTextLoginTxt);
    }

    public FormsScreen tapFormsBtn() {
        formsBtn.click();
        return new FormsScreen(driver);
    }

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
}
