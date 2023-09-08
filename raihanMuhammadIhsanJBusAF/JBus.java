package raihanMuhammadIhsanJBusAF;


/**
 *CS 1
 *Raihan Muhammad Ihsan - 2206028232
 */
public class JBus
{
    
    public static void main(String args[])
    {

    }

    /**
     *KERJA CERDAS
     */
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
        
        if (beforeDiscount < afterDiscount)
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
    }
}
