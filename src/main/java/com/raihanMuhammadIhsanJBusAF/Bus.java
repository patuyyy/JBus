package com.raihanMuhammadIhsanJBusAF;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;
import java.io.IOException;


/**
 * Write a description of class Bus here.
 *
 * @RaihanMuhammadIhsan
 * @version (a version number or a date)
 */
public class Bus extends Serializable
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
    public List<Schedule> schedules;
    
    /**
     * Constructor for objects of class Bus
     */
    public Bus(String name, Facility facility, Price price, int capacity,
        BusType busType, City city, Station departure, Station arrival)
    {
        super();
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.busType = busType;
        this.city = city;
        this.schedules = new ArrayList<Schedule>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *   y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        return super.id + " " + this.name + " " + this.facility + " " + this.price 
        + " " + this.capacity + " " + this.departure + " " + this.arrival
        + " " + this.busType + " " + this.city;
    }

    public void addSchedule(Timestamp calendar) throws Exception
    {
        for(Schedule s : schedules) {
            if (s.departureSchedule == calendar) {
                throw new IllegalArgumentException("Error cuk");
            }
        }
        this.schedules.add(new Schedule(calendar, this.capacity));
    }
    /*
    public void printSchedule(Schedule schedule)
    {
        System.out.println(schedule.seatAvailability);
    }*/
    
    public Object write()
    {
        return null;
    }
    public boolean read(String filename)
    {
        return true;
    }
}

