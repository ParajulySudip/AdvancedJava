/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Marshall
 */
public class PurchaseSave extends HttpServlet {
    Connection con;

    @Override
    public void init() throws ServletException {
        try {
            con=DBConnect.connect();
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(PurchaseSave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PreparedWay(req, resp);
        

       
    }
    public void PreparedWay(HttpServletRequest req, HttpServletResponse res) throws IOException{
         try {
           
       int itemid=Integer.parseInt(req.getParameter("itemid"));
       String price=req.getParameter("price");
       int quantity=Integer.parseInt(req.getParameter("quantity"));
       String q1="select Stock from tbl_item where id=?";
        PreparedStatement qty_stmt=con.prepareStatement(q1);
        qty_stmt.setInt(1, itemid);
             ResultSet result=qty_stmt.executeQuery();
             result.next();
             System.out.println(quantity);
             System.out.println(itemid);
              System.out.println(result.getInt("Stock"));
             quantity=quantity+result.getInt("Stock");
             
             
            
            
       
       String query1="UPDATE tbl_item SET Stock=? WHERE id=?";
       String query="INSERT INTO `tbl_purchase`( `item_id`, `quantity`, `price`) VALUES (?,?,?)";
       
            PreparedStatement obj=con.prepareStatement(query);
            
            obj.setInt(1, itemid);
            obj.setInt(2, quantity);
            obj.setString(3, price);
            
            obj.executeUpdate();
             PreparedStatement stmt=con.prepareStatement(query1);
            
            stmt.setInt(1, quantity);
            stmt.setInt(2, itemid);
            
            stmt.executeUpdate();
            HttpSession s=req.getSession();
            s.setAttribute("successmsg", "Purchase data inserted successfully");
            res.sendRedirect("frontEnd/menu.jsp");
            res.getWriter().println("Purchase data inserted successfully");
            
        } catch (SQLException ex) {
            res.getWriter().println(ex.getMessage());
            Logger.getLogger(PurchaseSave.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
           
        
    
    
}