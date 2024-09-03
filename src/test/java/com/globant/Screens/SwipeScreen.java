package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class SwipeScreen extends BaseScreen {
    private static final String MAIN_TEXT_SWIPE_TXT = "UiSelector().text(\"Swipe horizontal\")";
    private static final String DRAG_BTN = "UiSelector().description(\"Drag\")";
    private static final String CAROUSEL_SWIPE = "Swipe";
    private static final String CAROUSEL_ITEM_0 = "UiSelector().resourceId(\"__CAROUSEL_ITEM_0_READY__\")";
    private static final String CAROUSEL_ITEM_1 = "UiSelector().resourceId(\"__CAROUSEL_ITEM_1_READY__\")";
    private static final String CAROUSEL_ITEM_2 = "UiSelector().resourceId(\"__CAROUSEL_ITEM_2_READY__\")";
    private static final String CAROUSEL_ITEM_3 = "UiSelector().resourceId(\"__CAROUSEL_ITEM_3_READY__\")";
    private static final String CAROUSEL_ITEM_4 = "UiSelector().resourceId(\"__CAROUSEL_ITEM_4_READY__\")";
    private static final String CAROUSEL_ITEM_5 = "UiSelector().resourceId(\"__CAROUSEL_ITEM_5_READY__\")";
    private static final String FOUND_ME_TXT = "UiSelector().text(\"You found me!!!\")";
    private static final String FOUND_ME_TXT_TEST = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"You found me!!!\"));";

    @AndroidFindBy(uiAutomator = MAIN_TEXT_SWIPE_TXT)
    private WebElement mainTextSwipeTxt;
    @AndroidFindBy(uiAutomator = DRAG_BTN)
    private WebElement dragBtn;
    @AndroidFindBy(uiAutomator = CAROUSEL_SWIPE)
    private WebElement carouselSwipe;
    @AndroidFindBy(uiAutomator = CAROUSEL_ITEM_0)
    private WebElement carouselItem0;
    @AndroidFindBy(uiAutomator = CAROUSEL_ITEM_1)
    private WebElement carouselItem1;
    @AndroidFindBy(uiAutomator = CAROUSEL_ITEM_2)
    private WebElement carouselItem2;
    @AndroidFindBy(uiAutomator = CAROUSEL_ITEM_3)
    private WebElement carouselItem3;
    @AndroidFindBy(uiAutomator = CAROUSEL_ITEM_4)
    private WebElement carouselItem4;
    @AndroidFindBy(uiAutomator = CAROUSEL_ITEM_5)
    private WebElement carouselItem5;
    @AndroidFindBy(uiAutomator = FOUND_ME_TXT)
    private WebElement foundMeTxt;

    public enum ScrollDirection {
        DOWN, RIGHT
    }

    public boolean isMainTextSwipeTxtDisplayed() {
        return isElementDisplayed(mainTextSwipeTxt);
    }

    public DragScreen tapDragBtn() {
        dragBtn.click();
        return new DragScreen(driver);
    }

    public void performFirstElementSwipeGesture() {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) carouselItem0).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    public void performAllElementsSwipeGesture() {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) carouselItem1).getId(),
                "direction", "left",
                "percent", 0.75
        ));
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) carouselItem2).getId(),
                "direction", "left",
                "percent", 0.75
        ));((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) carouselItem3).getId(),
                "direction", "left",
                "percent", 0.75
        ));((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) carouselItem4).getId(),
                "direction", "left",
                "percent", 0.75
        ));
    }

    public boolean isCarouselItem0Displayed() {
        try {
            return carouselItem0.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isCarouselItem5Displayed() {
        try {
            return carouselItem0.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void scrollDownToBottom() {
        Dimension size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
    }

    public String getFoundMeTxtTest() {
        return driver.findElement(AppiumBy.androidUIAutomator(FOUND_ME_TXT_TEST)).getText();
    }


    public String getFoundMeTxt() {
        waitElementVisibility(foundMeTxt);
        return foundMeTxt.getText();
    }

    public SwipeScreen(AndroidDriver driver) {
        super(driver);
    }
}