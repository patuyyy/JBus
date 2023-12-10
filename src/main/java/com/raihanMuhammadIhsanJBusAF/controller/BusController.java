package com.raihanMuhammadIhsanJBusAF.controller;

import com.google.gson.JsonObject;
import com.raihanMuhammadIhsanJBusAF.*;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonAutowired;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class for handling operations related to buses.
 * Includes methods for creating buses, adding schedules, and retrieving bus information.
 */
@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus>{
    /**
     * JsonTable for managing bus data storage.
     */
    @JsonAutowired(value = Bus.class, filepath = "src\\main\\java\\com\\raihanMuhammadIhsanJBusAF\\json\\bus.json")
    public static JsonTable<Bus> busTable;
    /**
     * Retrieves the JsonTable associated with the Bus class.
     *
     * @return The JsonTable for Bus.
     */
    public JsonTable<Bus> getJsonTable() {
        return busTable;
    }
    /**
     * Endpoint for creating a new bus.
     *
     * @param accountId           The ID of the account associated with the bus.
     * @param name                The name of the bus.
     * @param capacity            The capacity of the bus.
     * @param facilities          The list of facilities available on the bus.
     * @param busType             The type of the bus (e.g., SLEEPER, EXECUTIVE).
     * @param price               The price of the bus.
     * @param stationDepartureId  The ID of the departure station.
     * @param stationArrivalId    The ID of the arrival station.
     * @return A BaseResponse containing information about the success or failure of the operation.
     */
    @PostMapping("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List<Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId
            )
    {
        try {
            // Validate parameters
            Account acc = Algorithm.<Account>find(new AccountController().getJsonTable(), t -> t.id == accountId);
            if (acc == null || acc.company == null ||
                    !Algorithm.<Station>exists(new StationController().getJsonTable(), t -> t.id == stationArrivalId) ||
                    !Algorithm.<Station>exists(new StationController().getJsonTable(), t -> t.id == stationDepartureId)) {
                return new BaseResponse<>(false, "Ada kesalahan dalam input parameter", null);
            }
            Bus bus = new Bus(name, facilities, new Price(price), capacity, busType,
                    Algorithm.<Station>find(new StationController().getJsonTable(), t->t.id == stationDepartureId),
                    Algorithm.<Station>find(new StationController().getJsonTable(), t->t.id == stationArrivalId));
            bus.accountId = accountId;
            busTable.add(bus);
            return new BaseResponse<>(true, "Berhasil membuat bus!! keren.", bus);
        }catch (Exception e) {
            return new BaseResponse<>(false, "Ada kesalahan saat membuat bus baru!", null);
        }
    }
    /**
     * Endpoint for adding a schedule to an existing bus.
     *
     * @param busId The ID of the bus to which the schedule will be added.
     * @param time  The timestamp representing the schedule time.
     * @return A BaseResponse containing information about the success or failure of the operation.
     */
    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule(
            @RequestParam int busId,
            @RequestParam String time
    )
    {
        try {
            if(Algorithm.<Bus>find(busTable, t->t.id == busId) == null){
                return new BaseResponse<>(true, "Gak ada busnya cok, null", null);
            }
            Bus bus = Algorithm.<Bus>find(busTable, t->t.id == busId);
            bus.addSchedule(Timestamp.valueOf(time));
            return new BaseResponse<>(true, "Berhasil buat schedule men!!", bus);
        }catch (Exception e) {
            return new BaseResponse<>(false, "Ada kesalahan saat menambah schedule!", null);
        }
    }
    /**
     * Endpoint for retrieving a list of buses associated with a specific account.
     *
     * @param accountId The ID of the account.
     * @return A list of buses associated with the specified account.
     */
    @GetMapping("/getMyBus")
    public List<Bus> getMyBus(@RequestParam int accountId) {
        return Algorithm.<Bus>collect(getJsonTable(), b->b.accountId==accountId);
    }
    /**
     * Endpoint for retrieving information about a specific bus.
     *
     * @param busId The ID of the bus.
     * @return Information about the specified bus.
     */
    @GetMapping("/getBus")
    public Bus getBus(@RequestParam int busId) {
        return Algorithm.<Bus>find(getJsonTable(), b->b.id==busId);
    }
    /**
     * Endpoint for retrieving information about all buses.
     *
     * @return A list of all buses.
     */
    @GetMapping("/getAllBus")
    public List<Bus> getAllBus() {
        return Algorithm.<Bus>collect(getJsonTable(), b->b.name != null);
    }
}

