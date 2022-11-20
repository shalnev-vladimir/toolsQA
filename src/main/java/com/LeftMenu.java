package com;

import com.codeborne.selenide.SelenideElement;

import static com.PageElementActions.click;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LeftMenu {

    public static final SelenideElement SELECT_MENU = $(byXpath("//span[text()='Select Menu']"));

    public static void getMenuOption(SelenideElement menuOption) {
        click(menuOption);
    }
}
