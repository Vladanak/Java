<%--
  Created by IntelliJ IDEA.
  User: hela
  Date: 02/05/2018
  Time: 03:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="Header.jsp" %>
Номер телефона: ${param.Adress}
<br>
Имя: ${param.FullName}
<br>
Фамилия: ${param.Surname}
<br>
Отчество: ${param.LastName}
<br>
<form action="addNumber.jsp">
    <input type="hidden" name="FullName" value=${param.FullName}>
    <input type="hidden" name="Surname" value=${param.Surname}>
    <input type="hidden" name="LastName" value=${param.LastName}>
    <input type="hidden" name="Adress" value=${param.Adress}>
    <input type="submit" value="назад">
</form>
<form action="welcome">
    <br>
    <input type="submit" value="На главную">
</form>
<%@include file="Footer.jsp"%>
</body>
</html>
