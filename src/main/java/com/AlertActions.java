package com;

import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.switchTo;

public class AlertActions {

    public static String getAlertText() {
        return switchTo().alert().getText();
    }

    // click ok button
    public static void acceptAlert() {
        switchTo().alert().accept();
    }

    // click cancel button
    public static void dismissAlert() {
        switchTo().alert().dismiss();
    }

    public static void alertSendKeys(String keysToSend) {
        Alert alert = switchTo().alert();
        alert.sendKeys(keysToSend);
        alert.accept();
    }
}
