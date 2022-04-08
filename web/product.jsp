
<%@page import="sample.vegetable.vegetableDTO"%>
<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Managing Page</title>
    </head>
    <body>
        <h1>MANAGING PRODUCT</h1>

        <%
            UserDTO loginUser = (UserDTO) session.getAttribute("LOGIN_USER");
            if (loginUser == null || !"AD".equals(loginUser.getRoleID())) {
                response.sendRedirect("login.jsp");
                return;
            }
            String search = (String) request.getParameter("search");
            if (search == null) {
                search = "";
            }
        %>

        <form action="MainController">
            <input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="manage" value="Search"/>
        </form>

        <%
            List<vegetableDTO> listVege = (List<vegetableDTO>) request.getAttribute("LIST_VEGE");
            if (listVege != null) {
                if (!listVege.isEmpty()) {
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
                </tr>
            </thead>
            <tbody>
                
                <%
                    int count = 1;
                    for (vegetableDTO vegetable : listVege) {
                %>

            <form action="MainController">

                <tr>
                    <td><%= count++%></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </form>
        </tbody>
    </table>


    <%
            }
        }
    %>
</body>
</html>
