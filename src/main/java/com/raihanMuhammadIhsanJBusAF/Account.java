package com.raihanMuhammadIhsanJBusAF;

import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code Account} class represents an account containing information such as name, email, password,
 * associated company (if any), and balance. It also provides methods for validation, top-up, and payment.
 * Extends the {@code Serializable} class for serialization purposes.
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0
 */
public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    /**
     * The email associated with the account.
     */
    public String email;
    /**
     * The name associated with the account.
     */
    public String name;
    /**
     * The password associated with the account.
     */
    public String password;
    /**
     * The company associated with the account.
     */
    public Renter company;
    /**
     * The balance associated with the account.
     */
    public double balance;
    /**
     * The email regex pattern for validation.
     */
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
    /**
     * The password regex pattern for validation.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$";
    /**
     * Constructor for objects of class Account.
     *
     * @param name     The name associated with the account.
     * @param email    The email associated with the account.
     * @param password The password associated with the account.
     */
    public Account(String name, String email, String password)
    {
        super();
        this.company = null;
        this.balance = 0;
        this.name = name;
        this.email = email;
        this.password = password;
        
    }

    /**
     * Returns a string representation of the {@code Account} object.
     *
     * @return A string representation of the object.
     */
    public String toString()
    {
        return super.id + " " + this.name + " " + this.email + " " + this.password;
    }
    /**
     * Writes the object to a file or database.
     *
     * @return Always returns null as the implementation is not provided.
     */
    public Object write(){
        return null;
    }
    /**
     * Reads the object from a file or database.
     *
     * @param string The string to read from.
     * @return Always returns false as the implementation is not provided.
     */
    public boolean read(String string){
        return false;
    }
    /**
     * Validates the email and password using regex patterns.
     *
     * @return True if both email and password are valid; false otherwise.
     */
    public boolean validate() {
        Pattern patternEmail = Pattern.compile(REGEX_EMAIL);
        Matcher matcherEmail = patternEmail.matcher(this.email);
        boolean matcherFindEmail = matcherEmail.find();
        Pattern patternPassword = Pattern.compile(REGEX_PASSWORD);
        Matcher matcherPassword = patternPassword.matcher(this.password);
        boolean matcherFindPassword = matcherPassword.find();

        if (matcherFindPassword && matcherFindEmail) {
            return true;
        }else return false;
    }
    /**
     * Adds a specified amount to the account balance.
     *
     * @param amount The amount to be added to the balance.
     * @return True if the top-up is successful; false if the amount is not positive.
     */
    public boolean topUp(double amount) {
        if(amount > 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }
}
