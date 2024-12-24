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

    private double harga;
    private String deskripsi;
    private boolean tersedia;
    private byte[] gambar; // Tambahan untuk gambar

    public Produk(double harga, String deskripsi, boolean tersedia) {
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.tersedia = tersedia;
    }

    // Tambahan jika gambar diperlukan
//    public Produk(int id, String nama, double harga, String deskripsi, boolean tersedia, byte[] gambar) {
//        this(id, nama, harga, deskripsi, tersedia);
//        this.gambar = gambar;
//    }
    // Getter dan Setter
    public double getHarga() {
        return harga;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public byte[] getGambar() {
        return gambar;
    }

    public void setGambar(byte[] gambar) {
        this.gambar = gambar;
    }
    
    public abstract String getDetail();
}
