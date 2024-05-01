/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jsphello.data;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gribu
 */
public class DataExtractor {

    Connection connection;

    public DataExtractor(Connection c) {
        this.connection = c;
    }

    public ArrayList<Author> getData() {
        ArrayList<Author> result = new ArrayList();
        String selectTableSQL = "SELECT * from author;";
        Statement stmnt;
        ResultSet rs;
        try {
            stmnt = connection.createStatement();
            rs = stmnt.executeQuery(selectTableSQL);
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String middle_name = rs.getString("middle_name");
                Author item = new Author(id, first_name, last_name, middle_name);
                result.add(item);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
