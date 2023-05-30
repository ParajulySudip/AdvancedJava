//Write servlet program to demonstrate session and cookie.
package Lab2;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/DemoServlet")
public class DemoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create or retrieve the session
        HttpSession session = request.getSession();

        // Set session attribute
        session.setAttribute("username", "John");

        // Create a cookie
        Cookie cookie = new Cookie("cookieName", "cookieValue");

        // Set cookie expiration time (optional)
        cookie.setMaxAge(60 * 60 * 24); // 24 hours

        // Add cookie to the response
        response.addCookie(cookie);

        // Write response
        response.setContentType("text/html");
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Session and Cookie Demo</h2>");
        response.getWriter().println("<p>Session and cookie have been created successfully.</p>");
        response.getWriter().println("</body></html>");
    }
}
