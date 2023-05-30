//Crate a html form to insert username and password then create a servlet to accept that request from post method. 
//Write java code to store those data into tbl_user table of ‘db_asian’ database.
package Lab2;
/**
 *
 * @author Sudip
 */
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegistrationServlet extends HttpServlet {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_asian";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Database connection and insertion
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO tbl_user (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();

            response.setContentType("text/html");
            response.getWriter().println("Registration successful!");
        } catch (SQLException e) {
            response.setContentType("text/html");
            response.getWriter().println("An error occurred during registration.");
        }
    }
}
