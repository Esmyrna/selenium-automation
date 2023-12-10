package com.selenium.automation.signup;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class SignUpTest {
    private SignUpPage signUpPage;
    private Random random = new Random();
    private Integer randomNumber = random.nextInt(99999999);
    String email = "equipeQA.teste" + randomNumber.toString() + "@gmail.com";

    @BeforeEach
    public void beforeEach() {
        this.signUpPage = new SignUpPage();
    }

    @Test
    public void changeSignUpPage() {
        this.signUpPage.clickPageSignUp();
        Assert.assertTrue(signUpPage.isPageForm());
    }

    @Test
    public void validateSignUpPage() {
        this.signUpPage.clickPageSignUp();
        this.signUpPage.fillFieldsSignUp("teste", email);
        Assert.assertTrue(signUpPage.isMainPage());
    }
}
