package com.example.tests;

import com.microsoft.playwright.*;
import org.testng.annotations.*;

public class ExamplePlaywrightTest {
    private Playwright playwright;
    private Browser browser;

    @BeforeClass
    public void setUp() {
        playwright = Playwright.create();
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
    }

    @Test
    public void testGoogleTitle() {
        BrowserContext context = browser.newContext();
        Page page = context.newPage();
        page.navigate("https://www.google.com");
        String title = page.title();
        assert title.contains("Google");
        context.close();
    }

   // @AfterClass
    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
