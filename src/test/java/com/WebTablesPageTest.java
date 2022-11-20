package com;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WebTablesPageTest extends TestHelper implements BasePage {

    @BeforeMethod
    void openPage() {
        openByUrl(webTablesPageUrl);
    }

    @Test(groups = {"smoke"}, description = "Check all key elements are displayed on the page")
    void checkAllKeyElementsAreDisplayed() {
        for (SelenideElement selenideElement : webTablesPage.getKeyFields()) {
            assertTrue(selenideElement.isDisplayed(), "This element does not exist" + selenideElement);
        }
    }

    @Test(groups = {"smoke"}, description = "Check table headers texts have correct value")
    void checkTableHeadersTextsTest() {
        List<String> expectedHeaders = List.of("First Name", "Last Name", "Age", "Email", "Salary", "Department", "Action");
        assertEquals(webTablesPage.getColumnHeadersTexts(), expectedHeaders, "Table has wrong headers");
    }

    @AfterMethod
    void closePage() {
        Selenide.closeWebDriver();
    }
}
