
package Lab2;
//Write a servlet code to retrieve data from database and display them into html table.
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataDisplayServlet extends HttpServlet {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/db_asian";
    private static final String USERNAME = "your_username";
    private static final String PASSWORD = "your_password";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve data from the database
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD)) {
            String sql = "SELECT * FROM tbl_user";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            // Generate HTML table dynamically
            StringBuilder tableHtml = new StringBuilder();
            tableHtml.append("<table border='1'>");
            tableHtml.append("<tr><th>ID</th><th>Username</th><th>Password</th></tr>");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                tableHtml.append("<tr>");
                tableHtml.append("<td>").append(id).append("</td>");
                tableHtml.append("<td>").append(username).append("</td>");
                tableHtml.append("<td>").append(password).append("</td>");
                tableHtml.append("</tr>");
            }
            tableHtml.append("</table>");

            // Set the HTML response
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>User Data</h2>");
            response.getWriter().println(tableHtml.toString());
            response.getWriter().println("</body></html>");
        } catch (SQLException e) {
            e.printStackTrace();
            response.setContentType("text/html");
            response.getWriter().println("An error occurred while retrieving data.");
        }
    }
}
