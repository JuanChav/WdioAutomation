package com.globant.utils.screens;

import com.globant.Screens.HomeScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseScreen {
    protected AndroidDriver driver;
    protected WebDriverWait wait;

    public void waitElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitToBeClickable(WebElement element) {
        this.wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isElementDisplayed(WebElement element) {
        waitElementVisibility(element);
        return element.isDisplayed();
    }

    public BaseScreen(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
