# Mobile Automation Final Practice

This repository contains the code for the final practice of mobile automation. The practice involves automating various scenarios on Android devices using the WDIO dummy app.

## Prerequisites
Before starting with the practice, make sure you have the following:

- An Android device or emulator created using Android Studio.
- The WDIO dummy app APK. You can download it from [here](https://github.com/webdriverio/native-demo-app/releases). Make sure to use the .apk file.
- Optional: If you want to do the practice on iOS, you will need a Mac device and the required tools.

## Scenarios

### Navigation on the bottom menu bar
1. Precondition: The user should be on the Home screen.
2. Navigate to each section by tapping their respective icon on the bottom menu bar.
3. Perform assertions to check if all elements on the respective sections are correctly displayed (Check visibility and properties).

### Successful Sign Up
1. Precondition: The user should be at the Login section.
2. Navigate to the Signup section.
3. Fill all the form data to sign up. Consider generating a random email each time the test is executed or perform an action to delete the created account after the test.
4. Check if the signup process was successfully completed.

### Successful Login
1. Precondition: The user should be at the Login section and have a previously created user.
2. Navigate to the Login View.
3. Fill all the form data to log in.
4. Check if the login process was successfully completed.

### Swipe cards on the Swipe section
1. Precondition: The user should be at the Swipe section.
2. Swipe right on the cards and verify that the old card is hidden.
3. Swipe right to the last card and verify that the card is the only one visible on the screen.
4. Swipe vertically until you find "You found me!!!" and verify the text.

Note: Each test case should be fully independent from one another. The login test may reuse code from the signup test, but it should not rely on the signup test to be done earlier in order to work properly.

Feel free to explore and improve the automation code for these scenarios. Happy testing!
