<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 26.03.2020
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        form {
            text-align: center;
            margin: 0 auto;
        }
        button {
            width: 200px;
            height: 30px;
            background-color: lightcyan;
        }
        input {
            margin-bottom: 10px;
            width: 100%;
        }
        p { color: #8b0f0b }
    </style>
</head>
<body>
<h3>Страница регистрации.</h3>
<form action="${pageContext.request.contextPath}/register" method="post">
    <table>
        <tr>
            <td><label for="login">Введите ваш логин</label></td>
            <td><input id="login" type="text" name="login"> <br/></td>
        </tr>
        <tr>
            <td><label for="password">Введите ваш пароль</label></td>
            <td><input id="password" type="password" name="password"><br/></td>
        </tr>
        <tr>
            <td><label for="email">Введите ваш email</label></td>
            <td><input id="email" type="email" name="email"><br/></td>
        </tr>
        <tr>
            <td colspan="2" style="text-align: center">
                <button class="button" type="submit">Добавь меня =)</button>
            </td>
        </tr>
    </table>
    <p>${requestScope.error}</p>
</form>
</body>
</html>
