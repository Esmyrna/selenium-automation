package com.selenium.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageObject {
    protected WebDriver browser;

    public PageObject(WebDriver browser) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\esmyr\\OneDrive\\Documentos\\Projetos\\automation\\automation\\drivers\\chromedriver.exe");
        if(browser == null) {
            this.browser = new ChromeDriver();
        } else {
            this.browser = browser;
        }
    }
    public void quit() {
        this.browser.quit();
    }
}
