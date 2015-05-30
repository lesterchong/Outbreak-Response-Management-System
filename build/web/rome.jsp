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
        <li><a href="AddPages/AddAdmittance.jsp">Admit Patient</a></li>
        <li><a href="AddPages/AddDischarge.jsp">Discharge Patient</a></li>
        <li><a href="AddPages/AddSupply.jsp">Add Supply</a></li>
        <li><a href="AddPages/TransferSupply.jsp">Request Supply</a></li>
        <form action="UserLogoutServlet" method="POST">
            <button type="submit"/>Log out
        </form>
    </body>
</html>
