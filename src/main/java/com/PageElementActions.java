package com;


import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PageElementActions {

    @Step("Set {radioButtonNumber} radiobutton")
    public static void setRadioButtonAndCheckItIsSelected(SelenideElement radioButton) {
        SelenideElement radioLabel = $(radioButton);
        radioLabel.scrollIntoView("{block: \"center\"}");
        radioLabel.shouldBe(enabled, Duration.ofMillis(5000)).click();
        assertTrue(radioLabel.isSelected());
    }

    @Step("Set {checkboxNumber} checkbox")
    public static void setCheckboxAndCheckItIsSelected(SelenideElement checkbox) {
        SelenideElement checkboxLabel = $(checkbox);
        checkboxLabel.scrollIntoView("{block: \"center\"}");
        checkboxLabel.shouldBe(enabled, Duration.ofMillis(5000));
        if (checkboxLabel.is(not(checked))) {
            checkboxLabel.click();
        }
        assertTrue(checkboxLabel.isSelected());
    }

    @Step("Set {checkboxNumber} radiobutton")
    public static void unselectCheckboxAndCheckItIsNotSelected(SelenideElement checkbox) {
        SelenideElement checkboxLabel = $(checkbox);
        checkboxLabel.scrollIntoView("{block: \"center\"}");
        checkboxLabel.shouldBe(enabled, Duration.ofMillis(5000));
        if (checkboxLabel.is(checked)) {
            checkboxLabel.click();
        }
        assertFalse(checkboxLabel.isSelected());
    }

    @Step("set checkbox to {setSelected}")
    public static void setCheckbox(SelenideElement checkbox, boolean setSelected) {
        checkbox.shouldNotBe(disabled);
        checkbox.scrollTo();
        if (checkbox.has(checked) != setSelected) {
            checkbox.click();
        }
    }

    public static void click(SelenideElement element) {
        element.scrollTo().shouldBe(enabled);
        element.click();
    }

    public static void select(SelenideElement dropDown, String value) {
        dropDown.click();
        SelenideElement element = $(byText(value));
        element.click();
    }

    @Step("Filling '{field}' with '{value}'")
    public static void fillTextField(SelenideElement field, String value) {
        field.shouldBe(enabled).clear();
        field.sendKeys(value);
    }
}
