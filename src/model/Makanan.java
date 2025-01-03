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

    public Makanan(String namaMakanan, double harga, String deskripsi, boolean tersedia, String kategoriMakanan) throws ValidasiInputException {
        super(harga, deskripsi, tersedia);
        if (namaMakanan == null || namaMakanan.isEmpty()) {
            throw new ValidasiInputException("Nama makanan tidak boleh kosong.");
        }
        if (kategoriMakanan == null || kategoriMakanan.isEmpty()) {
            throw new ValidasiInputException("Kategori tidak boleh kosong.");
        }
        this.kategoriMakanan = kategoriMakanan;
        this.namaMakanan = namaMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public String getKategoriMakanan() {
        return kategoriMakanan;
    }
}
