package com.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AccordianPage {

    private final SelenideElement sectionOneHeading = $("#section1Heading");
    private final SelenideElement sectionOneContext = $(byXpath("//div[@id='section1Content']/.."));
    private final SelenideElement sectionTwoHeading = $("#section2Heading");
    private final SelenideElement sectionTwoContext = $(byXpath("//div[@id='section2Content']/.."));
    private final SelenideElement sectionThreeHeading = $("#section3Heading");
    private final SelenideElement sectionThreeContext = $(byXpath("//div[@id='section3Content']/.."));

    public SelenideElement getSectionTwoHeading() {
        return sectionTwoHeading;
    }

    public SelenideElement getSectionTwoContext() {
        return sectionTwoContext;
    }

    public SelenideElement getSectionOneHeading() {
        return sectionOneHeading;
    }

    public SelenideElement getSectionOneContext() {
        return sectionOneContext;
    }

    public SelenideElement getSectionThreeHeading() {
        return sectionThreeHeading;
    }

    public SelenideElement getSectionThreeContext() {
        return sectionThreeContext;
    }
}
