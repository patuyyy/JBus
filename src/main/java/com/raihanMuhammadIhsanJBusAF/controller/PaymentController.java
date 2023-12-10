package com.raihanMuhammadIhsanJBusAF.controller;

import com.raihanMuhammadIhsanJBusAF.*;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonAutowired;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * Controller class for handling payment-related operations.
 * Includes methods for making bookings, accepting payments, canceling payments, and retrieving payment information.
 */
@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController<Payment> {
    /**
     * JsonTable for managing payment data storage.
     */
    @JsonAutowired(value = Payment.class, filepath = "src\\main\\java\\com\\raihanMuhammadIhsanJBusAF\\json\\payment.json")
    public static JsonTable<Payment> paymentTable;
    /**
     * Retrieves the JsonTable associated with the Payment class.
     *
     * @return The JsonTable for Payment.
     */
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }
    /**
     * Endpoint for making a booking and creating a payment.
     *
     * @param buyerId       The ID of the buyer's account.
     * @param renterId      The ID of the renter's account.
     * @param busId         The ID of the bus.
     * @param busSeats      The list of booked bus seats.
     * @param departureDate The timestamp of the departure date.
     * @return A BaseResponse containing information about the success or failure of the operation.
     */
    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List<String> busSeats,
            @RequestParam String departureDate
            )
    {
        try {
            Account buyer = Algorithm.<Account>find(new AccountController().getJsonTable(), t->t.id == buyerId);
            Bus bus = Algorithm.<Bus>find(new BusController().getJsonTable(), t->t.id == busId);
//            for(String s : busSeats){
//                for(int i = 0; i<busSeats.size(); i++) {
//                    if (s == busSeats.get(i)) {
//                        return new BaseResponse<>(false, "Gk bisa mesen yg sama cok!!", null);
//                    }
//                }
//            }
            if (buyer == null || bus == null){
                return new BaseResponse<>(false, "Akun atau Bus bernilai null!!", null);
            }
            if (buyer.balance < bus.price.price) {
                return new BaseResponse<>(false, "Uang gk cukup bro :'(!!", null);
            }
            if (!Algorithm.<Schedule>exists(bus.schedules, t->t.departureSchedule.equals(Timestamp.valueOf(departureDate)))) {
                return new BaseResponse<>(false, "Gk ada jadwal cuy!!", null);
            }
            if(!Payment.makeBooking(Timestamp.valueOf(departureDate), busSeats, bus)){
                return new BaseResponse<>(false, "Gagal make booking cuy!!", null);
            }
            else {
                Payment paymentTemp = new Payment(buyerId, renterId, busId, busSeats, Timestamp.valueOf(departureDate));
                paymentTemp.status = Invoice.PaymentStatus.WAITING;
                paymentTable.add(paymentTemp);
                Bus busTemp = Algorithm.<Bus>find(BusController.busTable, t -> t.id == paymentTemp.getBusId());
                Account tempAcc = Algorithm.<Account>find(AccountController.accountTable, t -> t.id == paymentTemp.buyerId);
                tempAcc.balance -= busTemp.price.price * paymentTemp.busSeats.size();
                return new BaseResponse<>(true, "Berhasil make booking!!", paymentTemp);
            }
        }catch (Exception e){
            return new BaseResponse<>(false, "Kesalahan dalam berfikir!!", null);
        }
    }
    /**
     * Endpoint for accepting a payment.
     *
     * @param id The ID of the payment to be accepted.
     * @return A BaseResponse containing information about the success or failure of the operation.
     */
    @RequestMapping(value = "/{id}/accept", method = RequestMethod.POST)
    public BaseResponse<Payment> accept(
            @PathVariable int id
    )
    {
        try {
            Payment paymentTemp = getById(id);
            paymentTemp.status = Invoice.PaymentStatus.SUCCESS;
            return new BaseResponse<>(true, "Berhasil mengubah status payment menjadi Success!!", paymentTemp);
        }catch (Exception e) {
            return new BaseResponse<>(false, "Terjadi kesalahan saat mengubah status payment!!", null);
        }
    }
    /**
     * Endpoint for canceling a payment.
     *
     * @param id The ID of the payment to be canceled.
     * @return A BaseResponse containing information about the success or failure of the operation.
     */
    @RequestMapping(value = "/{id}/cancel")
    public BaseResponse<Payment> cancel(
            @PathVariable int id
    )
    {
        try {
            Payment paymentTemp = getById(id);
            paymentTemp.status = Invoice.PaymentStatus.FAILED;
            Bus busTemp = Algorithm.<Bus>find(BusController.busTable, t->t.id == paymentTemp.getBusId());
            Account tempAcc = Algorithm.<Account>find(AccountController.accountTable, t->t.id == paymentTemp.buyerId);
            tempAcc.balance += busTemp.price.price * paymentTemp.busSeats.size();
            Schedule scheduleTemp = Algorithm.<Schedule>find(busTemp.schedules, s->s.departureSchedule.equals(paymentTemp.departureDate));
            for(String seat : paymentTemp.busSeats) {
                scheduleTemp.seatAvailability.replace(seat, true);
            }
            return new BaseResponse<>(true, "Berhasil mengcancel payment!!", paymentTemp);
        }catch (Exception e) {
            return new BaseResponse<>(false, "Terjadi kesalahan saat mengubah status payment!!", null);
        }
    }
    /**
     * Endpoint for retrieving a list of payments associated with a specific buyer.
     *
     * @param buyerId The ID of the buyer's account.
     * @return A list of payments associated with the specified buyer.
     */
    @GetMapping("/getMyPayment")
    public List<Payment> getMyPayment(@RequestParam int buyerId) {
        return Algorithm.<Payment>collect(getJsonTable(), b->b.buyerId == buyerId);
    }
    /**
     * Endpoint for retrieving a list of payments associated with a specific renter.
     *
     * @param renterId The ID of the renter's account.
     * @return A list of payments associated with the specified renter.
     */
    @GetMapping("/getMyOrder")
    public List<Payment> getMyOrder(@RequestParam int renterId) {
        return Algorithm.<Payment>collect(getJsonTable(), b->b.renterId == renterId);
    }
}
