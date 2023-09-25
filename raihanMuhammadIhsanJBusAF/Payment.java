package raihanMuhammadIhsanJBusAF;


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
    public String departureDate;
    public String busSeat;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, String time, int busId, String departureDate, String busSeat)
    {
        // initialise instance variables
        super(id, buyerId, renterId, time);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeat = busSeat;
    }
    public Payment(int id, Account buyer, Renter renter, String time, int busId, String departureDate,String busSeat)
    {
        super(id, buyer, renter, time);
        this.busId = busId;
        this.departureDate = departureDate;
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
}
