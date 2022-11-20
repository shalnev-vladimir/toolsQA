package com;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;

import java.util.concurrent.TimeoutException;

public class WaitOperator {

    @Step("wait for {description}")
    public static void waitFor(String description, boolean condition, long timeoutSec) throws TimeoutException {
        long waitTimeMs = timeoutSec * 1000;
        long startPoint = System.currentTimeMillis();
        long sleepStep = waitTimeMs / 100;
        while (!condition) {
            long currentTime = System.currentTimeMillis();
            if ((currentTime - startPoint) > timeoutSec) {
                throw new TimeoutException("Timed out waiting for condition:" + description + ", " + timeoutSec + "sec");
            }
            Selenide.sleep(sleepStep);
        }
    }
}
