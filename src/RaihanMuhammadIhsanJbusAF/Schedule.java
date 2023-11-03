package raihanMuhammadIhsanJBusAF;
import java.sql.Timestamp;
import java.util.Map;
import java.util.LinkedHashMap;
import java.text.SimpleDateFormat;
import java.util.List;


/**
 * Write a description of class Schedule here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Schedule
{
    // instance variables - replace the example below with your own
    public Timestamp departureSchedule;
    public Map<String, Boolean> seatAvailability;

    /**
     * Constructor for objects of class Schedule
     */
    public Schedule(Timestamp departureSchedule, int numberOfSeats)
    {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * sample parameter for a method
     * @return    the sum of x and y
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

    public void bookSeat(String seat)
    {
        this.seatAvailability.put(seat, false);
    }

    public void bookSeat(List<String> seatList)
    {
        for (String seat : seatList){
            bookSeat(seat);
        }
    }
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

    public String toString()
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:S");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
        int total = Algorithm.count(this.seatAvailability.values().iterator(), true);
        int totalF = Algorithm.count(this.seatAvailability.values().iterator(), false);
        return ("Schedule : " + formattedDepartureSchedule + "\n" + "Occupied : " + totalF + "/" + (totalF + total));
    }
}
