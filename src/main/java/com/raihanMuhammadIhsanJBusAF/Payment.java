package com.raihanMuhammadIhsanJBusAF;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * The {@code Payment} class is used to store information about payments made by users.
 * It extends the {@code Invoice} class and includes details such as the bus ID, departure date, and booked seats.
 *
 * <p>Instances of this class can be created using either buyer and renter IDs or instances of the
 * {@code Account} and {@code Renter} classes, respectively.</p>
 *
 * <p>It also provides methods for getting bus information, departure details, and making seat bookings.</p>
 *
 * <p>Additional methods are available to check seat availability and find available schedules.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Payment extends Invoice
{
    /**
     * The ID of the bus associated with the payment.
     */
    private int busId;
    /**
     * The timestamp indicating the departure date.
     */
    public Timestamp departureDate;
    /**
     * The list of booked bus seats.
     */
    public List<String> busSeats;

    /**
     * Constructor for objects of class Payment using buyer and renter IDs.
     *
     * @param buyerId The ID of the buyer associated with the payment.
     * @param renterId The ID of the renter associated with the payment.
     * @param busId The ID of the bus associated with the payment.
     * @param busSeats The list of booked bus seats.
     * @param departureDate The timestamp indicating the departure date.
     */
    public Payment(int buyerId, int renterId, int busId, List<String> busSeats, Timestamp departureDate)
    {
        // initialise instance variables
        super(buyerId, renterId);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeats = busSeats;
    }
    /**
     * Constructor for objects of class Payment using instances of Account and Renter.
     *
     * @param buyer The buyer associated with the payment.
     * @param renter The renter associated with the payment.
     * @param busId The ID of the bus associated with the payment.
     * @param busSeats The list of booked bus seats.
     * @param departureDate The timestamp indicating the departure date.
     */
    public Payment(Account buyer, Renter renter, int busId, List<String> busSeats, Timestamp departureDate)
    {
        super(buyer, renter);
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeats = busSeats;
    }

    /**
     * Returns a string representation of the {@code Payment} object.
     *
     * @return A string representation of the object.
     */
    public String toString()
    {
        // put your code here
        return (super.id + " " + super.buyerId + " " + super.renterId + " " + super.time +  " " + this.busId + " " + this.departureDate + " " + this.busSeats);
    }
    /**
     * Gets the ID of the bus associated with the payment.
     *
     * @return The bus ID.
     */
    public int getBusId()
    {
        return this.busId;
    }
    /**
     * Gets departure information in a formatted string.
     *
     * @return A string containing departure information.
     */
    public String getDepartureInfo()
    {
        SimpleDateFormat SDFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String simpleDate= SDFormat.format(this.departureDate.getTime());
        return (super.id + " " + super.buyerId + " " + super.renterId + " " + " " + this.busId + " " + simpleDate + " " + this.busSeats);
    }
    /**
     * Gets the timestamp of the payment creation.
     *
     * @return A string representing the timestamp.
     */
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
    /**
     * Checks seat availability for a single seat on a specific schedule of a bus.
     * if seat is Avaible, bookSeat will be call
     *
     * @param departureSchedule The timestamp of the departure schedule.
     * @param seat The seat to check for availability.
     * @param bus The bus to check for availability.
     * @return True if the seat is available; false otherwise.
     */
    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus)
    {
        for (Schedule s : bus.schedules) {
            if(s.departureSchedule.equals(departureSchedule) && s.isSeatAvailable(seat))
            {
                s.bookSeat(seat);
                return true;
            }
        }
        return false;
    }
    /**
     * Checks seat availability for a list of seats on a specific schedule of a bus.
     * if seat is Avaible, bookSeat will be call
     *
     * @param departureSchedule The timestamp of the departure schedule.
     * @param seatList The list of seats to check for availability.
     * @param bus The bus to check for availability.
     * @return True if all seats are available; false otherwise.
     */
    public static boolean makeBooking(Timestamp departureSchedule, List<String> seatList, Bus bus)
    {
        for (Schedule s : bus.schedules) {
            if(s.departureSchedule.equals(departureSchedule))
            {
                for(int i = 0; i<seatList.size(); i++) {
                    for (String seat : seatList) {
                        if(!s.isSeatAvailable(seat)) return false;
                    }
                }
                for(int i = 0; i < seatList.size(); i++)
                {
                    s.bookSeat(seatList.get(i));
                }
                return true;
            }
        }
        return false;
    }
    /**
     * Finds an available schedule for a single seat on a specific date and bus.
     *
     * @param date The timestamp of the departure schedule.
     * @param seat The seat to check for availability.
     * @param bus The bus to check for availability.
     * @return The available schedule or null if no schedule is found.
     */
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
    /**
     * Finds an available schedule for a list of seats on a specific date and bus.
     *
     * @param date The timestamp of the departure schedule.
     * @param seatList The list of seats to check for availability.
     * @param bus The bus to check for availability.
     * @return The available schedule or null if no schedule is found.
     */
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
