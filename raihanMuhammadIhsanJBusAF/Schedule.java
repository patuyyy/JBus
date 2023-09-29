package raihanMuhammadIhsanJBusAF;
import java.util.Calendar;
import java.util.Map;
import java.util.LinkedHashMap;


/**
 * Write a description of class Schedule here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Schedule
{
    // instance variables - replace the example below with your own
    public Calendar departureSchedule;
    public Map<String, Boolean> seatAvailability;

    /**
     * Constructor for objects of class Schedule
     */
    public Schedule(Calendar departureSchedule, int numberOfSeats)
    {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void initializeSeatAvailability(int numberOfSeats)
    {
        this.seatAvailability = new LinkedHashMap<String, Boolean>();
        for(int i = 1; i < numberOfSeats+1; i++)
        {
            this.seatAvailability.put("AF" + i, true);
        }
    }
}
