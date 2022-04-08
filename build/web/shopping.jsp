
<%@page import="sample.vegetable.vegetableDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Bao Nguyen Farm</title>
    </head>
    <body>
        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"US".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
            String searchVege = (String) request.getParameter("searchVege");
            if (searchVege == null) {
                searchVege = "";
            }
        %>

        <h1>BAO NGUYEN FARM</h1>

        <h1> Xin chào User: <%= loginUser.getFullName()%></h1>

        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
        </form>

        <form action="MainController">
            Search <input type="text" name="searchVege" value="<%= searchVege%>"/> 
            <input type="submit" name="action" value="SearchVegetable"/>
            <a href="viewCart.jsp"/>Xem giỏ hàng </a>
    </form>

    <h1> Kính mời quý khách lựa chọn sản phẩm </h1>

    <%
        List<vegetableDTO> listVegetable = (List<vegetableDTO>) request.getAttribute("LIST_VEGE");
        if (listVegetable != null) {
            if (!listVegetable.isEmpty()) {
    %>

    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Mã sản phẩm</th>
                <th>Loại sản phẩm</th>
                <th>Tên sản phẩm</th>
                <th>Giá tiền</th>
                <th>Số lượng trong kho</th>                
                <th>Miêu tả</th>
                <th>Số lượng Mua</th>
            </tr>
        </thead>
        <tbody>
            <%
                int count = 1;
                for (vegetableDTO vegetable : listVegetable) {
            %>

        <form action="MainController">
            <tr>
                <td>
                    <%= count++%>
                </td>
                <td>
                    <%= vegetable.getProductID()%>
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
                    <%= vegetable.getQuantity()%> (kg)
                </td>
                <td>
                    <%= vegetable.getDescription()%>
                </td>
                <td>
                    <input type="number" name="amount" value="1" min="1"/>(kg)
                </td>

                <td>
                    <input type="hidden" name="productID" value="<%= vegetable.getProductID()%>"/>
                    <input type="hidden" name="category" value="<%= vegetable.getCategory()%>"/>
                    <input type="hidden" name="productName" value="<%= vegetable.getProductName()%>"/>          
                    <input type="hidden" name="productPrice" value="<%= vegetable.getProductPrice()%>"/>
                    <input type="hidden" name="quantity" value="<%= vegetable.getQuantity()%>"/>
                    <input type="hidden" name="description" value="<%= vegetable.getDescription()%>"/>
                    <input type="submit" name="action" value="Add to cart"/>
                </td>
            </tr>
        </form>

        <%
            }
        %>

    </tbody>
</table></br>

<%
    }
    String message = (String) request.getAttribute("MESSAGE");
    if (message == null) {
        message = "";
    }
%>  

<%= message%>

<%

    }
%>
</body>
</html>
