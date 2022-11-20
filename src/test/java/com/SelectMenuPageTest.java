package com;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class SelectMenuPageTest extends TestHelper {

    @Test
    void checkDropDownMenuValueCanBeSelected() {
        openSelectMenu();
        SelectMenu selectMenu = new SelectMenu();
        PageElementActions.select(selectMenu.selectValueDropDown,"Group 1, option 1");
        String actualValue = selectMenu.selectValueInput.getAttribute("innerText");

        assertEquals(actualValue, "Group 1, option 1");
    }
}
