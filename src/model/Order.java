/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Order {

    private String idTransaksi;
    private String user;
    private List<String> listNamaProduk;
    private List<Integer> listQty;
    private List<Double> listTotHarga;
    private double totalHarga;
    private double potonganHarga;
    private Date waktuPembelian;
    private String statusPesanan; // "Proses", "Batal", "Selesai"

    // Konstruktor
    public Order(String idTransaksi, String user) {
        this.idTransaksi = idTransaksi;
        this.user = user;
        this.listNamaProduk = new ArrayList<>();
        this.listQty = new ArrayList<>();
        this.listTotHarga = new ArrayList<>();
        this.statusPesanan = "Proses";
        this.totalHarga = 0;
        this.potonganHarga = 0;
        this.waktuPembelian = new Date(); // Set waktu pembelian default saat order dibuat
    }

    // Getter dan Setter
    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getListNamaProduk() {
        return listNamaProduk;
    }

    public List<Integer> getListQty() {
        return listQty;
    }

    public List<Double> getListTotHarga() {
        return listTotHarga;
    }

    public void setListNamaProduk(List<String> listNamaProduk) {
        this.listNamaProduk = listNamaProduk;
    }

    public void setListQty(List<Integer> listQty) {
        this.listQty = listQty;
    }

    public void setListTotHarga(List<Double> listTotHarga) {
        this.listTotHarga = listTotHarga;
    }

    public Date getWaktuPembelian() {
        return waktuPembelian;
    }

    public void setWaktuPembelian(Date waktuPembelian) {
        this.waktuPembelian = waktuPembelian;
    }

    public String getStatusPesanan() {
        return statusPesanan;
    }

    public void setStatusPesanan(String statusPesanan) {
        this.statusPesanan = statusPesanan;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public void setPotonganHarga(double potonganHarga) {
        this.potonganHarga = potonganHarga;
    }

    public double getPotonganHarga() {
        return potonganHarga;
    }
}
