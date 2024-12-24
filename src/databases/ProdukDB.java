/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Makanan;
import model.Minuman;
import model.Produk;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class ProdukDB {

    public List<Makanan> getAllMakanan() throws SQLException {
        List<Makanan> makananList = new ArrayList<>();
        Connection conn = db_connection.getConnection();
        String query = "SELECT * FROM produk WHERE tipeProduk = 'makanan'";

        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nama = rs.getString("namaProduk");
            String deskripsi = rs.getString("deskripsi");
            double harga = rs.getDouble("harga");
            boolean tersedia = rs.getBoolean("ketersediaan");
            String kategoriMakanan = rs.getString("kategoriMakanan");

            makananList.add(new Makanan(nama, harga, deskripsi, tersedia, kategoriMakanan));
        }

        return makananList;
    }

    public List<Minuman> getAllMinuman() throws SQLException {
        List<Minuman> minumanList = new ArrayList<>();
        Connection conn = db_connection.getConnection();
        String query = "SELECT * FROM produk WHERE tipeProduk = 'minuman'";

        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            String nama = rs.getString("namaProduk");
            String deskripsi = rs.getString("deskripsi");
            double harga = rs.getDouble("harga");
            boolean tersedia = rs.getBoolean("ketersediaan");
            String penyajian = rs.getString("penyajian");

            minumanList.add(new Minuman(nama, harga, deskripsi, tersedia, penyajian));
        }

        return minumanList;
    }
}
