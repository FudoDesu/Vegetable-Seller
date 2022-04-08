
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.user.UserDAO;
import sample.user.UserDTO;

@WebServlet(name = "LoginController", urlPatterns = {"/LoginController"})
public class LoginController extends HttpServlet {

    private static final String ERROR="login.jsp";
    private static final String ADMIN="admin.jsp";
    private static final String USER="shopping.jsp";
    private static final String AD="AD";
    private static final String US="US";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url= ERROR;
        try {
            String userID= request.getParameter("userID");
            String password= request.getParameter("password");
            UserDAO dao = new UserDAO();
            UserDTO user= dao.checkLogin(userID, password);
            if (user!= null) {
                HttpSession session = request.getSession();
                session.setAttribute("LOGIN_USER", user);
                String roleID= user.getRoleID();
                if (AD.equals(roleID)) {
                    url= ADMIN;
                } else if (US.equals(roleID)) {
                    url= USER;
                } else {
                    request.setAttribute("ERROR", "Role ID not support !");
                }
            } else {
                request.setAttribute("ERROR", "Wrong UserID or password");
            }
        }catch (Exception e) {
            log("Error at LoginController " + e.toString());
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
