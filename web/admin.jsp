<%@page import="java.util.List"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
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

        <h1> Xin chào Admin: <%= loginUser.getFullName()%></h1>

        <form action="MainController">
            <input type="submit" name="action" value="Logout"/>
            <a href="product.jsp">Manage Product</a>
        </form>

        <form action="MainController">
            Search <input type="text" name="search" value="<%= search%>"/>
            <input type="submit" name="action" value="Search"/>
        </form>

        <%
            List<UserDTO> listUser = (List<UserDTO>) request.getAttribute("LIST_USER");
            if (listUser != null) {
                if (!listUser.isEmpty()) {
        %>

        <table border="1">
            <thead>
                <tr>
                    <th>No</th>
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
            </thead>
            <tbody>
                <%
                    int count = 1;
                    for (UserDTO user : listUser) {
                %>

            <form action="MainController">
                <tr>
                    <td>
                        <%= count++%>
                    </td>
                    <td>                       
                        <input type="text" name="userID" value="<%= user.getUserID()%>" readonly=""/>
                    </td>
                    <td>
                        <input type="text" name="fullName" value="<%= user.getFullName()%>"/>
                    </td>
                    <td>
                        <input type="text" name="roleID" value="<%= user.getRoleID()%>"/>
                    </td>
                    <td>
                        <%= user.getPassword()%>
                    </td>
                    <td>
                        <input type="text" name="phone" value="<%= user.getPhone()%>"/>
                    </td>
                    <td>
                        <input type="text" name="address" value="<%= user.getAddress()%>"/>
                    </td>
                    <td>
                        <a href="MainController?userID=<%= user.getUserID()%>&action=Delete&search=<%= search%>">Delete</a>
                    </td>
                    <td>
                        <input type="submit" name="action" value="Update"/>
                        <!--<input type="hidden" name="userID" value="<%= user.getUserID()%>"/>-->
                        <input type="hidden" name="search" value="<%= search%>"/>
                    </td>
                </tr>
            </form>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        }
        String error = (String) request.getAttribute("ERROR");
        if (error == null) {
            error = "";
        }
    %>

    <%= error%>

    <%
        }
    %>
</body>
</html>
