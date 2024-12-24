/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import databases.db_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class Costumer extends User {

    private String namaLengkap;
    private String noTelp;
    private Date ttl;
    private String jenisKelamin; // "Laki-laki" atau "Perempuan"

    public Costumer(String username, String password, String namaLengkap, String noTelp, Date ttl, String jenisKelamin) throws ValidasiInputException {
        super(username, password, "costumer");

        // Validasi input
        if (namaLengkap == null || namaLengkap.isEmpty()) {
            throw new ValidasiInputException("Nama lengkap tidak boleh kosong.");
        }
        if (!noTelp.matches("\\d{12}")) {
            throw new ValidasiInputException("Nomor telepon berjumlah 12 angka");
        }
        if (!jenisKelamin.equalsIgnoreCase("Laki-laki") && !jenisKelamin.equalsIgnoreCase("Perempuan")) {
            throw new ValidasiInputException("Jenis kelamin harus 'Laki-laki' atau 'Perempuan'.");
        }
        if (ttl == null) {
            throw new ValidasiInputException("Tanggal lahir tidak boleh kosong.");
        }

        // Validasi usia minimal 17 tahun
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(ttl);
        int birthYear = calendar.get(Calendar.YEAR);

        // Hitung usia berdasarkan tahun, bulan, dan hari
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

        // Jika usia kurang dari 17 tahun
        int age = currentYear - birthYear;
        if (age < 17) {
            throw new ValidasiInputException("Usia minimal adalah 17 tahun.");
        }

        if (ttl.after(new Date())) {
            throw new ValidasiInputException("Tanggal lahir tidak boleh lebih dari tanggal saat ini.");
        }

        this.namaLengkap = namaLengkap;
        this.noTelp = noTelp;
        this.ttl = ttl;
        this.jenisKelamin = jenisKelamin;
    }

    // Getter dan Setter
    public String getNama() {
        return namaLengkap;
    }

    public java.util.Date getTtl() {
        return ttl;
    }

    @Override
    public boolean register() {

        try (Connection conn = db_connection.getConnection();) {

            String sql = "INSERT INTO user (username, password, role, nama_lengkap, no_telp, TTL, jenis_kelamin) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, getUsername());
            stmt.setString(2, getPassword());
            stmt.setString(3, "costumer");
            stmt.setString(4, namaLengkap);
            stmt.setString(5, noTelp);
            stmt.setDate(6, new java.sql.Date(ttl.getTime()));
            stmt.setString(7, jenisKelamin);
            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException("Gagal melakukan registrasi: " + e.getMessage(), e);
        }

    }
}
