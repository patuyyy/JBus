package raihanMuhammadIhsanJBusAF;
import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class Validate
     */
    public Validate()
    {
        
    }

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
