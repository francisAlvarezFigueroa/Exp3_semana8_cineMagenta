/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 

/**
 *
 * @author Francis
 */
public class DBConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/cinedb";
    
    private static final String USER = "root"; 
    
    private static final String PASS = "root";
    
    public static Connection getConnection () throws SQLException {
        Connection connect = DriverManager.getConnection(URL, USER, PASS); 
        System.out.println("Connection to database has been established");
        return connect; 
    }
}
