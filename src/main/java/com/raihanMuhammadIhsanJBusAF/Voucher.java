package com.raihanMuhammadIhsanJBusAF;


import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

/**
 * The {@code Voucher} class is an abstract class that represents a voucher with a name, code, type, minimum price, and discount or rebate amount.
 *
 * <p>It includes methods for checking whether the voucher is used, determining if it can be applied to a given price, and applying the voucher to calculate the discounted or rebated price.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public abstract class Voucher extends Serializable
{
    // instance variables - replace the example below with your own
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;

    /**
     * Constructor for objects of class Voucher.
     *
     * @param id       the ID of the voucher
     * @param name     the name of the voucher
     * @param code     the code of the voucher
     * @param type     the type of the voucher (REBATE or DISCOUNT)
     * @param minimum  the minimum price requirement for applying the voucher
     * @param cut      the discount or rebate amount
     */
    public Voucher(int id, String name, int code, Type type, double minimum, double cut)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * Checks if the voucher is used.
     *
     * @return true if the voucher is used, false otherwise
     */
    public boolean isUsed()
    {
        return this.used;
    }
    /**
     * Determines whether the voucher can be applied to the given price.
     *
     * @param price the Price object to check against the voucher
     * @return true if the voucher can be applied, false otherwise
     */
    public boolean canApply(Price price)
    {
        if(price.price > this.minimum)
        {
            if(this.used == false)
            {
                return true;
            }
            return false;
        }
        return false;
    }
    /**
     * Applies the voucher to the given price, returning the discounted or rebated amount.
     *
     * @param price the Price object to apply the voucher to
     * @return the discounted or rebated price
     */
    public double apply(Price price)
    {
        // put your code here
        this.used = true;
        if(this.type == type.DISCOUNT)
        {
            if(this.cut<100)
            {
                return (100-this.cut)*price.price/100;
            }
            else
            {
                return 0.0d;
            }
        }
        else if(this.type == type.REBATE)
        {
            if(this.cut > price.price)
            {
                return 0.0d;
            }
            else
            {
                return price.price - this.cut;
            }
        }
        else return 0.0d;
    }
}
