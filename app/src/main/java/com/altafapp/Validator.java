package com.altafapp;

import android.text.TextUtils;
import android.util.Patterns;

/**
 * Utility class to handle validation of form inputs.
 */
public class Validator {

    /**
     * Validates if the provided email is in correct format.
     *
     * @param email Email to validate
     * @return true if email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    /**
     * Validates if username meets minimum length requirement.
     *
     * @param username Username to validate
     * @param minLength Minimum length required
     * @return true if username is valid, false otherwise
     */
    public static boolean isValidUsername(String username, int minLength) {
        return !TextUtils.isEmpty(username)
                && username.length() >= minLength
                && !username.matches("\\d+"); // disallow only digits
    }

    /**
     * Validates if password meets minimum length requirement.
     *
     * @param password Password to validate
     * @param minLength Minimum length required
     * @return true if password is valid, false otherwise
     */
    public static boolean isValidPassword(String password, int minLength) {
        return !TextUtils.isEmpty(password) && password.length() >= minLength;
    }

    /**
     * Checks if passwords match.
     *
     * @param password Password
     * @param confirmPassword Confirmation password
     * @return true if passwords match, false otherwise
     */
    public static boolean doPasswordsMatch(String password, String confirmPassword) {
        return !TextUtils.isEmpty(password) && password.equals(confirmPassword);
    }
}