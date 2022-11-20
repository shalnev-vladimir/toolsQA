package com;

import com.pages.AlertPage;
import org.testng.annotations.Test;

import java.time.Duration;

import static com.PageElementActions.click;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;

public class AlertPageTest extends TestHelper {

    @Test(description = "Accepting alert")
    void checkAcceptAlert() {
        openByUrl(alertPageUrl);
        click(alertPage.getButtonToSeeAlertImmediately());
        assertEquals(switchTo().alert().getText(), "You clicked a button", "Incorrect  text");
        switchTo().alert().accept();
    }

    @Test(description = "Accepting timer alert button")
    void checkAcceptTimerAlert() {
        openByUrl(alertPageUrl);
        click(alertPage.getButtonToSeeAlertIn5SecondsAfterClick());
        switchTo().alert(Duration.ofMillis(10000)).accept();
    }
}