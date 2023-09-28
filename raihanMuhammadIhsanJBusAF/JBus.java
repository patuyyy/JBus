package raihanMuhammadIhsanJBusAF;


/**
 *CS 1
 *Raihan Muhammad Ihsan - 2206028232
 */
public class JBus
{
    
    public static void main(String args[])
    {
        Price[] unfilteredArray = new Price[5];
        for(int i = 0; i < unfilteredArray.length; i++){
            int j = 5000;
            unfilteredArray[i] = new Price((i+1)*j);
        }

        System.out.println("Price List");
        for (Price price : unfilteredArray) {
            System.out.println(price.price);
        }

        System.out.println("Below 12000");
        System.out.println(Validate.filter(unfilteredArray, 12000, true));
        System.out.println("Above 10000");
        System.out.println(Validate.filter(unfilteredArray, 10000, false));
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

