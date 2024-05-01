/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jsphello.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gribu
 */
public class Database {

    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("driver found");
        } catch (Exception e) {
            System.out.println("driver not found");
        }
    }
    private String database_url = "jdbc:mysql://127.0.0.1/library?characterEncoding=utf8";
    private String un = "root";
    private String psw = "Alex2004";

    public Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(database_url, un, psw);
            System.out.println("connection ok");
            return conn;
        } catch (SQLException ex) {
            System.out.println("connection failed");
            return null;
        }
    }

}
