package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DragScreen extends BaseScreen {
    private static final String MAIN_TEXT_DRAG_TXT = "//android.widget.TextView[@text=\"Drag and Drop\"]\n";

    @AndroidFindBy(xpath = MAIN_TEXT_DRAG_TXT)
    private WebElement mainTextDragTxt;

    public boolean isMainTextDragTxtDisplayed() {
        return isElementDisplayed(mainTextDragTxt);
    }

    public DragScreen(AndroidDriver driver) {
        super(driver);
    }
}
