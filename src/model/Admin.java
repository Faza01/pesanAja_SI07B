/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Admin extends User {

    public Admin(String username, String password) throws ValidasiInputException {
        super(username, password, "admin");
    }

    // Method tambahan untuk Admin
    public void viewOrder() {
        System.out.println("Admin melihat daftar order.");
    }

    public void updateStatusOrder() {
        System.out.println("Admin mengupdate status order.");
    }

    public void createProduk() {
        System.out.println("Admin membuat produk baru.");
    }

    public void updateProduk() {
        System.out.println("Admin mengupdate produk.");
    }

    public void deleteProduk() {
        System.out.println("Admin menghapus produk.");
    }

    public void setKetersediaanProduk() {
        System.out.println("Admin mengatur ketersediaan produk.");
    }
}
