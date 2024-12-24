/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package databases;

import java.sql.*;
import java.util.ArrayList;
import model.Order;
import java.util.List;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class OrderDB {

    public static void saveOrder(Order order) {
        String insertOrderQuery = "INSERT INTO orders (id_transaksi, username, total_harga, potongan_harga, waktu_pembelian, status_pesanan) VALUES (?, ?, ?, ?, ?, ?)";
        String insertOrderItemsQuery = "INSERT INTO order_item (id_transaksi, nama_produk, qty, total_harga) VALUES (?, ?, ?, ?)";

        try (Connection conn = db_connection.getConnection()) {
            // Menyimpan data ke tabel orders
            try (PreparedStatement stmt = conn.prepareStatement(insertOrderQuery)) {
                stmt.setString(1, order.getIdTransaksi());
                stmt.setString(2, order.getUser()); // Asumsi user memiliki metode getId()
                stmt.setDouble(3, order.getTotalHarga());
                stmt.setDouble(4, order.getPotonganHarga());
                stmt.setTimestamp(5, new Timestamp(order.getWaktuPembelian().getTime())); // Mengonversi Date menjadi Timestamp
                stmt.setString(6, order.getStatusPesanan());
                stmt.executeUpdate();
            }

            // Menyimpan data ke tabel order_items
            try (PreparedStatement stmt = conn.prepareStatement(insertOrderItemsQuery)) {
                List<String> namaProdukList = order.getListNamaProduk();
                List<Integer> qtyList = order.getListQty();
                List<Double> totHargaList = order.getListTotHarga();

                for (int i = 0; i < namaProdukList.size(); i++) {
                    stmt.setString(1, order.getIdTransaksi());
                    stmt.setString(2, namaProdukList.get(i));
                    stmt.setInt(3, qtyList.get(i));
                    stmt.setDouble(4, totHargaList.get(i));
                    stmt.addBatch(); // Menambahkan ke batch
                }
                stmt.executeBatch(); // Menjalankan batch insert
            }

            System.out.println("Order berhasil disimpan ke database!");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat menyimpan order: " + e.getMessage());
        }
    }

    public List<Order> getOrders(String username, String role) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        boolean hasCondition = false;

        // Tambahkan filter jika username diberikan
        if (username != null && role != "admin") {
            sql += " WHERE username = ?";
            hasCondition = true;
        }

        try (Connection conn = db_connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Set parameter jika ada username
            if (hasCondition) {
                stmt.setString(1, username);
            }

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Order order = new Order(
                        rs.getString("id_transaksi"),
                        rs.getString("username")
                );
                order.setTotalHarga(rs.getDouble("total_harga"));
                order.setPotonganHarga(rs.getDouble("potongan_harga"));
                order.setWaktuPembelian(rs.getDate("waktu_pembelian"));
                order.setStatusPesanan(rs.getString("status_pesanan"));
                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

}
