/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.*;
/**
 *
 * @author Shalon
 */
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        session.removeAttribute("username");
        session.removeAttribute("userid");
        session.removeAttribute("errorMsg");
        res.sendRedirect("frontEnd/loginForm.jsp");
    }
        
    
}