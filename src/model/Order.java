/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Order {
    private String idTransaksi;
    private User user;
    private List<Makanan> listMakanan;
    private List<Minuman> listMinuman;
    private double totalHarga;
    private Date waktuPembelian;
    private double potonganHarga;
    private String statusPesanan; // "Proses", "Batal", "Selesai"

    public Order(String idTransaksi, User user) {
        this.idTransaksi = idTransaksi;
        this.user = user;
        this.statusPesanan = "Proses";
    }
    
    public void tambahMakanan(Makanan makanan) {
        listMakanan.add(makanan);
    }
    
    public void tambahMinuman(Minuman minuman) {
        listMinuman.add(minuman);
    }
}
