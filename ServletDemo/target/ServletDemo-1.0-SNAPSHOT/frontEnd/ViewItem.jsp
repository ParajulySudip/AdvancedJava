<%-- 
    Document   : ViewItem
    Created on : May 8, 2023, 9:27:04 AM
    Author     : Sudip
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%

String photo = (String)session.getAttribute("photo");
photo = "uploads/"+photo;
System.out.println(photo);
%>
<jsp:include page= "menu.jsp"/>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="main-content">
            <div class="title">
                Display Item
            </div>
            <div class="content itemDisplay">
                <img src="<%= photo%>"/>
                <h1>Item Name: </h1>
                <h1>Item Price: </h1>
                <h1>Item Stock: </h1>
            </div>
        </div>
        
    </body>
</html>