package raihanMuhammadIhsanJBusAF;


/**
 *CS 1
 *Raihan Muhammad Ihsan - 2206028232
 */
public class JBus
{
    
    public static void main(String args[])
    {
        Review testReview = new Review(1, "23 Agustus 2023", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Station testDeparture = new Station(2, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya");
        Station testArrival = new Station(3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
        Bus testBus = new Bus(1, "Busway", Facility.AC, testPrice, 50, BusType.REGULER, City.DEPOK, testDeparture, testArrival);
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testReview);
        System.out.println(testBus);
        System.out.println(testAccount);
        System.out.println(testPrice);
        System.out.println(testRating);
    }
    /**public static Bus createBus()
    {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25);
        return bus;
    }
    /**
     *KERJA CERDAS
     */
    /**
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

