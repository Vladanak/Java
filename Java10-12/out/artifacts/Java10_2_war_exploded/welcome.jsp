<%@ page import="java.util.Calendar" %><%--
  Created by IntelliJ IDEA.
  User: hela
  Date: 28/04/2018
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="Header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String good;
    if(Calendar.getInstance().getTime().getHours() < 17)
        good = "Доброе утро";
    else
        good = "Добрый вечер";
%>
<h2>
<%= good%> ${name} ${role}
</h2>
<br>
Последняя сессия была: ${last}
<br>
Роль: ${rolewas}
<br>
Количество посещений: ${times}
<br>
<form action="addNames.jsp">
    <input type="submit" value="далее">
</form>
<%@include file="Footer.jsp"%>
</body>
</html>
