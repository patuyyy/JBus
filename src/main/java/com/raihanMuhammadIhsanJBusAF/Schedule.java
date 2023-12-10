package com.raihanMuhammadIhsanJBusAF;
import java.sql.Timestamp;
import java.util.Map;
import java.util.LinkedHashMap;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * The {@code Schedule} class represents a schedule for a bus, including the departure timestamp and seat availability.
 *
 * <p>Instances of this class can be created with a specified departure timestamp and the number of available seats.</p>
 *
 * <p>The class provides methods to check seat availability, book seats, and print the schedule details.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Schedule
{
    /**
     * The timestamp of the departure schedule.
     */
    public Timestamp departureSchedule;
    /**
     * A map representing the availability of each seat. The key is the seat identifier, and the value is a boolean
     * indicating whether the seat is available (true) or booked (false).
     */
    public Map<String, Boolean> seatAvailability;

    /**
     * Constructor for objects of class Schedule with a specified departure timestamp and the number of available seats.
     *
     * @param departureSchedule The timestamp of the departure schedule.
     * @param numberOfSeats The number of available seats.
     */
    public Schedule(Timestamp departureSchedule, int numberOfSeats)
    {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    /**
     * Initializes the seat availability map with the specified number of available seats.
     *
     * @param numberOfSeats The number of available seats.
     */
    private void initializeSeatAvailability(int numberOfSeats)
    {
        this.seatAvailability = new LinkedHashMap<String, Boolean>();
        for(int seatNumber = 1; seatNumber < numberOfSeats+1; seatNumber++)
        {
            String sn = seatNumber < 10 ? "0"+seatNumber : ""+seatNumber;
            this.seatAvailability.put("AF" + sn, true);
        }
        /*for(int i = 1; i < numberOfSeats+1; i++)
        {
            this.seatAvailability.put("AF" + i, true);
        }*/
    }
    /**
     * Checks if a specific seat is available.
     *
     * @param seat The seat identifier.
     * @return {@code true} if the seat is available, {@code false} otherwise.
     */
    public boolean isSeatAvailable(String seat)
    {
        if (this.seatAvailability.containsKey(seat))
        {
            if (seatAvailability.get(seat)) {
                return true;
            }
            else return false;
        }
        else
        {
            return false;
        }
    }
    /**
     * Checks if a list of seats is available.
     *
     * @param seat The list of seat identifiers.
     * @return {@code true} if all seats in the list are available, {@code false} otherwise.
     */
    public boolean isSeatAvailable(List<String> seat)
    {
        int counter = 0;
        for(int i =0; i<seat.size(); i++)
        {
            if (this.seatAvailability.get(seat.get(i)) == true)
            {
                counter++;
            }
        }
        if(counter == seat.size())return true;
        else return false;

    }
    /**
     * Books a specific seat.
     *
     * @param seat The seat identifier to be booked.
     */
    public void bookSeat(String seat)
    {
        this.seatAvailability.put(seat, false);
    }
    /**
     * Books a list of seats.
     *
     * @param seatList The list of seat identifiers to be booked.
     */
    public void bookSeat(List<String> seatList)
    {
        for (String seat : seatList){
            bookSeat(seat);
        }
    }
    /**
     * Prints the schedule details including the departure timestamp and seat availability.
     */
    public void printSchedule() 
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
        // Print tanggal keberangkatan
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);
        // Print daftar kursi dan ketersediaan kursinya
        System.out.println("Daftar kursi dan ketersediaan kursinya: ");
        // Create a list of seats and sort them numerically
        int maxSeatsPerRow = 4; 
        // Assuming there are 4 seats per row
        int currentSeat = 1;
        for (String seat : this.seatAvailability.keySet()) 
        {
            String symbol = this.seatAvailability.get(seat)? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
            if (currentSeat % maxSeatsPerRow == 0) 
            {
            System.out.println();
            }
            currentSeat++;
        }
        System.out.println("\n");
    }
    /**
     * Returns a string representation of the {@code Schedule} object.
     *
     * @return A string representation containing the formatted departure schedule and seat availability information.
     */
    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
        int total = Algorithm.count(this.seatAvailability.values().iterator(), true);
        int totalF = Algorithm.count(this.seatAvailability.values().iterator(), false);
        return ("Schedule : " + formattedDepartureSchedule + "\n" + "Occupied : " + totalF + "/" + (totalF + total));
    }
}
