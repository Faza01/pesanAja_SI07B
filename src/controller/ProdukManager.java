package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
import java.util.ArrayList;
import model.Produk;

public class ProdukManager {

    private ArrayList<Produk> daftarProduk = new ArrayList<>();

    public void tambahProduk(Produk produk) {
        daftarProduk.add(produk);
    }

    public ArrayList<Produk> getDaftarProduk() {
        return daftarProduk;
    }
}
