/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public abstract class Produk {

    protected int idProduk;
    protected double harga;
    protected String deskripsi;
    protected boolean tersedia;
    protected String gambar; // Tambahan untuk gambar

    public Produk(double harga, String deskripsi, boolean tersedia) throws ValidasiInputException {
        if (harga <= 0) {
            throw new ValidasiInputException("Harga produk harus lebih besar dari 0.");
        }
        if (deskripsi == null || deskripsi.isEmpty()) {
            throw new ValidasiInputException("Deskripsi produk tidak boleh kosong.");
        }
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.tersedia = tersedia;
    }

    public double getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }
}
