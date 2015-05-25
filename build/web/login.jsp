<%-- 
    Document   : index
    Created on : 08-May-2015, 01:44:25
    Author     : Lester Chong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form method="POST" action="UserAuthenticationServlet">
            Username: <input type="text" name="username"/>
            <br>
            Password: <input type="password" name="password"/>
            <button type="submit">Submit</button>
        </form>
    </body>
</html>
