package com;

import io.qameta.allure.Step;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class ToolTipsPageTest extends TestHelper {

    @Test
    void isToolTipVisible() {
        openByUrl(toolTipsUrl);
        List<String> expectedToolTipDescriptions = Arrays.asList("buttonToolTip", "contraryTexToolTip",
                "textFieldToolTip", "sectionToolTip");
        assertEquals(getAllToolTips(), expectedToolTipDescriptions);
    }

    @Step("Getting all tool tips attribute texts")
    public List<String> getAllToolTips() {
        List<String> actualToolTipDescriptions = new ArrayList<>();
        actualToolTipDescriptions.add(toolTipsPage.hoverOverToolTip(toolTipsPage.getToolTipButton()));
        actualToolTipDescriptions.add(toolTipsPage.hoverOverToolTip(toolTipsPage.getToolTipContraryLink()));
        actualToolTipDescriptions.add(toolTipsPage.hoverOverToolTip(toolTipsPage.getToolTipTextField()));
        actualToolTipDescriptions.add(toolTipsPage.hoverOverToolTip(toolTipsPage.getToolTipSectionNumberLink()));
        return actualToolTipDescriptions;
    }
}
