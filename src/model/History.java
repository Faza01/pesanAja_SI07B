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
public class History {

    private String idHistory;
    private String idTransaksi;
    private User user;
    private List<String> listPesanan;
    private double totalHarga;
    private Date waktuPesanan;

    // Constructor
    public History(String idHistory, String idTransaksi, User user, List<String> listPesanan, double totalHarga, Date waktuPesanan) {
        this.idHistory = idHistory;
        this.idTransaksi = idTransaksi;
        this.user = user;
        this.listPesanan = listPesanan;
        this.totalHarga = totalHarga;
        this.waktuPesanan = waktuPesanan;
    }

    // Method untuk mendapatkan histori
    public void getHistory() {
        System.out.println("ID History: " + idHistory);
        System.out.println("ID Transaksi: " + idTransaksi);
        System.out.println("User: " + user.getUsername());
        System.out.println("Daftar Pesanan: " + listPesanan);
        System.out.println("Total Harga: " + totalHarga);
        System.out.println("Waktu Pesanan: " + waktuPesanan);
    }

    // Method untuk mencari histori
    public void cariHistory(String idTransaksi) {
        if (this.idTransaksi.equals(idTransaksi)) {
            System.out.println("History ditemukan:");
            getHistory();
        } else {
            System.out.println("History dengan ID Transaksi " + idTransaksi + " tidak ditemukan.");
        }
    }

    // Getter dan Setter
    public String getIdHistory() {
        return idHistory;
    }

    public void setIdHistory(String idHistory) {
        this.idHistory = idHistory;
    }
}
