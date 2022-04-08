
<%@page import="sample.user.UserError"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create new user Page</title>
    </head>
    <body>
        <%
            UserError userError = (UserError) request.getAttribute("USER_ERROR");
            if (userError == null) {
                userError = new UserError("", "", "", "", "", "", "");
            }
        %>

        <h1> Create New User </h1>
        <form action="MainController" method="POST">
            User ID(*) <input type="text" name="userID" required=""/>
            <%= userError.getUserID()%></br>
            Full Name(*) <input type="text" name="fullName" required=""/>
            <%= userError.getFullName()%></br>
            Password(*) <input type="password" name="password" required=""/>
            <%= userError.getPassword()%></br>
            Confirm(*) <input type="password" name="confirm" required=""/>
            <%= userError.getConfirm()%></br>
            Role ID (*)
            <select name="roleID">
                <option value=""></option>
                <option value="AD">Admin</option>
                <option value="US">User</option>
            </select>
            <%= userError.getRoleID()%></br>
            Phone <input type="text" name="phone"/>
            <%= userError.getPhone()%></br>
            Address <input type="text" name="address"/>
            <%= userError.getAddress()%></br>
            <input type="submit" name="action" value="Create"/>
            <input type="reset" value="Reset"/></br>
            <a href="login.jsp"/>Đăng nhập</a>
    </form>
    </body>
</html>
