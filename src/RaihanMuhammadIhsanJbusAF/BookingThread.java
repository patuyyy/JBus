package raihanMuhammadIhsanJBusAF;

import java.sql.Timestamp;

public class BookingThread extends Thread{

    private Bus bus;
    private Timestamp timestamp;
    int i;
    public BookingThread(String name, Bus bus, Timestamp timestamp) {
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }

    public void run() {
        System.out.println(
                Thread.currentThread().getName() + " ID : " + Thread.currentThread().getId() + " is running"
        );
        synchronized(bus) {
            if(Payment.makeBooking(this.timestamp, "AF01", this.bus)) {
                System.out.println("Thread " + Thread.currentThread().getId() + " Berhasil Melakukan Booking");
            }
            else {
                System.out.println("Thread " + Thread.currentThread().getId() + " Gagal Melakukan Booking");
            }
        }
    }
}
