package com;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SelectMenu {

    public static final String SELECT_MENU_PAGE_URL = "https://demoqa.com/select-menu";

    SelenideElement selectValueDropDown = $("#withOptGroup");
    SelenideElement selectValueInput = $("#withOptGroup .css-1uccc91-singleValue");

    ElementsCollection oldStyleSelectMenuValues = $$("#oldSelectMenu > option");
    SelenideElement oldStyleDropDownMenu = $("#oldSelectMenu");
}
