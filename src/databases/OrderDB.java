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

    public List<Order> getOrders(String username, String role, String statusPesanan) {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        boolean hasCondition = false;

        // Tambahkan filter jika username atau statusPesanan diberikan
        if (username != null && !role.equalsIgnoreCase("admin")) {
            sql += " WHERE username = ?";
            hasCondition = true;
        }

        if (statusPesanan != null && !statusPesanan.isEmpty()) {
            if (hasCondition) {
                sql += " AND status_pesanan = ?";
            } else {
                sql += " WHERE status_pesanan = ?";
            }
            hasCondition = true;
        }

        try (Connection conn = db_connection.getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(sql);

            int paramIndex = 1;

            // Set parameter jika ada username
            if (username != null && !role.equalsIgnoreCase("admin")) {
                stmt.setString(paramIndex++, username);
            }

            // Set parameter jika ada statusPesanan
            if (statusPesanan != null && !statusPesanan.isEmpty()) {
                stmt.setString(paramIndex++, statusPesanan);
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

    public Order getDetailOrder(String idTransaksi) {
        Order order = null;

        String orderQuery = "SELECT * FROM orders WHERE id_transaksi = ?";
        String orderItemsQuery = "SELECT * FROM order_item WHERE id_transaksi = ?";

        try (Connection conn = db_connection.getConnection()) {
            // Ambil data dari tabel orders
            try (PreparedStatement stmt = conn.prepareStatement(orderQuery)) {
                stmt.setString(1, idTransaksi);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    order = new Order(
                            rs.getString("id_transaksi"),
                            rs.getString("username")
                    );
                    order.setTotalHarga(rs.getDouble("total_harga"));
                    order.setPotonganHarga(rs.getDouble("potongan_harga"));
                    order.setWaktuPembelian(rs.getTimestamp("waktu_pembelian"));
                    order.setStatusPesanan(rs.getString("status_pesanan"));
                }
            }

            // Jika order ditemukan, ambil item-itemnya
            if (order != null) {
                List<String> namaProdukList = new ArrayList<>();
                List<Integer> qtyList = new ArrayList<>();
                List<Double> totHargaList = new ArrayList<>();

                try (PreparedStatement stmt = conn.prepareStatement(orderItemsQuery)) {
                    stmt.setString(1, idTransaksi);
                    ResultSet rs = stmt.executeQuery();

                    while (rs.next()) {
                        namaProdukList.add(rs.getString("nama_produk"));
                        qtyList.add(rs.getInt("qty"));
                        totHargaList.add(rs.getDouble("total_harga"));
                    }
                }

                order.setListNamaProduk(namaProdukList);
                order.setListQty(qtyList);
                order.setListTotHarga(totHargaList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat mengambil detail order: " + e.getMessage());
        }

        return order;
    }

    public void updateStatusOrder(String idTransaksi, String statusPesanan) {
        String sql = "UPDATE orders SET status_pesanan = ? WHERE id_transaksi = ?";

        try (Connection conn = db_connection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            // Mengatur parameter
            stmt.setString(1, statusPesanan);
            stmt.setString(2, idTransaksi);

            // Menjalankan perintah update
            int rowsUpdated = stmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Status pesanan berhasil diperbarui untuk id_transaksi: " + idTransaksi);
            } else {
                System.out.println("Tidak ada pesanan yang diperbarui untuk id_transaksi: " + idTransaksi);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Terjadi kesalahan saat memperbarui status pesanan: " + e.getMessage());
        }
    }

}
