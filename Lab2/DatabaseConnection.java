/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab2;

/**
 *
 * @author Sudip
 */
//QN1)WAP to make connection with database. Make your own assumptions about database.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Connection successful! Perform database operations here...

            // Close the connection
            connection.close();
        } catch (SQLException e) {
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                }
            }
        }
    }
}
