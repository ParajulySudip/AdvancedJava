/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package backend;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Marshall
 */
public class GetItemSelectBox extends HttpServlet {
    Connection con;
    

    @Override
    public void init() throws ServletException {
       try {
            con = DBConnect.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GetAllItem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GetItemSelectBox.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
        String query = "select*from tbl_item";
        Statement stmt=con.createStatement();
        ResultSet result=stmt.executeQuery(query);

           String combo ="<select name='itemid'>";
           
           while(result.next()){
            String id=result.getString("id");
            String itemName=result.getString("name");
            combo+="<option value='"+id+"'>";
            combo+=itemName;
            combo+="</option>";
            

            
        }
        combo+="</select>";
        resp.setContentType("text/html");
        resp.getWriter().println(combo);
        
       
       // result.next();
        } catch (SQLException ex) {
            Logger.getLogger(GetAllItem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void destroy() {
  try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(GetItemSelectBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}