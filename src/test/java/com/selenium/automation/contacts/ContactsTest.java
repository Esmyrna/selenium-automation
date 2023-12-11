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
        this.contactsPage.clickContact();
        Assert.assertTrue(contactsPage.isContactPage());
    }

    @Test
    public void completedFieldsOfContacts() {
        this.contactsPage.clickContact();
        this.contactsPage.completedDataInForm("Daniel", "teste@gmail.com", "teste" , "testando campo");
        this.contactsPage.clickEnter();

        Assert.assertEquals("Success! Your details have been submitted successfully.", contactsPage.dataSendWithSucess());
    }


}
