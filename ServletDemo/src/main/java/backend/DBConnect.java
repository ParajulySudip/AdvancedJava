package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBConnect {
    public static Connection connect() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/inventorydb";
            String username="root";
            String password="";
            Connection con= DriverManager.getConnection(url,username,password);
            return con;
    }
}