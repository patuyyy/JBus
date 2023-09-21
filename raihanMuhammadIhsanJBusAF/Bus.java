package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus extends Serializable
{
    // instance variables - replace the example below with your own
    public String name;
    public Facility facility;
    public Price price;
    public int capacity;
    /**
     * Constructor for objects of class Bus
     */
    public Bus(int id, String name, Facility facility, Price price, int capacity)
    {
        super(id);
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */

}
