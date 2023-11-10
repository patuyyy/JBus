package com.raihanMuhammadIhsanJBusAF;

import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String address;
    public String companyName;
    public String phoneNumber;
    private final String REGEX_PHONE = "[0-9]{8,11}";
    private final String REGEX_NAME = "^[A-Z][a-zA-Z_0-9]{4,20}";
    /**
     * Constructor for objects of class Renter
     */
    public Renter(String companyName)
    {
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = "";
    }
    public Renter(String companyName, String phoneNumber)
    {
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = phoneNumber;
    }

    public Renter(String companyName, String phoneNumber, String address)
    {
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

    public boolean validate() {
        Pattern patternPhone = Pattern.compile(REGEX_PHONE);
        Matcher matcherPhone = patternPhone.matcher(this.phoneNumber);
        boolean matcherFindPhone = matcherPhone.find();
        Pattern patternName = Pattern.compile(REGEX_NAME);
        Matcher matcherName = patternName.matcher(this.companyName);
        boolean matcherFindName = matcherName.find();

        if (matcherFindName && matcherFindPhone) {
            return true;
        }else return false;
    }
}
