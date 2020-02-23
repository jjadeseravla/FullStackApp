package com.jade.fullstackapp;

import org.springframework.stereotype.Component;

import java.util.function.Predicate;
import java.util.regex.Pattern;

@Component //spring initialises it sp it can be injected in our class
public class EmailValidator implements Predicate<String> { //this class only returns true or false

    private static final Predicate<String> IS_EMAIL_VALID =
    Pattern.compile(
            "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
            Pattern.CASE_INSENSITIVE
        ).asPredicate();

        @Override
        public boolean test(String email) {
            return IS_EMAIL_VALID.test(email);
        }
}
