package com.raihanMuhammadIhsanJBusAF.controller;

import com.raihanMuhammadIhsanJBusAF.Bus;
import com.raihanMuhammadIhsanJBusAF.City;
import com.raihanMuhammadIhsanJBusAF.Station;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonAutowired;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for handling station-related operations.
 * Includes methods for creating new stations and retrieving information about stations.
 */
@RestController
@RequestMapping("/station")
public class StationController implements BasicGetController<Station> {
    /**
     * JsonTable for managing station data storage.
     */
    @JsonAutowired(value = Station.class, filepath = "src\\main\\java\\com\\raihanMuhammadIhsanJBusAF\\json\\station.json")
    public static JsonTable<Station> stationTable;
    /**
     * Retrieves the JsonTable associated with the Station class.
     *
     * @return The JsonTable for Station.
     */
    @Override
    public JsonTable<Station> getJsonTable() {
        return stationTable;
    }
    /**
     * Endpoint for creating a new station.
     *
     * @param stationName The name of the station.
     * @param city        The city where the station is located.
     * @param address     The address of the station.
     * @return A BaseResponse containing information about the success or failure of the operation.
     */
    @PostMapping("/create")
    public BaseResponse<Station> createStation(
            @RequestParam String stationName,
            @RequestParam String city,
            @RequestParam String address
    ) {
        try {
            // Validate parameters
            if (stationName.isBlank() || city.isBlank() || address.isBlank()) {
                return new BaseResponse<>(false, "Parameter values cannot be blank or null", null);
            }

            // Validate city as a valid enum value
            City cityEnum = City.valueOf(city.toUpperCase());

            // Create a new station using the provided details
            Station newStation = new Station(stationName, cityEnum, address);

            // Add the new station to the stationTable
            stationTable.add(newStation);

            //Success response message
            return new BaseResponse<>(true, "Station added successfully", newStation);
        } catch (IllegalArgumentException e) {
            // Handle invalid enum value
            return new BaseResponse<>(false, "Invalid city value", null);
        } catch (Exception e) {
            // Handle other unexpected errors
            return new BaseResponse<>(false, "An error occurred while adding the station", null);
        }
    }
    /**
     * Endpoint for retrieving a list of all stations.
     *
     * @return A list containing all existing stations.
     */
    @GetMapping("/getAll")
    public List<Station> getAllStation() { return getJsonTable();}

}
