package com.globant.test;

import com.globant.Screens.*;
import com.globant.utils.test.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WdioTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    HomeScreen homeScreen;
    WebviewScreen webviewScreen;
    LoginScreen loginScreen;
    FormsScreen formsScreen;
    SwipeScreen swipeScreen;
    DragScreen dragScreen;

    @Test
    public void verifyNavigationOnTheTopBottomMenuBar(){
        homeScreen = returnHomeScreen();
        softAssert.assertTrue(homeScreen.isDemoAppForAppiumTxtDisplayed());

        webviewScreen = homeScreen.tapWebviewBtn();
        softAssert.assertTrue(webviewScreen.isMainTextWebviewTxtDisplayed());

        loginScreen = webviewScreen.tapLoginBtn();
        softAssert.assertTrue(loginScreen.isMainTextLoginTxtDisplayed());

        formsScreen = loginScreen.tapFormsBtn();
        softAssert.assertTrue(formsScreen.isMainTextFormsTxtDisplayed());

        swipeScreen = formsScreen.tapSwipeBtn();
        softAssert.assertTrue(swipeScreen.isMainTextSwipeTxtDisplayed());

        dragScreen = swipeScreen.tapDragBtn();
        softAssert.assertTrue(dragScreen.isMainTextDragTxtDisplayed());
    }

    @Test
    public void verifySuccesfullSignUp(){
        homeScreen = returnHomeScreen();

        loginScreen = homeScreen.tapLoginBtn();
        softAssert.assertTrue(loginScreen.isMainTextLoginTxtDisplayed());

        loginScreen.tapSignUpBtn();
        loginScreen.inputRandomSingUpEmail();
        loginScreen.inputRandomSingUpPassword();
        loginScreen.tapSignUpSubmitBtn();

        softAssert.assertEquals(loginScreen.getSingUpPopupText(), "You successfully signed up!");
    }

    @Test(dependsOnMethods = "verifySuccesfullSignUp")
    public void verifySuccesfullLogin(){
        homeScreen = returnHomeScreen();

        loginScreen = homeScreen.tapLoginBtn();
        softAssert.assertTrue(loginScreen.isMainTextLoginTxtDisplayed());

        loginScreen.inputLoginEmail();
        loginScreen.inputLoginPassword();
        loginScreen.tapLoginSubmitBtn();

        softAssert.assertEquals(loginScreen.getLoginPopupText(), "You are logged in!");
    }

    @Test
    public void verifySwipeCardsOnTheSwipeSection() throws InterruptedException {
        homeScreen = returnHomeScreen();

        swipeScreen = homeScreen.tapSwipeBtn();
        softAssert.assertTrue(swipeScreen.isMainTextSwipeTxtDisplayed());

        swipeScreen.performFirstElementSwipeGesture();
        softAssert.assertFalse(swipeScreen.isCarouselItem0Displayed());

        swipeScreen.performAllElementsSwipeGesture();
        softAssert.assertFalse(swipeScreen.isCarouselItem5Displayed());

        softAssert.assertEquals(swipeScreen.getFoundMeTxtTest(), "You found me!!!");

    }

}
