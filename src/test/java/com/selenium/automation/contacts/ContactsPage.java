package com.selenium.automation.contacts;

import com.selenium.automation.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.event.KeyEvent;
import java.awt.*;
import java.time.Duration;

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

    public void completedDataInForm(String name, String email, String subject, String text) {
        browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input")).sendKeys(name);
        browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[2]/input")).sendKeys(email);
        browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[3]/input")).sendKeys(subject);
        browser.findElement(By.xpath("//*[@id=\"message\"]")).sendKeys(text);
        WebElement fileInput = browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[5]/input"));
        String filePath = "C:\\Users\\esmyr\\OneDrive\\Documentos\\Projetos\\automation\\automation\\media\\txt.txt";
        fileInput.sendKeys(filePath);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement submitButton = browser.findElement(By.xpath("//*[@id=\"contact-us-form\"]/div[6]/input"));
        submitButton.submit();


    }
    public void clickEnter() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }
    }

    public String dataSendWithSucess() {
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(10));
        WebElement successElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")));


        return successElement.getText();
    }
}
