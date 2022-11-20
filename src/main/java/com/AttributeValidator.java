package com;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.cssClass;

public class AttributeValidator {

    public static String hoverOverElementAndWaitUntilNewAttributeAppear(SelenideElement element, String attribute) {
        SelenideElement el = element.hover().shouldHave(attribute(attribute), Duration.ofMillis(5000));
        return el.getAttribute(attribute);
    }

    public static boolean clickElementAndWaitUntilNewClassAppear(SelenideElement element, SelenideElement targetElement,
                                                                 String className) {
        PageElementActions.click(element);
        targetElement.shouldHave(cssClass(className), Duration.ofMillis(5000));
        return targetElement.has(cssClass(className));
    }
}
