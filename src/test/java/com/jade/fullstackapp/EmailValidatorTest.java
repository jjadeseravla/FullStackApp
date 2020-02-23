package com.jade.fullstackapp;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

//shift command t on the class to make a test file for it
public class EmailValidatorTest {

    private final EmailValidator emailValidatorTest = new EmailValidator();

    @Test
    public void itShouldValidateCorrectEmail() {
        assertThat(emailValidatorTest.test("jj@gmail.com")).isTrue();
    }

    @Test
    public void itShouldValidateAnIncorrectEmail() {
        assertThat(emailValidatorTest.test("jjgmail.com")).isFalse();
    }

    @Test
    public void itShouldValidateAnIncorrectEmailWithoutDotAtTheEnd() {
        assertThat(emailValidatorTest.test("jj@gmail")).isFalse();
    }
}