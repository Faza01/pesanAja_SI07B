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

    }

    public void updateStatusOrder() {

    }

    public void createProduk() {

    }

    public void updateProduk() {

    }

    public void deleteProduk() {

    }

    public void setKetersediaanProduk() {

    }
}
