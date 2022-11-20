package com;

import io.qameta.allure.Description;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TabsPageTest extends TestHelper {

    @Description("check tabs names")
    @Test
    void checkTabsNames() {
        openByUrl(tabsUrl);
        ArrayList<String> actualTabsNames = (ArrayList<String>) tabsPage.getTabsNames();
        List<String> expectedTabsNames = Arrays.asList("What", "Origin", "Use", "More");

        assertEquals(actualTabsNames, expectedTabsNames,
                "Expected tab's names are " + expectedTabsNames + ", but actual are " + actualTabsNames);
    }

    @Test
    void isWhatTabActive() {
        openByUrl(tabsUrl);
        tabsPage.selectTab(tabsPage.getWhatTab());
        String actualValue = tabsPage.getWhatTab().getAttribute("className");

        assert actualValue != null;
        assertTrue(actualValue.contains("active"));
    }

    @Test
    void isOriginTabActive() {
        openByUrl(tabsUrl);
        tabsPage.selectTab(tabsPage.getOriginTab());
        String actualValue = tabsPage.getOriginTab().getAttribute("className");

        assert actualValue != null;
        assertTrue(actualValue.contains("active"));
    }

    @Test
    void isUseTabActive() {
        openByUrl(tabsUrl);
        tabsPage.selectTab(tabsPage.getUseTab());
        String actualValue = tabsPage.getUseTab().getAttribute("className");

        assert actualValue != null;
        assertTrue(actualValue.contains("active"), "Tab is not active");
    }

    @Parameters({"whatTabText"})
    @Test
    void checkWhatTextBoxContainsExactText(String whatTabText) {
        openByUrl(tabsUrl);
        tabsPage.selectTab(tabsPage.getWhatTab());
        String actualText = tabsPage.textBox.getAttribute("innerText");

        assertEquals(whatTabText, actualText);
    }

    @Parameters({"originTabText"})
    @Test
    void checkOriginTextBoxContainsExactText(String originTabText) {
        openByUrl(tabsUrl);
        tabsPage.selectTab(tabsPage.getOriginTab());
        String actualText = tabsPage.getTextFromOriginTextBox();

        assertEquals(actualText, originTabText);
    }

    @Parameters({"useTabText"})
    @Test
    void checkUseTextBoxContainsExactText(String useTabText) {
        openByUrl(tabsUrl);
        tabsPage.selectTab(tabsPage.getUseTab());
        String actualText = tabsPage.getTextFromUseTextBox();

        assertEquals(actualText, useTabText);
    }
}
