package com.selenium.automation.contacts;

import com.selenium.automation.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContactsPage extends PageObject {
    private static final String URL_CONTACT = "https://automationexercise.com/contact_us";
    public ContactsPage(WebDriver browser) {
        super(browser);
    }

    public void clickContact() {
        WebElement hoverable = browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));

        Actions actions = new Actions(browser);
        actions.moveToElement(hoverable).perform();

        WebElement clickableElement = browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a"));
        actions.click(clickableElement).perform();
    }

    public boolean isContactPage() {
        return browser.getCurrentUrl().equals(URL_CONTACT);
    }
}
