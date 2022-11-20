package com.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class AlertPage {

    private final SelenideElement buttonToSeeAlertImmediately = $("#alertButton");
    private final SelenideElement buttonToSeeAlertIn5SecondsAfterClick = $("#timerAlertButton");
    private final SelenideElement confirmBoxAlertButton = $("#confirmButton");
    private final SelenideElement promptBoxButton = $("#promtButton");

    public SelenideElement getButtonToSeeAlertImmediately() {
        return buttonToSeeAlertImmediately;
    }

    public SelenideElement getButtonToSeeAlertIn5SecondsAfterClick() {
        return buttonToSeeAlertIn5SecondsAfterClick;
    }

    public SelenideElement getConfirmBoxAlertButton() {
        return confirmBoxAlertButton;
    }

    public SelenideElement getPromptBoxButton() {
        return promptBoxButton;
    }
}
