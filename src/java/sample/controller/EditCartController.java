
package sample.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sample.shopping.Cart;
import sample.vegetable.vegetableDTO;

@WebServlet(name = "EditCartController", urlPatterns = {"/EditCartController"})
public class EditCartController extends HttpServlet {

    private static final String ERROR = "viewCart.jsp";
    private static final String SUCCESS = "viewCart.jsp";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String productID = request.getParameter("productID");
            int newAmount = Integer.parseInt(request.getParameter("amount"));
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("CART");
            vegetableDTO vegetable = null;
            if (cart != null) {
                for (vegetableDTO dto : cart.getCart().values()) {
                    if (dto.getProductID().equals(productID)) {
                        String productName = dto.getProductName();
                        String category = dto.getCategory();
                        int productPrice = dto.getProductPrice();
                        int quantity = dto.getQuantity();
                        String description = dto.getDescription();
                        vegetable = new vegetableDTO(productID, productName, category, productPrice, quantity, newAmount, description);
                        break;
                    }
                }
                cart.update(vegetable);
                session.setAttribute("CART", cart);
                url = SUCCESS;
            }
        } catch(Exception e){
            log("Error at EditCartController: " + e.toString());
        }finally{
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
