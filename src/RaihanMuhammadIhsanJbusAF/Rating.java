package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Rating here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Rating
{
    // instance variables - replace the example below with your own
    private long count;
    private long total;

    /**
     * Constructor for objects of class Rating
     */
    public Rating()
    {
        this.count = 0;
        this.total = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void insert(int rating)
    {
        this.total += rating;
        this.count ++;
    }
    public double getAverage()
    {
        if(this.count == 0)
        {
            return 0.0d;
        }
        return this.total/this.count;
    }
    public long getCount()
    {
        return this.count;
    }
    public long getTotal()
    {
        return this.total;
    }
    public String toString()
    {
        return this.count + " " + this.total;
    }
}
