<%--
  Created by IntelliJ IDEA.
  User: hela
  Date: 02/05/2018
  Time: 03:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="Header.jsp"%>
<form action="addNumber.jsp">
    <label>Имя: </label>
    <input type="text" name="FullName" value="${param.FullName}">
    <br>
    <label>Фамилия: </label>
    <input type="text" name="Surname" value="${param.Surname}">
    <br>
    <label>Отчество: </label>
    <input type="text" name="LastName" value="${param.LastName}">
    <br>
    <input type="submit" value="Далее">
</form>
<form action="welcome">
    <input type="submit" value="На главную">
</form>
<%@include file="Footer.jsp"%>
</body>
</html>
