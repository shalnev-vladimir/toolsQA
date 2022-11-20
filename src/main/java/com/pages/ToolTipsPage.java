package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;
import java.util.Objects;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class ToolTipsPage {

    private SelenideElement toolTipButton = $("#toolTipButton");
    private SelenideElement toolTipTextField = $("#toolTipTextField");
    private SelenideElement toolTipContraryLink = $("#texToolTopContainer > a:nth-child(1)");
    private SelenideElement toolTipSectionNumberLink = $("#texToolTopContainer > a:nth-child(2)");

    public SelenideElement getToolTipButton() {
        return toolTipButton;
    }

    public SelenideElement getToolTipTextField() {
        return toolTipTextField;
    }

    public SelenideElement getToolTipContraryLink() {
        return toolTipContraryLink;
    }

    public SelenideElement getToolTipSectionNumberLink() {
        return toolTipSectionNumberLink;
    }

    public String hoverOverToolTip(SelenideElement toolTipElement) {
        SelenideElement element = toolTipElement.hover().shouldHave(attribute("aria-describedby"), Duration.ofMillis(5000));
        return element.getAttribute("aria-describedby");
    }
}
