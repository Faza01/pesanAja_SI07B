/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
abstract class Produk {
    protected String deskripsi;
    protected double harga;
    protected boolean ketersediaan;

    public Produk(String deskripsi, double harga, boolean ketersediaan) {
        this.deskripsi = deskripsi;
        this.harga = harga;
        this.ketersediaan = ketersediaan;
    }
    
    public void getDetailProduk() {
        System.out.println("Detail Produk: " + deskripsi + ", Harga: " + harga + ", Tersedia: " + ketersediaan);
    }
    
    public void getCariProduk() {
        System.out.println("Mencari produk...");
    }
}
