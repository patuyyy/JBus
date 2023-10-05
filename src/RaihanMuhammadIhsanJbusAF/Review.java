package raihanMuhammadIhsanJBusAF;


/**
 * Write a description of class Review here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Review extends Serializable
{
    // instance variables - replace the example below with your own
    public String date;
    public String desc;

    public Review(int id, String date, String desc)
    {
        super(id);
        this.date = date;
        this.desc = desc;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
        return super.id + " " + this.date + " " + this.desc;
    }
}
