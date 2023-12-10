package com.selenium.automation.signup;

import com.selenium.automation.PageObject;
import com.selenium.automation.createAccountPage.CreateAccountPage;
import com.selenium.automation.formsignup.FormSignUpPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends PageObject {
    private static final String URL_MAIN = "https://automationexercise.com/";
    private static final String URL_LOGIN = "https://automationexercise.com/login";
    public SignUpPage() {
        super(null);
        this.browser.navigate().to(URL_MAIN);
    }

    public FormSignUpPage clickPageSignUp() {
        browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
        return new FormSignUpPage(browser);
    }

    public boolean isPageForm() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }

    public CreateAccountPage fillFieldsSignUp(String name, String email) {
        try {
            browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(name);
            browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(email);
            browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).submit();

            return new CreateAccountPage(browser);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new CreateAccountPage(browser);
    }
}
