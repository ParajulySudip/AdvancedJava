<%-- 
    Document   : LoginForm
    Created on : Apr 18, 2023, 9:04:24 AM
    Author     : Shalon
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="../LoginUser" method="post">
             <label>Username:</label><input type="text" name="username" />
            <label>Password:</label><input type="password" name="password" class="passwordField"/>

            <input type="submit" class="btn_success" value="Login" />
        </form>
        
    </body>
</html>