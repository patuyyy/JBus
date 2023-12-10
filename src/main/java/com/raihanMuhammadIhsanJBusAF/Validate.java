package com.raihanMuhammadIhsanJBusAF;
import java.util.ArrayList;

/**
 * The {@code Validate} class provides methods for filtering a list of Price objects based on certain criteria.
 *
 * <p>It includes a static method {@code filter} that allows filtering a list of Price objects based on a specified value and comparison operator.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Validate
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Validate.
     */
    public Validate()
    {
        
    }
    /**
     * Filters a list of Price objects based on a specified value and comparison operator.
     *
     * @param list   the array of Price objects to be filtered
     * @param value  the value used for comparison
     * @param less   a boolean flag indicating whether to filter values less than or equal to the specified value
     * @return an ArrayList containing the filtered prices
     */
    public static ArrayList filter(Price[] list, int value, boolean less)
    {
        // put your code here
        ArrayList<Double> listTemp = new ArrayList<Double>();
        
        if (less == true)
        {
            for(int i = 0; i < list.length; i++)
            {
                if(list[i].price <= value)
                {
                    listTemp.add(list[i].price);
                }
            }
        }
        else
        {
            for(int i = 0; i < list.length; i++)
            {
                if(list[i].price > value)
                {
                    listTemp.add(list[i].price);
                }
            }
        }
        return listTemp;
    }
}
