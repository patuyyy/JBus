package raihanMuhammadIhsanJBusAF;


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
    public int phoneNumber;
    /**
     * Constructor for objects of class Renter
     */
    public Renter(int id,String companyName)
    {
        super(id);
        this.companyName = companyName;
        this.address = null;
        this.phoneNumber = 0;
    }
    public Renter(int id,String companyName, String address)
    {
        super(id);
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = 0;
    }
    public Renter(int id,String companyName, int phoneNumber)
    {
        super(id);
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = null;
    }
    public Renter(int id,String companyName, int phoneNumber, String address)
    {
        super(id);
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

}
