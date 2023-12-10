# JBus Backend

Jbus adalah sebuah aplikasi pemesanaan bus berbasis android yang dikembangkan dalam bahasa java yang berfungsi sebagai. JBus menerapkan pengaplikasian sederhana dari pengelolaan database. Database yang digunakan adalah JSON. JBus backend ini merupakan program yang digunakan pada backend aplikasi JBus

## Purpose

Berfungsi untuk mengelola database pada backend agar semua data yang dikirim ataupun dibutuhkan oleh frontend dapat diproses dengan baik.


## Sample Code

```java
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
```

## Purpose of project

Dibuat sebagai proyek untuk mata kuliah Object Oriented Programming jurusan Teknik Komputer Universitas Indonesia.


## Creator Information

[Raihan Muhammad Ihsan](https://www.linkedin.com/in/raihan-muhammad-ihsan-4b9480268/)
