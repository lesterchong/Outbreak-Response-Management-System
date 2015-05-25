<%-- 
    Document   : rome
    Created on : 20-May-2015, 16:55:07
    Author     : Lester Chong
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rome</title>
    </head>
    <body>
        All roads lead to Rome. lol.
        <%
            System.out.println(request.getSession().getAttribute("userLogged"));
            System.out.println(request.getSession().getAttribute("hospitalID"));
        %>
        <form action="UserLogoutServlet" method="POST">
            <button type="submit"/>Log out
        </form>
    </body>
</html>
