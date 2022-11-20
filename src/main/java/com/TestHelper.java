package com;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.pages.*;
import io.qameta.allure.Step;

import static com.LeftMenu.SELECT_MENU;
import static com.LeftMenu.getMenuOption;
import static com.PageElementActions.click;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TestHelper {

    public static final String baseUrl = "https://demoqa.com/";
    public static final String textBoxUrl = "https://demoqa.com/text-box";
    public static final String checkBoxUrl = "https://demoqa.com/checkbox";
    public static final String radioButtonUrl = "https://demoqa.com/radio-button";
    public static final String selectMenuUrl = "https://demoqa.com/select-menu";
    public static final String tabsUrl = "https://demoqa.com/tabs";
    public static final String toolTipsUrl = "https://demoqa.com/tool-tips";
    public static final String accordianUrl = "https://demoqa.com/accordian";
    public static final String webTablesPageUrl = "https://demoqa.com/webtables";
    public static final String alertPageUrl = "https://demoqa.com/alerts";

    public static final SelenideElement widgets = $(byXpath("//h5[text()='Widgets']"));

    WebTablesPage webTablesPage = new WebTablesPage();
    ToolTipsPage toolTipsPage = new ToolTipsPage();
    AccordianPage accordianPage = new AccordianPage();
    TabsPage tabsPage = new TabsPage();
    AlertPage alertPage = new AlertPage();

    @Step("open {url}")
    void openByUrl(String url) {
        Selenide.open(url);
    }

    @Step("open Select Menu")
    void openSelectMenu() {
        openByUrl(baseUrl);
        click(widgets);
        getMenuOption(SELECT_MENU);
    }
}
