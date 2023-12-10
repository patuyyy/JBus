package com.raihanMuhammadIhsanJBusAF;


import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

/**
 * The {@code Station} class represents a bus station, including its name, associated city, and address.
 *
 * <p>Instances of this class can be created with a specified station name, city, and address.</p>
 *
 * @author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
public class Station extends Serializable
{
    /**
     * The address of the bus station.
     */
    public String address;
    /**
     * The city associated with the bus station.
     */
    public City city;
    /**
     * The name of the bus station.
     */
    public String stationName;

    /**
     * Constructor for objects of class Station with a specified station name, city, and address.
     *
     * @param stationName The name of the bus station.
     * @param city The city associated with the bus station.
     * @param address The address of the bus station.
     */
    public Station(String stationName, City city, String address)
    {
        // initialise instance variables
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }

    /**
     * Returns a string representation of the {@code Station} object.
     *
     * @return A string representation containing the station ID, name, associated city, and address.
     */
    public String toString()
    {
        // put your code here
        return super.id + " " + this.stationName + " " + this.city + " " + this.address;
    }
}
