package com.selenium.automation.createAccountPage;

import com.selenium.automation.PageObject;
import org.openqa.selenium.WebDriver;

public class AccountCreatePage extends PageObject {
    private static final String URL_ACCOUNT_CREATED = "https://automationexercise.com/account_created";
    public AccountCreatePage(WebDriver browser) {
        super(browser);
    }
}
