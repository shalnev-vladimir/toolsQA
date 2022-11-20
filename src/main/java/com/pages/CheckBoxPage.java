package com.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBoxPage {

    public static final String CHECKBOX_PAGE_URL = "https://demoqa.com/checkbox";
    public static final String PRACTICE_FORM = "https://demoqa.com/automation-practice-form";

    public final String HOME = "home";
    public final String DESKTOP = "desktop";
    public final String NOTES = "notes";
    public final String COMMANDS = "commands";
    public final String DOCUMENTS = "documents";
    public final String WORK_SPACE = "workspace";
    public final String OFFICE = "office";
    public final String DOWNLOADS = "downloads";
    public final String WORD_FILE = "wordFile";
    public final String EXCEL_FILE = "excelFile";
    public final ElementsCollection selectedCheckBoxElements= $$("#result > span");

    public String getCheckboxName(String checkboxName) {
        return checkboxName;
    }

    // возможно потом сделать попроще, чтобы ничего этот метод не возвращал,
    // а сразу использовал элемент в другом методе или тесте
    public SelenideElement selectCheckbox(String chosenCheckbox) {
        return $("[for='tree-node-" + chosenCheckbox + "'] .rct-checkbox > svg");
    }
    public List<String> getSelectedCheckBoxes() {
        return selectedCheckBoxElements.stream()
                .map(SelenideElement::text)
                .collect(Collectors.toList());
    }
}
