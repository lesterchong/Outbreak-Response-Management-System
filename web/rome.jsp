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
        <li><a href="AddPages/AddAdmittance.jsp" target="iframe">Admit Patient</a></li>
        <li><a href="AddPages/AddAdmittance.jsp" target="iframe">Discharge Patient</a></li>
        <li><a href="AddPages/AddAdmittance.jsp" target="iframe">Add Supply</a></li>
        <li><a href="AddPages/AddAdmittance.jsp" target="iframe">Request Supply</a></li>
        <form action="UserLogoutServlet" method="POST">
            <button type="submit"/>Log out
        </form>
    </body>
</html>
