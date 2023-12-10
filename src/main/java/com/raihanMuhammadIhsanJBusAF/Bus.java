package com.raihanMuhammadIhsanJBusAF;

import com.raihanMuhammadIhsanJBusAF.dbjson.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

/**
 * The {@code Bus} class represents a bus with various attributes such as name, facilities,
 * price, capacity, departure and arrival stations, bus type, and schedules.
 * It extends the {@code Serializable} class for serialization purposes.
 *
 * @author RaihanMuhammadIhsan
 * @version 1.0
 */
public class Bus extends Serializable {

    /**
     * The name of the bus.
     */
    public String name;

    /**
     * The list of facilities available on the bus.
     */
    public List<Facility> facilities;

    /**
     * The price information for the bus.
     */
    public Price price;

    /**
     * The maximum seating capacity of the bus.
     */
    public int capacity;

    /**
     * The departure station of the bus.
     */
    public Station departure;

    /**
     * The arrival station of the bus.
     */
    public Station arrival;

    /**
     * The type of the bus (e.g., luxury, standard).
     */
    public BusType busType;

    /**
     * The list of schedules for the bus.
     */
    public List<Schedule> schedules;

    /**
     * The unique identifier for the account associated with the bus.
     */
    public int accountId;

    /**
     * Constructs a new {@code Bus} object with the specified parameters.
     *
     * @param name      The name of the bus.
     * @param facilities The list of facilities available on the bus.
     * @param price     The price information for the bus.
     * @param capacity  The maximum seating capacity of the bus.
     * @param busType   The type of the bus.
     * @param departure The departure station of the bus.
     * @param arrival   The arrival station of the bus.
     */
    public Bus(String name, List<Facility> facilities, Price price, int capacity,
               BusType busType, Station departure, Station arrival) {
        super();
        this.name = name;
        this.facilities = facilities;
        this.price = price;
        this.capacity = capacity;
        this.departure = departure;
        this.arrival = arrival;
        this.busType = busType;
        this.schedules = new ArrayList<>();
    }

    /**
     * Returns a string representation of the {@code Bus} object.
     *
     * @return A string representation of the object.
     */
    public String toString() {
        return super.id + " " + this.name + " " + this.facilities + " " + this.price
                + " " + this.capacity + " " + this.departure + " " + this.arrival
                + " " + this.busType;
    }

    /**
     * Adds a schedule to the list of schedules for the bus.
     *
     * @param calendar The timestamp representing the schedule's departure time.
     * @throws IllegalArgumentException if a schedule with the same departure time already exists.
     */
    public void addSchedule(Timestamp calendar) throws Exception {
        for (Schedule s : schedules) {
            if (s.departureSchedule == calendar) {
                throw new IllegalArgumentException("Error: Schedule already exists.");
            }
        }
        this.schedules.add(new Schedule(calendar, this.capacity));
    }

    /**
     * Writes the object to a file or database.
     *
     * @return Always returns null as the implementation is not provided.
     */
    public Object write() {
        return null;
    }

    /**
     * Reads the object from a file or database.
     *
     * @param filename The name of the file to read from.
     * @return True if the read operation is successful; false otherwise.
     */
    public boolean read(String filename) {
        return true;
    }
}
