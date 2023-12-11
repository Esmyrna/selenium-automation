package com.selenium.automation.formsignup;


import com.selenium.automation.signup.SignUpPage;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

public class FormSignUpTest  {
    FormSignUpPage formSignUpPage;
    private Random random = new Random();
    private Integer randomNumber = random.nextInt(99999999);
    String email = "testeQA" + randomNumber.toString() + "@gmail.com";
   @BeforeEach
    public void beforeEach() {
       SignUpPage signUpPage = new SignUpPage();
       this.formSignUpPage = signUpPage.clickPageSignUp();
       this.formSignUpPage.fillFieldsSignUp("testando", email);
   }

   @Test
    public void fillFieldsInTheFirstForm() {
       formSignUpPage.takeFieldsInMainForm(1, "23232323");
       formSignUpPage.selectFieldsData();


       formSignUpPage.fillFieldsAdress("Maria", "Eduarda", "Empresa Tal", "Rua São Felix",
               "Rua Santo João", "PE", "Recife", "12213144", "82");

       Assert.assertTrue(formSignUpPage.createdAccount());
   }

    @Test
    public void shouldValidateSignUpUser() {
        formSignUpPage.takeFieldsInMainForm(3, "");
        formSignUpPage.selectFieldsData();


        formSignUpPage.fillFieldsAdress("", "", "Empresa Tal", "Rua São Felix",
                "Rua Santo João", "PE", "Recife", "12213144", "82");

        Assert.assertFalse(formSignUpPage.createdAccount());
        Assert.assertTrue(formSignUpPage.isPageMain());
    }
}
