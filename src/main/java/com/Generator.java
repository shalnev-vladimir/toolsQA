package com;

import org.apache.commons.lang3.RandomStringUtils;

public class Generator {

    public static String getRandom10CharsText() {
        return RandomStringUtils.randomAlphabetic(10);
    }
}
