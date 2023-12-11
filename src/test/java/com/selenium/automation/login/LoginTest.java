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

    @Test
    public void checkWithoutSymbol() {
        this.loginPage.fillFieldsLogin("", "");
        this.loginPage.submitLogin();

        Assert.assertTrue(loginPage.verifyURL());
    }

    @Test
    public void checkWithInvalidDataLogin() {
        this.loginPage.fillFieldsLogin("teste234@gmail.com", "321321");
        this.loginPage.submitLogin();

        String incorrectLogin = loginPage.messageInvalidLogin();
        Assert.assertEquals("Your email or password is incorrect!", incorrectLogin);
        Assert.assertTrue(loginPage.verifyURL());
    }


}
