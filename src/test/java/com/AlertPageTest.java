package com;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import static com.PageElementActions.click;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.testng.Assert.assertEquals;

public class AlertPageTest extends TestHelper {

    @BeforeMethod
    void openAlertPage() {
        openByUrl(alertPageUrl);
    }

    @Test(description = "Accepting alert")
    void checkClickButtonToSeeAlertTextIsCorrectTest() {
        click(alertPage.getButtonToSeeAlertImmediately());
        assertEquals(AlertActions.getAlertText(), "You clicked a button", "Incorrect  text");
        AlertActions.acceptAlert();
    }

    @Test(description = "Accepting timer alert button")
    void checkAcceptTimerAlertTest() {
        click(alertPage.getButtonToSeeAlertIn5SecondsAfterClick());
        switchTo().alert(Duration.ofMillis(10000)).accept();
    }

    @Test
    void checkAlertTextAndAcceptAlertTest() {
        click(alertPage.getButtonToSeeAlertImmediately());
        AlertActions.getAlertTextCheckItIsCorrectAndAcceptAlert("You clicked a button");
    }

    @Test
    void checkPromptAlertTest() {
        click(alertPage.getPromptBoxButton());
        String expectedMessage = Generator.getRandom10CharsText();
        AlertActions.alertSendKeys(expectedMessage);
        String promptResult = alertPage.getPromptResult();
        assertEquals(promptResult, String.format("You entered %s", expectedMessage),
                String.format("Expected message is %s but actual is %s", expectedMessage, promptResult));
        sleep(2000);
    }

    @Test(description = "Check confirm and cancel alert result")
    void checkConfirmAndCancelAlertResult() {
        click(alertPage.getConfirmBoxAlertButton());
        AlertActions.acceptAlert();
        assertEquals(alertPage.getConfirmResultText(), "You selected Ok", "Incorrect message");

        click(alertPage.getConfirmBoxAlertButton());
        AlertActions.dismissAlert();
        assertEquals(alertPage.getConfirmResultText(), "You selected Cancel", "Incorrect message");
    }

    @AfterMethod
    void close() {
        Selenide.closeWebDriver();
    }
}