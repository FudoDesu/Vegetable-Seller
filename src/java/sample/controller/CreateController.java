
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sample.user.UserDAO;
import sample.user.UserDTO;
import sample.user.UserError;

@WebServlet(name = "CreateController", urlPatterns = {"/CreateController"})
public class CreateController extends HttpServlet {

    private static final String ERROR="create.jsp";
    private static final String SUCCESS="login.jsp";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url =ERROR ;
        try {
            String userID= request.getParameter("userID");
            String fullName= request.getParameter("fullName");
            String roleID= request.getParameter("roleID");
            String password= request.getParameter("password");
            String confirm= request.getParameter("confirm");
            String phone= request.getParameter("phone");
            String address= request.getParameter("address");
            UserError userError = new UserError("", "", "", "", "", "", "");
            UserDAO dao = new UserDAO();
            boolean check= true;
            
            if (userID.length()<2 || userID.length()>10) {
                userError.setUserID("UserID phai tu 2 den 10 ky tu!");
                check= false;
            }
            
            boolean checkDuplicate= dao.checkDuplicate(userID);
            if (checkDuplicate) {
                userError.setUserID("UserID da duoc su dung!");
                check=false;
            }
            
            if (fullName.length()<5 || fullName.length()>20) {
                userError.setFullName("FullName phai tu 5 den 20 ky tu!");
                check= false;
            }
            
            if (roleID.isEmpty()) {
                userError.setRoleID("RoleID khong duoc de trong!");
                check= false;
            }
            
            if (password.isEmpty()) {
                userError.setPassword("Password khong duoc de trong");
                check= false;
            }
            
            if (!confirm.equals(password)) {
                userError.setConfirm("Khong trung voi password! Vui long nhap lai!");
                check= false;
            }
            
            if (check) {
                boolean checkInsert= dao.insert(new UserDTO(userID, fullName, roleID, password, phone, address));
                if (checkInsert) {
                    url= SUCCESS;
                }
            } else {
                request.setAttribute("USER_ERROR", userError);
            }
            
        } catch (Exception e) {
            log ("Error at CreateController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
