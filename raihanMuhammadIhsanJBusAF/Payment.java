package raihanMuhammadIhsanJBusAF;
import java.util.Calendar;
import java.text.SimpleDateFormat;


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
    public Calendar departureDate;
    public String busSeat;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat)
    {
        // initialise instance variables
        super(id, buyerId, renterId);
        this.busId = busId;
        this.departureDate = Calendar.getInstance();
        this.departureDate.add(Calendar.DATE, +2);
        this.busSeat = busSeat;
    }
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat)
    {
        super(id, buyer, renter);
        this.busId = busId;
        this.departureDate = Calendar.getInstance();
        this.departureDate.add(Calendar.DATE, +2);
        this.busSeat = busSeat;
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
        String simpleDate = SDFormat.format(this.departureDate.getTime());
        return simpleDate;
    }
}
