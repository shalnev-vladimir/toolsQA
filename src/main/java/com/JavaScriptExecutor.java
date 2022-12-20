package com;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disabled;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class JavaScriptExecutor {

    @Step("Refreshing page")
    public static void refreshPageUsingJavaScript() {
        executeJavaScript("history.go(0)");
    }

    @Step("Clicking {buttonName} button")
    public static void clickButtonUsingJavaScript(SelenideElement buttonName) {
        executeJavaScript("arguments[0].click();", buttonName);
    }

    @Step("Returns page domain")
    public static String getPageDomainUsingJavaScript() {
        return executeJavaScript("return document.domain").toString();
    }

    @Step("Returns page title")
    public static String getPageTitleUsingJavaScript() {
        return executeJavaScript("return document.title").toString();
    }

    @Step("Returns inner text of a page")
    public static String returnsElementInnerTextUsingJavaScript() {
        return executeJavaScript("return document.documentElement.innerText;").toString();
    }

    // doesn't work. Needed to be fixed
    @Step("set checkbox to {setSelected}")
    public static void setCheckboxUsingJavaScriptExecutor(SelenideElement checkbox) {
        checkbox.shouldNotBe(disabled);
        if(!checkbox.isSelected()) {
            executeJavaScript("document.querySelectorAll('[for='tree-node-home] .rct-checkbox > svg')[0].click()");
           // checkBoxElement.click();
        }
//        checkbox.scrollTo();
//        if (checkbox.has(checked) != setSelected) {
            //executeJavaScript("document.querySelectorAll('[for='tree-node-home] .rct-checkbox > svg').checked=true;");
//        executeJavaScript("document.querySelectorAll('[for='tree-node-home] .rct-checkbox > svg').checked=false;"); //" + checkbox + "
            //checkbox.click();
       // }
    }
}
