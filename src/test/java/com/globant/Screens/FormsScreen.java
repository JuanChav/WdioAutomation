package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import com.sun.org.apache.bcel.internal.generic.SWAP;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class FormsScreen extends BaseScreen {
    private static final String MAIN_TEXT_FORMS_TXT = "UiSelector().text(\"Form components\")";
    private static final String SWIPE_BTN = "UiSelector().description(\"Swipe\")";

    @AndroidFindBy(uiAutomator = MAIN_TEXT_FORMS_TXT)
    private WebElement mainTextFormsTxt;
    @AndroidFindBy(uiAutomator = SWIPE_BTN)
    private WebElement swipeBtn;

    public boolean isMainTextFormsTxtDisplayed() {
        return isElementDisplayed(mainTextFormsTxt);
    }

    public SwipeScreen tapSwipeBtn() {
        swipeBtn.click();
        return new SwipeScreen(driver);
    }

    public FormsScreen(AndroidDriver driver) {
        super(driver);
    }
}
