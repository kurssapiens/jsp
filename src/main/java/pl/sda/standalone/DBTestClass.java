/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.sda.standalone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author marecki
 */
public class DBTestClass {
    public static void main(String[] args) {
        try {
            DBConnectionManager dbConectionManager = new DBConnectionManager("jdbc:mysql://localhost/books_db?serverTimezone=CET", "root", "a123456");
            Connection connection = dbConectionManager.getConnection();
            String sql = "SELECT id, first_name, last_name FROM books_table";
            ResultSet rs = null;
            Statement stmt = connection.createStatement();
            stmt.executeQuery(sql);
            rs = stmt.getResultSet();
            
            while (rs.next())
                System.out.println(rs.getInt("id") + " " + rs.getString("first_name") + " " + rs.getString("last_name"));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
}
