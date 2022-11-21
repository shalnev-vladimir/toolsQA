package com;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Alert;
import static org.testng.Assert.assertEquals;

public class AlertActions {

    public static String getAlertText() {
        return Selenide.switchTo().alert().getText();
    }

    public static void getAlertTextCheckItIsCorrectAndAcceptAlert(String expectedAlertText) {
        assertEquals(Selenide.switchTo().alert().getText(), expectedAlertText,
                "Incorrect alert text");
        Selenide.switchTo().alert().accept();
    }

    // click ok button
    public static void acceptAlert() {
        Selenide.switchTo().alert().accept();
    }

    // click cancel button
    public static void dismissAlert() {
        Selenide.switchTo().alert().dismiss();
    }

    public static void alertSendKeys(String keysToSend) {
        Alert alert = Selenide.switchTo().alert();
        Selenide.switchTo().alert().sendKeys(keysToSend);
        alert.accept();
    }
}
