package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Price
{
    // instance variables - replace the example below with your own
    public double rebate;
    public double price;
    public int discount;
    
    /**
     * Constructor for objects of class Price
     */
    public Price(double price)
    {
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }
    
    public Price(double price, int discount)
    {
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }
    
    public Price(double price, double rebate)
    {
        this.price = price;
        this.rebate = rebate;
        this.discount = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private double getDiscountedPrice()
    {
        if(this.discount >= 100)
        {
            return 0.0d;
        }
        else
        {
            return this.price - (this.price * (100 - this.discount));
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
    }
}
