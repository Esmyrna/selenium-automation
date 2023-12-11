package com.selenium.automation.contacts;

import com.selenium.automation.signup.SignUpPage;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ContactsTest {
    ContactsPage contactsPage;
    @BeforeEach
    public void beforeEach() {
        SignUpPage signUpPage = new SignUpPage();
        this.contactsPage = signUpPage.contactUs();
    }
    @Test
    public void clickContactUsNav() {
        contactsPage.clickContact();
        Assert.assertTrue(contactsPage.isContactPage());
    }

}
