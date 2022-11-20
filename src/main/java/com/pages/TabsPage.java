package com.pages;

import com.PageElementActions;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TabsPage {

    private SelenideElement what = $("#demo-tab-what");
    @Step("Returns 'What' tab")
    public SelenideElement getWhatTab() {
        return what;
    }

    private SelenideElement origin = $("#demo-tab-origin");
    @Step("Returns 'Origin' tab")
    public SelenideElement getOriginTab() {
        return what;
    }

    private SelenideElement use = $("#demo-tab-use");
    @Step("Returns 'Use' tab")
    public SelenideElement getUseTab() {
        return what;
    }

    private SelenideElement more = $("#demo-tab-more");
    @Step("Returns 'More' tab")
    public SelenideElement getMoreTab() {
        return what;
    }

    private final ElementsCollection tabs = $$(".nav-tabs > a");
    public final SelenideElement textBox = $("#demo-tabpane-what .mt-3");

    private final SelenideElement originTextBox = $("#demo-tabpane-origin .mt-3");
    @Step("Returns text from origin text box")
    public String getTextFromOriginTextBox() {
        return originTextBox.getAttribute("innerText");
    }

    private final SelenideElement useTextBox = $("#demo-tabpane-use .mt-3");
    @Step("Returns text from origin text box")
    public String getTextFromUseTextBox() {
        return useTextBox.getAttribute("innerText");
    }

    @Step("Returns text from text box")
    public String getTextFromTextBox() {
        return textBox.text();
    }

    @Step("Returns list of tab's names")
    public List<String> getTabsNames() {
        return new ArrayList<>(tabs.texts());
    }

    @Step("select tab")
    public void selectTab(SelenideElement tabName) {
        PageElementActions.click(tabName);
    }
}
