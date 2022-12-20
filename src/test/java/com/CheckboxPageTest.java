package com;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.pages.CheckBoxPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;
import static com.codeborne.selenide.Selenide.*;
import static org.testng.Assert.*;

public class CheckboxPageTest extends TestHelper {

    @Test
    void isHomeCheckboxChecked() {
        final List<String> expectedCheckBoxesSelected =
                List.of("You have selected :", "home", "desktop", "notes", "commands", "documents", "workspace", "react",
                        "angular", "veu", "office", "public", "private", "classified", "general", "downloads", "wordFile",
                        "excelFile");

        CheckBoxPage checkBoxPage = open(CheckBoxPage.CHECKBOX_PAGE_URL, CheckBoxPage.class);
        PageElementActions.setCheckbox(checkBoxPage.selectCheckbox(checkBoxPage.HOME), true);
        assertEquals(checkBoxPage.getSelectedCheckBoxes(), expectedCheckBoxesSelected, "Check Boxes are not ticked");
    }

    @Test
    void checkDropDownOptionCanBeSelected() {
        SelectMenu selectMenu = open(SelectMenu.SELECT_MENU_PAGE_URL, SelectMenu.class);
        List<String> colors = Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet",
                "Indigo", "Magenta", "Aqua");
        for (SelenideElement element : selectMenu.oldStyleSelectMenuValues) {
            selectMenu.oldStyleDropDownMenu.click();
            element.click();
            assertTrue(colors.contains(element.text()));
        }
    }

    @AfterClass
    void close() {
        Selenide.closeWebDriver();
    }
}
