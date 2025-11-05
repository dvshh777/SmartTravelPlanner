package travel.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    
    public Conn() {
        try {
            // FIX 1: Using the correct, modern JDBC driver class name
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
            // FIX 2: Connection URL, User is 'root', and the password is an EMPTY STRING ("") 
            // This is crucial for XAMPP's default setup to fix the "Access denied" error.
            // Ensure 'travelmanagementsystem' is the exact name of the database you created in phpMyAdmin.
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementsystem", "root", ""); 
            
            s = c.createStatement();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}