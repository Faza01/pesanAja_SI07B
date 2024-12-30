/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databases;

import interfaces.ManageProduk;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Makanan;
import model.Minuman;
import model.Produk;
import model.ValidasiInputException;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class ProdukDB implements ManageProduk {

    @Override
    public void tambahProduk(Produk produk) throws ValidasiInputException {
        String sql = "INSERT INTO produk (namaProduk, deskripsi, harga, ketersediaan, tipeProduk, kategoriMakanan, penyajian, gambarProduk) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = db_connection.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, produk instanceof Makanan ? ((Makanan) produk).getNamaMakanan() : ((Minuman) produk).getNamaMinuman());
            st.setString(2, produk.getDeskripsi());
            st.setDouble(3, produk.getHarga());
            st.setBoolean(4, produk.isTersedia());
            st.setString(5, produk instanceof Makanan ? "makanan" : "minuman");
            st.setString(6, produk instanceof Makanan ? ((Makanan) produk).getKategoriMakanan() : "-");
            st.setString(7, produk instanceof Minuman ? ((Minuman) produk).getPenyajian() : "-");
            st.setString(8, produk.getGambar());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saat menambahkan produk: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Produk> semuaProduk() {
        String sql = "SELECT * FROM produk";
        List<Produk> produkList = new ArrayList<>();
        try (Connection conn = db_connection.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                produkList.add(produkFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error saat mendapatkan semua produk: " + e.getMessage(), e);
        } catch (ValidasiInputException e) {
            e.getMessage();
        }
        return produkList;
    }

    @Override
    public void updateProduk(Produk produk, int idProduk) throws ValidasiInputException {
        String sql = "UPDATE produk SET namaProduk = ?, deskripsi = ?, harga = ?, ketersediaan = ?, tipeProduk = ?, kategoriMakanan = ?, penyajian = ?, gambarProduk = ? WHERE id_produk = ?";

        try (Connection conn = db_connection.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, produk instanceof Makanan ? ((Makanan) produk).getNamaMakanan() : ((Minuman) produk).getNamaMinuman());
            st.setString(2, produk.getDeskripsi());
            st.setDouble(3, produk.getHarga());
            st.setBoolean(4, produk.isTersedia());
            st.setString(5, produk instanceof Makanan ? "makanan" : "minuman");
            st.setString(6, produk instanceof Makanan ? ((Makanan) produk).getKategoriMakanan() : "-");
            st.setString(7, produk instanceof Minuman ? ((Minuman) produk).getPenyajian() : "-");
            st.setString(8, produk.getGambar());
            st.setInt(9, idProduk); // Pastikan idProduk digunakan untuk update yang tepat

            st.executeUpdate();
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    @Override
    public void hapusProdukById(int id) {
        String sql = "DELETE FROM produk WHERE id_produk = ?";
        try (Connection conn = db_connection.getConnection()) {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error saat menghapus produk: " + e.getMessage(), e);
        }
    }

    private Produk produkFromResultSet(ResultSet rs) throws SQLException, ValidasiInputException {
        String tipe = rs.getString("tipeProduk");
        if ("makanan".equalsIgnoreCase(tipe)) {
            Makanan makanan = new Makanan(
                    rs.getString("namaProduk"),
                    rs.getDouble("harga"),
                    rs.getString("deskripsi"),
                    rs.getBoolean("ketersediaan"),
                    rs.getString("kategoriMakanan")
            );
            makanan.setIdProduk(rs.getInt("id_produk"));
            makanan.setGambar(rs.getString("gambarProduk"));
            return makanan;
        } else if ("minuman".equalsIgnoreCase(tipe)) {
            Minuman minuman = new Minuman(
                    rs.getString("namaProduk"),
                    rs.getDouble("harga"),
                    rs.getString("deskripsi"),
                    rs.getBoolean("ketersediaan"),
                    rs.getString("penyajian")
            );
            minuman.setIdProduk(rs.getInt("id_produk"));
            minuman.setGambar(rs.getString("gambarProduk"));
            return minuman;
        }
        throw new IllegalArgumentException("Tipe produk tidak dikenal: " + tipe);
    }
}
