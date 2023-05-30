
package Lab2;
//Write servlet program to demonstrate response sendRedirect and requestDispacher forward() and include().

/**
 *
 * @author Sudip
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DemooServlet")
public class DemooServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Send Redirect
        response.sendRedirect("https://www.example.com");

        // Forward
        // RequestDispatcher rd = request.getRequestDispatcher("/forwarded.jsp");
        // rd.forward(request, response);

        // Include
        // RequestDispatcher rd = request.getRequestDispatcher("/included.jsp");
        // rd.include(request, response);
    }
}
