/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jsphello.data;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author gribu
 */
public class DataInsert {
    Connection connection; 
    public DataInsert (Connection c){
        this.connection = c ;   
    }   
    public boolean insertAuthor(String first_name, String last_name, String middle_name) {
        try {
            String insertSql = "insert into Author (first_name, last_name, middle_name) values (?,?,?)" ;
            PreparedStatement stmnt = connection.prepareStatement(insertSql) ;
            stmnt.setString(1,first_name);
            stmnt.setString(2,last_name);
            stmnt.setString(3,middle_name);
            stmnt.executeUpdate();
            System.out.println("Author added");
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
