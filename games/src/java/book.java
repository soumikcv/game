/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author teja
 */
@WebServlet(name="book",urlPatterns = {"/book"})
public class book extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      System.out.println("jsp called");
              
            Slots ss=new Slots();
              
           String slot = request.getParameter("slot1");
                
try{
            
                String s[]=slot.split(",");
             String b= ss.UpdateSlots(s[0], s[1]);
             response.sendRedirect("profile.html");
          
                          
            }
            catch(Exception e){
                response.sendRedirect("profile.html");
            }
            }
            

            
    }
