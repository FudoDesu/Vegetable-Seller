
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <h1>BAO NGUYEN FARM</h1>
        
        <form action="MainController" method="POST">
            User ID<input type="text" name="userID"/></br>
            Password<input type="password" name="password"/></br>
            <input type="submit" name="action" value="Login"/>
            <input type="reset" value="Reset"/>
        </form>
        
        <%
                String error = (String) request.getAttribute("ERROR");
                if (error == null) {
                    error = "";
                }
            %>

            <%= error%>  
        
        <a href="create.jsp"> Create new User </a></br>
    </body>
</html>
