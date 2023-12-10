package com.selenium.automation.signup;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SignUpTest {
    private SignUpPage signUpPage;

    @BeforeEach
    public void beforeEach() {
        this.signUpPage = new SignUpPage();
    }

    @Test
    public void changeSignUpPage() {
        this.signUpPage.clickPageSignUp();
        Assert.assertTrue(signUpPage.isPageForm());
    }
}
