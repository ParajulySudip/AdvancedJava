
package Lab2;
//life cycle of servlet.

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sudip
 */


public class MyServlet extends HttpServlet {
    
    @Override
    public void init() throws ServletException {
        // Initialization code goes here
        System.out.println("Servlet initialized");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Handling GET request
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, Servlet!</h1>");
        out.println("</body></html>");
    }
    
    @Override
    public void destroy() {
        // Cleanup code goes here
        System.out.println("Servlet destroyed");
    }
}
