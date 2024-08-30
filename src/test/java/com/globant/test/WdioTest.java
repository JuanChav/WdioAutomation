package com.globant.test;

import com.globant.Screens.*;
import com.globant.utils.test.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

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

}
