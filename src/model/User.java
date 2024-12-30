/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import databases.db_connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public abstract class User {

    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) throws ValidasiInputException {
        if (username == null || username.isEmpty()) {
            throw new ValidasiInputException("Username tidak boleh kosong!");
        }
        if (password == null || password.isEmpty()) {
            throw new ValidasiInputException("Password tidak boleh kosong!");
        }

        this.username = username;
        this.password = password;
        this.role = role;
    }

    // Getter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String login() throws SQLException {

        try (Connection conn = db_connection.getConnection()) {
            String sql = "SELECT role FROM user WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    this.role = rs.getString("role");
                    return this.role;
                }
                return null;
            }
        }
    }

    public User getCurrentUser(String username) throws ValidasiInputException {
        try (Connection conn = db_connection.getConnection()) {
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Tentukan tipe user berdasarkan role
                String role = rs.getString("role");
                String password = rs.getString("password");

                if ("admin".equalsIgnoreCase(role)) {
                    return new Admin(
                            username,
                            password
                    );
                } else if ("costumer".equalsIgnoreCase(role)) {
                    return new Costumer(
                            username,
                            password,
                            rs.getString("nama_lengkap"),
                            rs.getString("no_telp"),
                            rs.getDate("ttl"),
                            rs.getString("jenis_kelamin")
                    );
                } else {
                    throw new ValidasiInputException("Role tidak dikenali: " + role);
                }
            } else {
                throw new ValidasiInputException("User dengan username '" + username + "' tidak ditemukan.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ValidasiInputException("Terjadi kesalahan saat mengakses database: " + e.getMessage());
        }
    }

    public boolean register() {
        return false;
    }
}
