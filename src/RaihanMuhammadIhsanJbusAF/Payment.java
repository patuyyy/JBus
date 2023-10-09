package raihanMuhammadIhsanJBusAF;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    private int busId;
    public Timestamp departureDate;
    public String busSeat;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate)
    {
        // initialise instance variables
        super(id, buyerId, renterId);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeat = busSeat;
    }
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat, Timestamp departureDate)
    {
        super(id, buyer, renter);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeat = busSeat;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     *   sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        // put your code here
        return (super.id + " " + super.buyerId + " " + super.renterId + " " + super.time +  " " + this.busId + " " + this.departureDate + " " + this.busSeat);
    }
    public int getBusId()
    {
        return this.busId;
    }
    public String getDepartureInfo()
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String simpleDate= SDFormat.format(this.departureDate.getTime());
        return (super.id + " " + super.buyerId + " " + super.renterId + " " + " " + this.busId + " " + simpleDate + " " + this.busSeat);
    }
    public String getTime()
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String simpleDate = SDFormat.format(super.time.getTime());
        return simpleDate;
    }
    /*public static boolean isAvailable(Timestamp departureSchedule, String seat, Bus bus)
    {
        for (Schedule s : bus.schedules) {
            if(s.isSeatAvailable(seat) && s.departureSchedule.equals(departureSchedule))
            {
                return true;
            }
        }
        return false;
    }*/
    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus)
    {
        for (Schedule s : bus.schedules) {
            if(s.departureSchedule.equals(departureSchedule))
            {
                s.bookSeat(seat);
                return true;
            }
        }
        return false;
    }

    public static boolean makeBooking(Timestamp departureSchedule, List<String> seatList, Bus bus)
    {
        for (Schedule s : bus.schedules) {
            if(s.departureSchedule.equals(departureSchedule))
            {
                for(int i = 0; i < seatList.size(); i++)
                {
                    s.bookSeat(seatList.get(i));
                }
                return true;
            }
        }
        return false;
    }

    public static Schedule availableSchedule(Timestamp date, String seat, Bus bus)
    {
        for(Schedule s : bus.schedules)
        {
            if(s.departureSchedule.equals(date) && s.isSeatAvailable(seat))
            {
                return s;
            }
            else return null;
        }
        return null;
    }

    public static Schedule availableSchedule(Timestamp date, List<String> seatList, Bus bus)
    {
        int counter = 0;
        for(Schedule s : bus.schedules)
        {
            for (int i = 0; i<seatList.size(); i++) {
                if (s.departureSchedule.equals(date) && s.isSeatAvailable(seatList.get(i))) {
                    counter++;
                }
            }
            if (counter == seatList.size())
            {
                return s;
            }
        }
        return null;
    }
}
