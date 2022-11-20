package com;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FieldsChecker {

    public static boolean isCheckboxChecked(SelenideElement selectedCheckbox) {
        return selectedCheckbox.shouldBe(Condition.selected).isSelected();
    }

    public void isCheckboxUnchecked(SelenideElement selectedCheckbox) {
        assertFalse(selectedCheckbox.isSelected());
    }

    @Step("check {descr}")
    public static void checkTrue(String descr, boolean value) {
        assertTrue(value, descr);
    }
}
