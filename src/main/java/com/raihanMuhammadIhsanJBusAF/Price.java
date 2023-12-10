package com.raihanMuhammadIhsanJBusAF;


/**
 * The {@code Price} class represents the price information for a bus ticket,
 * including the base price and any applicable rebate.
 *
 * <p>Instances of this class can be created with a specified base price and rebate.</p>
 *
 * <p>The class provides a method to convert the price information to a string format.</p>
 *
 * <p>Additional methods for discounted and rebated prices have been commented out.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Price
{
    /**
     * The base rebate of the bus ticket.
     */
    public double rebate;
    /**
     * The base price of the bus ticket.
     */
    public double price;
    /*public int discount;*/

    /**
     * Constructor for objects of class Price with a specified base price.
     *
     * @param price The base price of the bus ticket.
     */
    public Price(double price)
    {
        this.price = price;
        /*this.discount = 0;*/
        this.rebate = 0;
    }

    /**
     * Constructor for objects of class Price with a specified base price and rebate.
     *
     * @param price The base price of the bus ticket.
     * @param rebate The rebate applied to the bus ticket.
     */
    public Price(double price, double rebate)
    {
        this.price = price;
        this.rebate = rebate;
        /*this.discount = 0;*/
    }

    /**
     * Returns a string representation of the {@code Price} object.
     *
     * @return A string representation of the object containing the base price and rebate.
     */
    public String toString()
    {
        return this.price + " " + this.rebate;
    }
    /*private double getDiscountedPrice()
    {
        if(this.discount >= 100)
        {
            return 0.0d;
        }
        else
        {
            return this.price * (100 - this.discount)/100;
        }
    }
    private double getRebatedPrice()
    {
        if(this.price >= this.rebate)
        {
            return this.price - this.rebate;
        }
        else
        {
            return 0.0d;
        }
    }*/
}
