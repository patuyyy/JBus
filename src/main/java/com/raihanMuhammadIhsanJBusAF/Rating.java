package com.raihanMuhammadIhsanJBusAF;


/**
 * The {@code Rating} class represents a simple rating system, allowing the insertion of ratings,
 * calculating the average rating, and providing information about the total count and sum of ratings.
 *
 * <p>Instances of this class are created with an initial count and total sum of ratings set to zero.</p>
 *
 * <p>The class provides methods to insert a rating, retrieve the average rating, and get the count and total sum of ratings.</p>
 *
 * <p>Additionally, a method is available to convert the rating information to a string format.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Rating
{
    /**
     * The count of ratings.
     */
    private long count;
    /**
     * The total sum of ratings.
     */
    private long total;

    /**
     * Constructor for objects of class Rating with an initial count and total sum set to zero.
     */
    public Rating()
    {
        this.count = 0;
        this.total = 0;
    }

    /**
     * Inserts a rating into the rating system.
     *
     * @param rating The rating to be inserted.
     */
    public void insert(int rating)
    {
        this.total += rating;
        this.count ++;
    }
    /**
     * Calculates and returns the average rating.
     *
     * @return The average rating or 0.0 if there are no ratings.
     */
    public double getAverage()
    {
        if(this.count == 0)
        {
            return 0.0d;
        }
        return this.total/this.count;
    }
    /**
     * Gets the count of ratings.
     *
     * @return The count of ratings.
     */
    public long getCount()
    {
        return this.count;
    }
    /**
     * Gets the total sum of ratings.
     *
     * @return The total sum of ratings.
     */
    public long getTotal()
    {
        return this.total;
    }
    /**
     * Returns a string representation of the {@code Rating} object.
     *
     * @return A string representation of the object containing the count and total sum of ratings.
     */
    public String toString()
    {
        return this.count + " " + this.total;
    }
}
