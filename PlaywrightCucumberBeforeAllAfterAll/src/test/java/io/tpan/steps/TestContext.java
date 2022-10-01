package io.tpan.steps;

import com.microsoft.playwright.*;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class TestContext {

    protected static Playwright playwright;

    protected static Browser browser;

    protected BrowserContext browserContext;

    protected Page page;

    @BeforeAll
    public static void beforeAll(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions() // or firefox, webkit
                .setHeadless(false)
                .setSlowMo(100));
    }

    @AfterAll
    public static void afterAll(){
        browser.close();
        playwright.close();
    }

    public Browser getBrowser() {
        return browser;
    }

    String alertText;

    public String getAlertText() {
        return alertText;
    }

    public void setAlertText(String alertText) {
        this.alertText = alertText;
    }
}
