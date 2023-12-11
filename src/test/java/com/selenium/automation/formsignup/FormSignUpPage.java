package com.selenium.automation.formsignup;

import com.selenium.automation.PageObject;
import com.selenium.automation.createAccountPage.AccountCreatePage;
import com.selenium.automation.createAccountPage.CreateAccountPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FormSignUpPage extends PageObject {
    private static final String URL_SIGNUP = "https://automationexercise.com/signup";
    private static final String URL_ACCOUNT_CREATED = "https://automationexercise.com/account_created";
    public FormSignUpPage(WebDriver browser) {
        super(browser);
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

    public void takeFieldsInMainForm(int type, String password) {
        if(type == 1) {
            browser.findElement(By.id("uniform-id_gender1")).click();
        } else if(type == 2){
            browser.findElement(By.id("uniform-id_gender2")).click();
        }
        browser.findElement(By.id("password")).sendKeys(password);
    }

    public void selectFieldsData() {
        Select days = new Select(browser.findElement(By.id("days")));
        days.selectByIndex(15);
        Select month = new Select(browser.findElement(By.id("months")));
        month.selectByIndex(11);
        Select year = new Select(browser.findElement(By.id("years")));
        year.selectByIndex(20);
    }


    public AccountCreatePage fillFieldsAdress(String name, String lastName, String company,
                                              String adress, String adress2, String state,
                                              String city, String zipCode, String number) {
        browser.findElement(By.id("first_name")).sendKeys(name);
        browser.findElement(By.id("last_name")).sendKeys(lastName);
        browser.findElement(By.id("company")).sendKeys(company);

        browser.findElement(By.id("address1")).sendKeys(adress);
        browser.findElement(By.id("address2")).sendKeys(adress2);

        Select country = new Select(browser.findElement(By.id("country")));
        country.selectByIndex(2);

        browser.findElement(By.id("state")).sendKeys(state);
        browser.findElement(By.id("city")).sendKeys(city);
        browser.findElement(By.id("zipcode")).sendKeys(zipCode);
        browser.findElement(By.id("mobile_number")).sendKeys(number);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();

        return new AccountCreatePage(browser);

    }

    public boolean createdAccount() {
        return browser.getCurrentUrl().equals(URL_ACCOUNT_CREATED);
    }

    public boolean isPageMain() {
        return browser.getCurrentUrl().equals(URL_SIGNUP);
    }
}
