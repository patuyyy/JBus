package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Voucher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voucher
{
    // instance variables - replace the example below with your own
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;

    /**
     * Constructor for objects of class Voucher
     */
    public Voucher(String name, int code, Type type, double minimum, double cut)
    {
        // initialise instance variables
        this.name = name;
        this.code = code;
        this.type = type;
        this.minimum = minimum;
        this.cut = cut;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isUsed()
    {
        return this.used;
    }
    
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
