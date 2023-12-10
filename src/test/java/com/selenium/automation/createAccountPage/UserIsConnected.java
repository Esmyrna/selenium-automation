package com.selenium.automation.createAccountPage;

import com.selenium.automation.PageObject;
import org.openqa.selenium.WebDriver;

public class UserIsConnected extends PageObject {
    private static final String URL_CONNECTED = "https://automationexercise.com/";
    public UserIsConnected(WebDriver browser) {
        super(browser);
    }
}
