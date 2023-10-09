package raihanMuhammadIhsanJBusAF;
import java.sql.Timestamp;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


/**
 *CS 1
 *Raihan Muhammad Ihsan - 2206028232
 */
public class JBus
{

    public static void main(String[] args) {
        // PT Modul 5
        // Tes Pagination
        Bus b = createBus();
        List<Timestamp> listOfSchedules = new ArrayList<>();
        listOfSchedules.add(Timestamp.valueOf("2023-7-18 15:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-20 12:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-22 10:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-26 12:00:00"));

        listOfSchedules.forEach(b::addSchedule);
        System.out.println("Page 1");
        Algorithm.paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("Page 2");
        Algorithm.paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");

        // Tes Booking
        String msgSuccess = "Booking Success!";
        String msgFailed = "Booking Failed";
        // valid date, invalid seat = Booking Failed
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: AF17 AF18");
        System.out.println(Payment.makeBooking(t1, List.of("AF17", "AF18"), b)? msgSuccess : msgFailed);
        // valid date, invalid seat = Booking Failed
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("Make booking at July 18, 2023 15:00:00 Seat AF26");
        System.out.println(Payment.makeBooking(t2, "AF26", b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: S7 S8");
        System.out.println(Payment.makeBooking(t2, List.of("AF7", "AF8"), b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: S1 S2");
        System.out.println(Payment.makeBooking(t3, List.of("AF1", "AF2"), b)? msgSuccess : msgFailed);
        // valid date, book the same seat = Booking Failed
        System.out.println("Make booking at July 20, 2023 12:00:00 Seat S1");
        System.out.println(Payment.makeBooking(t3, "AF1", b)? msgSuccess : msgFailed);
        // check if the data changed
        System.out.println("\nUpdated Schedule");
        Algorithm.paginate(b.schedules, 0, 4, t-> true).forEach(System.out::println);
    }
    private static void testExist(Integer[] t) {
        int valueToCheck = 67;
        boolean result3 = Algorithm.exists(t, valueToCheck);
        if (result3) {
            System.out.println(valueToCheck + " exist in the array.");
        } else {
            System.out.println(valueToCheck + " doesn't exists in the array.");
        }
    }
    public static void testCount(Integer[] t) {
        int valueToCount = 18;
        int result = Algorithm.count(t, valueToCount);
        System.out.println("Number " + valueToCount + " appears " + result + " times");
    }
    public static void testFind(Integer[] t) {
        Integer valueToFind = 69;
        Integer result2 = Algorithm.find(t, valueToFind);
        System.out.print("Finding " + valueToFind + " inside the array : ");
        if (result2 != null) {
            System.out.println("Found!" + result2);
        } else {
            System.out.println("Not Found");
        }
    }
    private static void testCollect(Integer[] t) {
        Predicate<Integer> below = (val)->val<=22;
        Predicate<Integer> above = (val)->val>43;

        List<Integer> integerBelow = Algorithm.collect(t, below);
        List<Integer> integerAbove = Algorithm.collect(t, above);

        System.out.println("Below 22");
        System.out.println(integerBelow);
        System.out.println("Above 43");
        System.out.println(integerAbove);
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(0, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
         /*Bus b = createBus();
        Payment
        Timestamp schedule1 = Timestamp.valueOf("2023-7-18 15:00:00");
        Timestamp schedule2 = Timestamp.valueOf("2023-7-20 12:00:00");

        b.addSchedule(schedule1);
        b.addSchedule(schedule2);

        b.schedules.forEach(Schedule :: printSchedule);

        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("Make booking at July 19, 2023 15:00:00 Seat AF12");
        System.out.println(Payment.makeBooking(t1, "AF12", b));
        
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seat AF20");
        System.out.println(Payment.makeBooking(t2, "AF20", b));
        
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat AF07");
        System.out.println(Payment.makeBooking(t2, "AF07", b));
        
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat AF01");
        System.out.println(Payment.makeBooking(t3, "AF01", b));

        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat AF01 again");
        System.out.println(Payment.makeBooking(t3, "AF01", b));

        System.out.println("\nUpdated Schedule\n");
        b.schedules.forEach(Schedule :: printSchedule);

          */
    }

    
    /*public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
    /*
     *KERJA CERDAS
     */
    /*
    public static int getBusId()
    {
        return 0;
    }
    
    public static String getBusName()
    {
        return "Bus";
    }
    
    public static boolean isDiscount()
    {
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount)
    {
        
        if (beforeDiscount == afterDiscount)
        {
            return 0.0f;
        }
        else if(beforeDiscount == 0)
        {
            return 0.0f;
        }
        else
        {
            return (beforeDiscount - afterDiscount)*100/beforeDiscount;
        }
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage)
    {   if(discountPercentage > 100.0f)
        {
            return 0;
        }
        else
        {
            float temp = price - ((price * discountPercentage)/100);
            return (int) temp;
        }
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage)
    {
        float temp = discountedPrice * (100.0f/(100.0f-discountPercentage));
        return (int) temp;
    }
    
    public static float getAdminFeePercentage()
    {
        return 0.05f;
    }
    
    public static int getAdminFee(int price)
    {
        float fee = getAdminFeePercentage();
        float temp = price*fee;
        return (int) temp;
    }
    
    public static int getTotalPrice(int price, int numberOfSeat)
    {
        float fee = getAdminFeePercentage();
        float temp = (price*numberOfSeat) + (price*numberOfSeat*fee);
        return (int) temp;
    }*/
}

