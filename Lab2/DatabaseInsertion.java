/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Lab2;
//Write a program to insert data into database using crateStatement() and also using preparedStatement.
/**
 *
 * @author Sudip
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class DatabaseInsertion {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Establish the database connection
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

            // Insert data using createStatement()
            insertDataWithCreateStatement(connection);

            // Insert data using prepareStatement()
            insertDataWithPrepareStatement(connection);

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

    private static void insertDataWithCreateStatement(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();

        String sql = "INSERT INTO employees (name, age, salary) VALUES ('John Doe', 30, 5000)";
        statement.executeUpdate(sql);

        System.out.println("Data inserted successfully using createStatement().");
    }

    private static void insertDataWithPrepareStatement(Connection connection) throws SQLException {
        String sql = "INSERT INTO employees (name, age, salary) VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, "Jane Smith");
        preparedStatement.setInt(2, 35);
        preparedStatement.setInt(3, 6000);
        preparedStatement.executeUpdate();

        System.out.println("Data inserted successfully using prepareStatement().");
    }
}
