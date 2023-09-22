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
    public City city;
    public String stationName;

    /**
     * Constructor for objects of class Station
     */
    public Station(int id, String stationName, City city)
    {
        // initialise instance variables
        super(id);
        this.stationName = stationName;
        this.city = city;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String print()
    {
        // put your code here
        return super.id + " " + this.stationName + " " + this.city;
    }
}
