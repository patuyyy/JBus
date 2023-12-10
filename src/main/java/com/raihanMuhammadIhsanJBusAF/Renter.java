package com.raihanMuhammadIhsanJBusAF;

import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The {@code Renter} class represents a company renting buses, storing information such as company name, address, and phone number.
 *
 * <p>Instances of this class can be created with a specified company name, and optional phone number and address.</p>
 *
 * <p>The class provides a validation method to check if the company name and phone number meet specific criteria.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Renter extends Serializable
{
    /**
     * The address of the renting company.
     */
    public String address;
    /**
     * The name of the renting company.
     */
    public String companyName;
    /**
     * The name of the renting company.
     */
    public String phoneNumber;
    /**
     * Regular expression for validating phone numbers.
     */
    private static final String REGEX_PHONE = "[0-9]{8,11}";
    /**
     * Regular expression for validating company names.
     */
    private static final String REGEX_NAME = "^[A-Z][a-zA-Z_0-9]{4,20}";
    /**
     * Constructor for objects of class Renter with a specified company name.
     *
     * @param companyName The name of the renting company.
     */
    public Renter(String companyName)
    {
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = "";
    }
    /**
     * Constructor for objects of class Renter with a specified company name and phone number.
     *
     * @param companyName The name of the renting company.
     * @param phoneNumber The phone number of the renting company.
     */
    public Renter(String companyName, String phoneNumber)
    {
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = phoneNumber;
    }
    /**
     * Constructor for objects of class Renter with a specified company name, phone number, and address.
     *
     * @param companyName The name of the renting company.
     * @param phoneNumber The phone number of the renting company.
     * @param address The address of the renting company.
     */
    public Renter(String companyName, String phoneNumber, String address)
    {
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    /**
     * Validates the company name and phone number based on predefined regular expressions.
     *
     * @return {@code true} if the company name and phone number are valid; {@code false} otherwise.
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
