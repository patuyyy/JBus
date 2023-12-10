package com.raihanMuhammadIhsanJBusAF;
import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

import java.sql.Timestamp;

/**
 * The {@code Invoice} class represents an invoice containing information such as buyer ID, renter ID,
 * bus rating, timestamp, and payment status. Extends the {@code Serializable} class for serialization purposes.
 *
 * <p>Two constructors are provided: one that takes buyer ID and renter ID as parameters and another that
 * takes {@code Account} and {@code Renter} objects for ease of use.</p>
 *
 * <p>The bus rating and payment status are represented as enums {@code BusRating} and {@code PaymentStatus},
 * respectively.</p>
 *
 * @author (your name)
 * @version 1.0.0
 */
public class Invoice extends Serializable
{
    /**
     * Enum representing possible bus ratings.
     */
    public enum BusRating
    {
        NONE, NEUTRAL, GOOD, BAD
    }
    /**
     * Enumeration representing payment status.
     */
    public enum PaymentStatus
    {
        FAILED, WAITING, SUCCESS
    }
    /**
     * The ID of the buyer associated with the invoice.
     */
    public int buyerId;
    /**
     * The ID of the renter associated with the invoice.
     */
    public int renterId;
    /**
     * The bus rating associated with the invoice.
     */
    public BusRating rating;
    /**
     * The timestamp indicating when the invoice was created.
     */
    public Timestamp time;
    /**
     * The payment status associated with the invoice.
     */
    public PaymentStatus status;

    /**
     * Protected constructor for objects of class Invoice.
     *
     * @param buyerId The ID of the buyer associated with the invoice.
     * @param renterId The ID of the renter associated with the invoice.
     */
    protected Invoice(int buyerId, int renterId)
    {
        // initialise instance variables
        super();
        this.time = Timestamp.from(java.time.Instant.now());
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = rating.NONE;
        this.status = status.WAITING;
    }
    /**
     * Constructor for objects of class Invoice using instances of Account and Renter.
     *
     * @param buyer The buyer associated with the invoice.
     * @param renter The renter associated with the invoice.
     */
    public Invoice(Account buyer, Renter renter)
    {
        // initialise instance variables
        super();
        this.time = Timestamp.from(java.time.Instant.now());
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = rating.NONE;
        this.status = status.WAITING;
    }

    /**
     * Returns a string representation of the {@code Invoice} object.
     *
     * @return A string representation of the object.
     */
    public String toString()
    {
        // put your code here
        return(super.id + " " + this.buyerId + " " + this.renterId + " " + this.time);
    }
}
