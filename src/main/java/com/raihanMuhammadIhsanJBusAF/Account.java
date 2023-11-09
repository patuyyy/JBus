package com.raihanMuhammadIhsanJBusAF;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Account here.
 *
 * @RaihanMuhammadIhsan
 * @version (a version number or a date)
 */
public class Account extends Serializable
{
    // instance variables - replace the example below with your own
    public String email;
    public String name;
    public String password;
    public static String REGEX_EMAIL = "^[a-z0-9]+@[a-z].+[a-z]{2,}$";
    public static String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$";
    /**
     * Constructor for objects of class Account
     */
    public Account(String name, String email, String password)
    {
        super();
        this.name = name;
        this.email = email;
        this.password = password;
        
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        return super.id + " " + this.name + " " + this.email + " " + this.password;
    }

    public Object write(){
        return null;
    }
    public boolean read(String string){
        return false;
    }

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
}
