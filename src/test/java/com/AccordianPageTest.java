package com;

import com.codeborne.selenide.Condition;
import org.testng.annotations.Test;

import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class AccordianPageTest extends TestHelper {

    @Test(priority = 1)
    void checkAccodianDefualtValueTest() {
        openByUrl(accordianUrl);
        accordianPage.getSectionOneContext().shouldHave(Condition.cssClass("show"), Duration.ofMillis(3000));
        accordianPage.getSectionTwoContext().shouldNotHave(Condition.cssClass("show"), Duration.ofMillis(3000));
        accordianPage.getSectionThreeContext().shouldNotHave(Condition.cssClass("show"), Duration.ofMillis(3000));
    }

    @Test(priority = 2)
    void isSectionTwoContextDisplayedTest() {
        openByUrl(accordianUrl);
        assertTrue(AttributeValidator.clickElementAndWaitUntilNewClassAppear(accordianPage.getSectionTwoHeading(),
                accordianPage.getSectionTwoContext(), "show"));
    }

    @Test(priority = 3)
    void isSectionThreeContextDisplayedTest() {
        openByUrl(accordianUrl);
        assertTrue(AttributeValidator.clickElementAndWaitUntilNewClassAppear(accordianPage.getSectionThreeHeading(),
                accordianPage.getSectionThreeContext(), "show"));
    }
}
