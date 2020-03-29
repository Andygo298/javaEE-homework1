<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 26.03.2020
  Time: 20:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>HomePage</title>
    <style>
        table, th, td {
            padding: 10px;
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<a href="${pageContext.request.contextPath}/logout">LOGOUT</a>
<p>${requestScope.customMessage}</p>
<h1>HELLO HOMEPAGE</h1>
 <c:if test="${activeUser.role == 'USER'}">
    <p>прекрасный день, если есть вопросы обратись к ADMIN</p>
 </c:if>

<c:if test="${users != null && activeUser.role == 'ADMIN'}">
    <table>
        <tr>
            <th>ID</th>
            <th>Имя</th>
            <th>Роль</th>
            <th>Email</th>
            <th>Зарплата</th>
            <th></th>
        </tr>
        <c:forEach items="${users}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.role}</td>
                <td>${user.email}</td>
                <td>${user.salary} $</td>
                <td>
                    <c:if test="${user.role == 'USER'}">
                    <a href="${pageContext.request.contextPath}/salary?name=${user.login}">
                        Рассчитать зарплату
                    </a>
                    </c:if>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>


</body>
</html>
