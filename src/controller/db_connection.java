/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;

/**
 *
 * @author Faza Bilwildi Emyu_2311103083_SI-07-B
 */
public class db_connection {
    static final String URL ="jdbc:mysql://localhost:3306/pesan_aja";
    static final String USER ="root";
    static final String PASSWORD ="";
    
    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

