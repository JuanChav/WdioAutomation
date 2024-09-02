package com.globant.Screens;

import com.globant.utils.screens.BaseScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class LoginScreen extends BaseScreen {
    private static final String MAIN_TEXT_LOGIN_TXT = "UiSelector().text(\"Login / Sign up Form\")";
    private static final String FORMS_BTN = "UiSelector().description(\"Forms\")";

    private static final String SING_UP_BTN = "UiSelector().description(\"button-sign-up-container\")";
    private static final String SING_UP_EMAIL_INPUT = "UiSelector().text(\"Email\")";
    private static final String SING_UP_PASSWORD_INPUT = "UiSelector().text(\"Password\")";
    private static final String SING_UP_CONFIRM_PASSWORD_INPUT = "UiSelector().text(\"Confirm password\")";
    private static final String SING_UP_SUBMIT_BTN = "UiSelector().description(\"button-SIGN UP\")";
    private static final String SING_UP_POPUP = "UiSelector().resourceId(\"android:id/message\")";

    private static final String LOGIN_BTN = "UiSelector().description(\"button-login-container\")";
    private static final String LOGIN_EMAIL_INPUT = "UiSelector().text(\"Email\")";
    private static final String LOGIN_PASSWORD_INPUT = "UiSelector().text(\"Password\")";
    private static final String LOGIN_SUBMIT_BTN = "UiSelector().description(\"button-LOGIN\")";
    private static final String LOGIN_POPUP = "UiSelector().resourceId(\"android:id/message\")";

    @AndroidFindBy(uiAutomator = MAIN_TEXT_LOGIN_TXT)
    private WebElement mainTextLoginTxt;
    @AndroidFindBy(uiAutomator = FORMS_BTN)
    private WebElement formsBtn;

    @AndroidFindBy(uiAutomator = SING_UP_BTN)
    private WebElement singUpBtn;
    @AndroidFindBy(uiAutomator = SING_UP_EMAIL_INPUT)
    private WebElement singUpEmailInput;
    @AndroidFindBy(uiAutomator = SING_UP_PASSWORD_INPUT)
    private WebElement signUpPasswordInput;
    @AndroidFindBy(uiAutomator = SING_UP_CONFIRM_PASSWORD_INPUT)
    private WebElement signUpConfirmPasswordInput;
    @AndroidFindBy(uiAutomator = SING_UP_SUBMIT_BTN)
    private WebElement singUpSubmitBtn;
    @AndroidFindBy(uiAutomator = SING_UP_POPUP)
    private WebElement singUpPopUp;

    @AndroidFindBy(uiAutomator = LOGIN_BTN)
    private WebElement loginBtn;
    @AndroidFindBy(uiAutomator = LOGIN_EMAIL_INPUT)
    private WebElement loginEmailInput;
    @AndroidFindBy(uiAutomator = LOGIN_PASSWORD_INPUT)
    private WebElement loginPasswordInput;
    @AndroidFindBy(uiAutomator = LOGIN_SUBMIT_BTN)
    private WebElement loginSubmitBtn;
    @AndroidFindBy(uiAutomator = LOGIN_POPUP)
    private WebElement loginPopUp;

    private String randomEmail = generateRandomEmail();
    private String randomPassword = generateRandomPassword();

    public boolean isMainTextLoginTxtDisplayed() {
        return isElementDisplayed(mainTextLoginTxt);
    }

    public FormsScreen tapFormsBtn() {
        formsBtn.click();
        return new FormsScreen(driver);
    }

    public void tapSignUpBtn() {
        waitToBeClickable(singUpBtn);
        singUpBtn.click();
    }

    public void inputRandomSingUpEmail() {
        waitElementVisibility(singUpEmailInput);
        singUpEmailInput.sendKeys(randomEmail);
    }

    public void inputRandomSingUpPassword() {
        waitElementVisibility(signUpPasswordInput);
        signUpPasswordInput.sendKeys(randomPassword);
        signUpConfirmPasswordInput.sendKeys(randomPassword);
    }

    public void tapSignUpSubmitBtn() {
        singUpSubmitBtn.click();
    }

    public String getSingUpPopupText() {
        waitElementVisibility(singUpPopUp);
        return singUpPopUp.getText();
    }

    public void tapLoginBtn() {
        waitToBeClickable(loginBtn);
        loginBtn.click();
    }

    public void inputLoginEmail() {
        waitElementVisibility(loginEmailInput);
        loginEmailInput.sendKeys(randomEmail);
    }

    public void inputLoginPassword() {
        waitElementVisibility(loginPasswordInput);
        loginPasswordInput.sendKeys(randomPassword);
    }

    public void tapLoginSubmitBtn() {
        loginSubmitBtn.click();
    }

    public String getLoginPopupText() {
        waitElementVisibility(loginPopUp);
        return loginPopUp.getText();
    }

    public static String generateRandomEmail() {
        StringBuilder email = new StringBuilder("email");
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        for (int i = 0; i < 4; i++) {
            email.append(randomNumber);
        }
        return email.append("@example.com").toString();
    }

    public static String generateRandomPassword() {
        StringBuilder password = new StringBuilder();
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int length = 8;

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }
        return password.toString();
    }

    public LoginScreen(AndroidDriver driver) {
        super(driver);
    }
}
