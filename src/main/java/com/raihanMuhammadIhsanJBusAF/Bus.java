package com.raihanMuhammadIhsanJBusAF;
import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;


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
    public List<Facility> facilities;
    public Price price;
    public int capacity;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public List<Schedule> schedules;
    public int accountId;
    
    /**
     * Constructor for objects of class Bus
     */
    public Bus(String name, List<Facility> facilities, Price price, int capacity,
        BusType busType, Station departure, Station arrival)
    {
        super();
        this.name = name;
        this.facilities = facilities;
        this.price = price;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.busType = busType;
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
        return super.id + " " + this.name + " " + this.facilities + " " + this.price
        + " " + this.capacity + " " + this.departure + " " + this.arrival
        + " " + this.busType;
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

