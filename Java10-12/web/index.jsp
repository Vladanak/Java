<%--
  Created by IntelliJ IDEA.
  User: hela
  Date: 26/04/2018
  Time: 18:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
  <head>
    <title>Java10.2</title>
  </head>
  <body>
  <h3>Введите свои данные для авторизации</h3>
  <form method="post">
    <h5>Логин
      <input type="text" name="Login"></h5>
    <h5>Пароль
      <input type="password" name="Password"></h5>
    <p>
    <input type="submit" name="LogInButton" value="Войти">
  </form>
  <p>
  ${ErrorField}
  </body>
</html>
