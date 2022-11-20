package com.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WebTablesPage {

    private final SelenideElement addNewRecordButton = $("#addNewRecordButton");
    private final SelenideElement searchBox = $("#searchBox");
    private final SelenideElement magnifierButton = $(".input-group-append");
    private final SelenideElement webTable = $(".ReactTable");
    private final ElementsCollection tableRows = $$(".rt-tr-group");
    private final ElementsCollection columnsHeaders = $$("[role='columnheader']");
    private final ElementsCollection firstNameColumnElements = $$(".rt-tr-group .rt-td:nth-child(1)");
    private final ElementsCollection lasNameColumnElements = $$(".rt-tr-group .rt-td:nth-child(2)");
    private final ElementsCollection ageColumnElements = $$(".rt-tr-group .rt-td:nth-child(3)");
    private final ElementsCollection emailColumnElements = $$(".rt-tr-group .rt-td:nth-child(4)");
    private final ElementsCollection salaryColumnElements = $$(".rt-tr-group .rt-td:nth-child(5)");
    private final ElementsCollection departmentColumnElements = $$(".rt-tr-group .rt-td:nth-child(6)");
    private final SelenideElement firstRecordButton = $("#edit-record-1");
    private final SelenideElement previousButton = $(byXpath("//button[contains(text(), 'Previous')]"));
    private final SelenideElement nextButton = $(byXpath("//button[contains(text(), 'Next')]"));
    private final SelenideElement pageNumber = $("[aria-label='jump to page']");
    private final SelenideElement rowsPerPage = $("[aria-label='rows per page']");

    private final List<SelenideElement> keyFields = List.of(addNewRecordButton, searchBox, webTable, previousButton,
            nextButton, pageNumber, rowsPerPage);


    public SelenideElement getAddNewRecordButton() {
        return addNewRecordButton;
    }

    public SelenideElement getSearchBox() {
        return searchBox;
    }

    public SelenideElement getMagnifierButton() {
        return magnifierButton;
    }

    public void clickEditRecordButton(int recordNumber) {
        $("#edit-record-" + recordNumber).shouldBe(enabled, Duration.ofMillis(10000)).click();
    }

    public void clickDeleteRecordButton(int recordNumber) {
        $("#delete-record-" + recordNumber).shouldBe(enabled, Duration.ofMillis(10000)).click();
    }

    public List<SelenideElement> getKeyFields() {
        return this.keyFields;
    }

    @Step("Get column headers texts")
    public List<String> getColumnHeadersTexts() {
        return columnsHeaders.texts()
                .stream()
                .map(item -> item.replace("\\n", " "))
                .collect(Collectors.toList());
    }
}
