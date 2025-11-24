package com.example.tests;

import org.testng.annotations.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FirstTest {
    @Test
    public void firstTest() {
        try (Playwright playwright = Playwright.create()) {
            System.out.println("Playwright started successfully.");
            boolean headless = Boolean.parseBoolean(System.getProperty("headless", "true"));
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless));
            System.out.println("Browser launched successfully.");
            Page page = browser.newPage();
            page.navigate("https://google.com");
            System.out.println("Navigated to Google.");
            String title = page.title();
            System.out.println("Page title: " + title);
            assert title.contains("Google") : "Title does not contain 'Google'";
            System.out.println("Title verification passed.");
           // browser.close();
        }
    }
}
