
<%@page import="sample.shopping.Cart"%>
<%@page import="sample.vegetable.vegetableDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
    </head>
    <body>
        <h1>BAO NGUYEN FARM</h1>

        <%
            Cart cart = (Cart) session.getAttribute("CART");
        %>

        <h1>YOUR CART:</h1>

        <a href="shopping.jsp">Continue shopping</a>





        <table border="1">
            <thead>
                <tr>
                    <th>NO</th>
                    <th>Mã sản phẩm</th>
                    <th>Loại sản phẩm</th>
                    <th>Tên sản phẩm</th>
                    <th>Gía tiền</th>
                    <th>Số lượng mua</th>
                    <th>Tổng tiền</th>
                    <th>REMOVE</th>
                    <th>EDIT</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    double total = 0;
                    String order = "";
                    int totalAmount = 0;
                    for (vegetableDTO vegetable : cart.getCart().values()) {
                        total += vegetable.getProductPrice() * vegetable.getAmount();
                        order += vegetable.getProductID() + " " + vegetable.getAmount();
                        totalAmount += vegetable.getAmount();
                %>
            <form action="MainController">

                <tr>
                    <td>
                        <%= count++%>
                    </td>
                    <td>
                        <input type="text" name="productID" value="<%= vegetable.getProductID()%>" readonly=""/>
                    </td>
                    <td>
                        <%= vegetable.getCategory()%>
                    </td>
                    <td>
                        <%= vegetable.getProductName()%>
                    </td>
                    <td>
                        <%= vegetable.getProductPrice()%> VND/1kg
                    </td>
                    <td>
                        <input type="number" name="amount" value="<%= vegetable.getAmount()%>"/> (kg)
                    </td>
                    <td>
                        <%= vegetable.getProductPrice() * vegetable.getAmount()%> VND
                    </td>
                    <td>
                        <input type="submit" name="action" value="Remove"/>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Edit"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>

    <h1>Tổng hóa đơn: <%= total%> VND</h1>
    <h1>Hóa đơn: <%= order %> </h1>
    <form action="MainController">
        <input type="submit" name="action" value="Purchase"/>
    </form>
</body>
</html>
