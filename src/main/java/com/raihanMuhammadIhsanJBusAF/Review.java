package com.raihanMuhammadIhsanJBusAF;


import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

/**
 * The {@code Review} class represents a review containing information such as the date and description.
 *
 * <p>Instances of this class can be created with a specified date and description.</p>
 *
 * <p>The class inherits from {@code Serializable}, implying that objects of this class can be serialized.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Review extends Serializable
{
    /**
     * The date of the review.
     */
    public String date;
    /**
     * The description of the review.
     */
    public String desc;
    /**
     * Constructor for objects of class Review with a specified id, date, and description.
     *
     * @param id The identifier of the review.
     * @param date The date of the review.
     * @param desc The description of the review.
     */
    public Review(int id, String date, String desc)
    {
        super();
        this.date = date;
        this.desc = desc;
    }

    /**
     * Returns a string representation of the {@code Review} object.
     *
     * @return A string representation of the object containing the id, date, and description.
     */
    public String toString()
    {
        return super.id + " " + this.date + " " + this.desc;
    }
}
