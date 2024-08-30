package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SwipeScreen extends BaseScreen {
    private static final String MAIN_TEXT_SWIPE_TXT = "UiSelector().text(\"Swipe horizontal\")";
    private static final String DRAG_BTN = "UiSelector().description(\"Drag\")";

    @AndroidFindBy(uiAutomator = MAIN_TEXT_SWIPE_TXT)
    private WebElement mainTextSwipeTxt;
    @AndroidFindBy(uiAutomator = DRAG_BTN)
    private WebElement dragBtn;

    public boolean isMainTextSwipeTxtDisplayed() {
        return isElementDisplayed(mainTextSwipeTxt);
    }

    public DragScreen tapDragBtn() {
        dragBtn.click();
        return new DragScreen(driver);
    }

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
}
