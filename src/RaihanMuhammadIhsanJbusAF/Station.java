package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Station here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Station extends Serializable
{
    // instance variables - replace the example below with your own
    public String address;
    public City city;
    public String stationName;

    /**
     * Constructor for objects of class Station
     */
    public Station(int id, String stationName, City city, String address)
    {
        // initialise instance variables
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        // put your code here
        return super.id + " " + this.stationName + " " + this.city + " " + this.address;
    }
}
