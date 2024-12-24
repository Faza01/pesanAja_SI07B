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
public class Produk {
    private String nama;
    private double harga;
    private String deskripsi;
    private boolean tersedia;

    public Produk(String nama, double harga, String deskripsi, boolean tersedia) {
        this.nama = nama;
        this.harga = harga;
        this.deskripsi = deskripsi;
        this.tersedia = tersedia;
    }

    public String getNama() {
        return nama;
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

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }

    public String getGambar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

