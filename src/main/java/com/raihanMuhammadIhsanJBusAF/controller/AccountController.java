package com.raihanMuhammadIhsanJBusAF.controller;

import com.raihanMuhammadIhsanJBusAF.Account;
import com.raihanMuhammadIhsanJBusAF.Algorithm;
import com.raihanMuhammadIhsanJBusAF.Renter;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonAutowired;
import com.raihanMuhammadIhsanJBusAF.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The {@code AccountController} class is a Spring REST controller responsible for handling account-related operations, such as registration, login, top-up, and payment.
 *
 * <p>This controller includes methods for registering an account, logging in, registering a renter associated with an account, and performing top-up and payment transactions.</p>
 *
 * @RestController annotation indicates that this class is a Spring MVC controller.
 * @RequestMapping("/account") sets the base URL path for all mappings in this class.
 * @Author Raihan Muhammad Ihsan
 * @version 1.0.0
 */
@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{

    @JsonAutowired(value = Account.class, filepath = "src\\main\\java\\com\\raihanMuhammadIhsanJBusAF\\json\\account.json")
    public static JsonTable<Account> accountTable;

    @GetMapping
    String index() { return "account page"; }
    /**
     * Registers a new account.
     *
     * @param name     the name of the account
     * @param email    the email of the account
     * @param password the password of the account
     * @return a BaseResponse containing the registration result and the created account if successful
     */
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
        if(!acc.name.isBlank() && acc.validate() && !Algorithm.<Account>exists(getJsonTable(), t -> t.email.equals(acc.email))){
            accountTable.add(responseAcc);
            return new BaseResponse<Account>(true, "Register Berhasil!", responseAcc);
        }
        return new BaseResponse<Account>(false, "Gagal register", null);
    }
    /**
     * Logs in an existing account.
     *
     * @param email    the email of the account
     * @param password the password of the account
     * @return a BaseResponse containing the login result and the logged-in account if successful
     */
    @PostMapping("/login")
    BaseResponse<Account> login(
            @RequestParam String email,
            @RequestParam String password
    ){
        String encyptedPassword = null;
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < bytes.length; i++){
                sb.append((Integer.toString((bytes[i] & 0xff)+ 0x100, 16).substring(1)));
            }
            encyptedPassword = sb.toString();
        }catch(NoSuchAlgorithmException e){
            e.printStackTrace();
        }
        Account acc = new Account(null, email, encyptedPassword);
        if (
                Algorithm.<Account>exists(getJsonTable(), akun -> akun.email.equals(acc.email)
                        && akun.password.equals(acc.password))
        ) {
            return new BaseResponse<Account>(true, "Berhasil Login Cuyy!!", Algorithm.<Account>find(getJsonTable(), akun -> akun.email.equals(acc.email)));
        }
        return new BaseResponse<Account>(false, "Gagal Login", null);
    }


    @Override
    public JsonTable<Account> getJsonTable() {
        return this.accountTable;
    }
    /**
     * Registers a new renter associated with the specified account.
     *
     * @param id           the ID of the account to associate the renter with
     * @param companyName  the name of the renter's company
     * @param address      the address of the renter
     * @param phoneNumber  the phone number of the renter
     * @return a BaseResponse containing the registration result and the created renter if successful
     */
    @PostMapping("/{id}/registerRenter")
    BaseResponse<Renter> registerRenter(
            @PathVariable int id,
            @RequestParam String companyName,
            @RequestParam String address,
            @RequestParam String phoneNumber
    ){
        Account account = Algorithm.<Account>find(accountTable, acc -> acc.id == id);
        if (account != null && account.company == null) {
            Renter renter = new Renter(companyName, phoneNumber, address);
            account.company = renter;
            return new BaseResponse<>(true, "Renter berhasil dibuat", renter);
        }
        return new BaseResponse<>(false, "Renter Gagal dibuat", null);
    }
    /**
     * Performs a top-up transaction for the specified account.
     *
     * @param id     the ID of the account to perform the top-up
     * @param amount the amount to be added to the account balance
     * @return a BaseResponse containing the top-up result and the updated account balance if successful
     */
    @PostMapping("/{id}/topUp")
    BaseResponse<Double> topUp(
            @PathVariable int id,
            @RequestParam double amount
    ){
        Account accTopUp = Algorithm.<Account>find(accountTable, t->t.id == id);
        if(accTopUp == null || amount <= 0) {
            return new BaseResponse<>(false, "TopUp Gagal", null);
        }
        accTopUp.topUp(amount);
        return new BaseResponse<>(true, "Berhasil TopUp", amount);
    }

    //@GetMapping("/{id}")
    //String getById(@PathVariable int id) { return "account id " + id + " not found!"; }
}
