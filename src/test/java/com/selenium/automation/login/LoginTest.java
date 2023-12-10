package com.selenium.automation.login;


import com.selenium.automation.signup.SignUpPage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    LoginPage loginPage;
    @BeforeEach
    public void beforeEach() {
        SignUpPage signUpPage = new SignUpPage();
        this.loginPage = signUpPage.userLoginPage();
    }

    @Test
    public void checkExistingLogin() {
        this.loginPage.fillFieldsLogin("testeqatestandoteste@gmail.com", "123123");
        this.loginPage.submitLogin();

        String logout = loginPage.returnPageWithLogout();
        Assert.assertEquals("Logout", logout);
    }
}
