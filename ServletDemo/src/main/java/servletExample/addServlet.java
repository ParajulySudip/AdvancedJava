/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servletExample;

/**
 *
 * @author acer
 */




import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "myadd", urlPatterns = {"/somefolder/addnum"})
public class addServlet extends HttpServlet{

    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      
       res.setContentType("text/html");
       int num1 =  Integer.parseInt(req.getParameter("num1"));
       int num2 =  Integer.parseInt(req.getParameter("num2"));
       int sum = num1 + num2;
       PrintWriter out = res.getWriter();
       out .println(sum);
    }
    
    
}