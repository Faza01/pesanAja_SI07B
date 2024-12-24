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
    private String kategoriMakanan; // pembuka, utama, penutup

    public Makanan(String namaMakanan, double harga, String deskripsi, boolean tersedia, String kategoriMakanan) {
        super(harga, deskripsi, tersedia);
        this.kategoriMakanan = kategoriMakanan;
        this.namaMakanan = namaMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getKategoriMakanan() {
        return kategoriMakanan;
    }

    @Override
    public String getDetail() {
        return "Makanan: " + namaMakanan + ", Kategori Makanan: " + kategoriMakanan;
    }
}
