package com.raihanMuhammadIhsanJBusAF.controller;

import com.raihanMuhammadIhsanJBusAF.Account;
import com.raihanMuhammadIhsanJBusAF.Algorithm;
import com.raihanMuhammadIhsanJBusAF.Renter;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonAutowired;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;





@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    @GetMapping
    String index() { return "account page"; }
    @JsonAutowired(value = Account.class, filepath = "D:\\Kuliah\\23.24 Gasal\\OOP Praktikum - 02\\GitLocal\\JBus\\src\\main\\java\\com\\raihanMuhammadIhsanJBusAF\\json\\account.json")
    public static JsonTable<Account> accountTable;
    @PostMapping("/register")
    BaseResponse<Account> register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        String encyptedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encyptedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Account acc = new Account(name, email, password);
        Account responseAcc = new Account(name, email, encyptedPassword);
        if(!acc.name.isBlank() && acc.validate() && !Algorithm.<Account>exists(getJsonTable(), t -> t.email == acc.email)){
            accountTable.add(responseAcc);
            return new BaseResponse<Account>(true, "Register Berhasil!", responseAcc);
        }
        return new BaseResponse<Account>(false, "Gagal register", null);
    }

    @PostMapping("/login")
    BaseResponse<Account> login
            (
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        String encyptedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encyptedPassword = sb.toString();
        }catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        Account acc = new Account(null, email, encyptedPassword);
        if(Algorithm.<Account>exists(getJsonTable(), t -> t.email == acc.email) &&
        Algorithm.<Account>exists(getJsonTable(), t -> t.password == acc.password)) {
            return new BaseResponse<Account>(true, "Berhasil Login", Algorithm.<Account>find(getJsonTable(), t -> t.email == email));
        }
        return new BaseResponse<Account>(false, "Gagal Login", null);
    }


    @Override
    public JsonTable<Account> getJsonTable() {
        return this.accountTable;
    }

    @PostMapping("/{id}/registerRenter")
    BaseResponse<Renter> registerRenter(
            @PathVariable int id,
            @RequestParam String companyName,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ) {
        if(Algorithm.<Account>exists(getJsonTable(), t->t.id == id && t.company == null)){
            Renter rent = new Renter(companyName,address,phoneNumber);
            return new BaseResponse<Renter>(true, "Register Renter berhasil", rent);
        }
        return new BaseResponse<Renter>(false, "Gagal Register Renter", null);
    }

    @PostMapping("/{id}/topUp")
    BaseResponse<Double> topUp(
            @PathVariable int id,
            @RequestParam double amount
    ){
        if(Algorithm.<Account>exists(getJsonTable(), t->t.id == id && t.topUp(amount))) {
            return new BaseResponse<>(true, "Berhasil TopUp", amount);
        }
        return new BaseResponse<>(false, "TopUp Gagal", null);
    }


    //@GetMapping("/{id}")
    //String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}
