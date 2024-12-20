/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Minuman extends Produk {
    private String namaMinuman;

    public Minuman(String namaMinuman, String deskripsi, double harga, boolean ketersediaan) {
        super(deskripsi, harga, ketersediaan);
        this.namaMinuman = namaMinuman;
    }
}
