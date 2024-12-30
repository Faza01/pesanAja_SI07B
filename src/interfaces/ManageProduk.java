/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import model.Produk;
import model.ValidasiInputException;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public interface ManageProduk {

    // Create
    void tambahProduk(Produk produk) throws ValidasiInputException;

    //read
    List<Produk> semuaProduk();

    // Update
    void updateProduk(Produk produk, int id) throws ValidasiInputException;

    // Delete
    void hapusProdukById(int id);
}
