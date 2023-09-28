package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Bus extends Serializable implements FileParser 
{
    // instance variables - replace the example below with your own
    public String name;
    public Facility facility;
    public Price price;
    public int capacity;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public City city;
    
    /**
     * Constructor for objects of class Bus
     */
    public Bus(int id, String name, Facility facility, Price price, int capacity, 
        BusType busType, City city, Station departure, Station arrival)
    {
        super(id);
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.busType = busType;
        this.city = city;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        return super.id + " " + this.name + " " + this.facility + " " + this.price 
        + " " + this.capacity + " " + this.departure + " " + this.arrival
        + " " + this.busType + " " + this.city;
    }
}

