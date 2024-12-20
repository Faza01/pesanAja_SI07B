/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Makanan extends Produk {
    private String namaMakanan;

    public Makanan(String namaMakanan, String deskripsi, double harga, boolean ketersediaan) {
        super(deskripsi, harga, ketersediaan);
        this.namaMakanan = namaMakanan;
    }
}
