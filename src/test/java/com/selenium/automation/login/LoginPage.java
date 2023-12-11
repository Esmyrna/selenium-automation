package com.selenium.automation.login;

import com.selenium.automation.PageObject;
import com.selenium.automation.createAccountPage.UserIsConnected;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;


public class LoginPage extends PageObject {
    private static final String URL_SIGNUP = "https://automationexercise.com/signup";
    private static final String URL_LOGIN = "https://automationexercise.com/login";

    public LoginPage(WebDriver browser) {
        super(browser);
        browser.navigate().to(URL_SIGNUP);
    }

    public void fillFieldsLogin(String email, String password) {
        try {
            browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);
            browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public UserIsConnected submitLogin() {
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).submit();
        return new UserIsConnected(browser);
    }

    public String returnPageWithLogout() {
        try {
            return browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public String messageInvalidLogin() {
        try {
            return browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).getText();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public boolean verifyURL() {
        return browser.getCurrentUrl().equals(URL_LOGIN);
    }
}
