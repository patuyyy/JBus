package raihanMuhammadIhsanJBusAF;


import java.util.HashMap;

/**
 * Write a description of class Serializable here.
 *
 * @author ihsan
 * @version (a version number or a date)
 */
public class Serializable
{
    // instance variables - replace the example below with your own
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter;
    /*
     * Constructor for objects of class Serializable
     */
    protected Serializable()
    {
        if(mapCounter == null)
        {
            mapCounter = new HashMap<>();
            this.id = 0;
        }
        else
        {
            int counter = mapCounter.getOrDefault(this.getClass(), 0);
            mapCounter.put(this.getClass(), counter + 1);
            this.id = counter;
        }
    }

    public static <T> Integer setLastAssignedId (Class<T> obj, int id)
    {
        return mapCounter.put(obj, id);
    }

    public static <T> Integer getLastAssignedId (Class<T> obj)
    {
        return mapCounter.get(obj);
    }

    public boolean equals(Serializable object)
    {
        return this.id == object.id;
    }

    public int compareTo(Serializable object)
    {
        if(this.id == object.id)
        {
            return 0;
        }
        else if(this.id>object.id)
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    public boolean equals(Object object)
    {
        if(object instanceof Serializable)
        {
            Serializable temp = (Serializable) object;
            return temp.id == this.id;
        }
        else
        {
            return false;
        }
    }

}
