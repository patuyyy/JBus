package raihanMuhammadIhsanJBusAF;
import java.util.Calendar;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    public enum BusRating
    {
        NONE, NEUTRAL, GOOD, BAD
    }
    public enum PaymentStatus
    {
        FAILED, WAITING, SUCCESS
    }
    // instance variables - replace the example below with your own
    public Calendar time;
    public int buyerId;
    public int renterId;
    public BusRating rating;
    public PaymentStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId)
    {
        // initialise instance variables
        super(id);
        Calendar cal1 = Calendar.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = cal1;
        this.rating = rating.NONE;
        this.status = status.WAITING;
    }
    public Invoice(int id, Account buyer, Renter renter)
    {
        // initialise instance variables
        super(id);
        Calendar cal1 = Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.time = cal1;
        this.rating = rating.NONE;
        this.status = status.WAITING;
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
        return(super.id + " " + this.buyerId + " " + this.renterId + " " + this.time);
    }
}
