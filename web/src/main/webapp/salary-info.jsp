<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27.03.2020
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Информация о выплатах</title>
    <style>
        table, th, td {
            padding: 10px;
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
    <h3>Информация о выплатах пользователя ${requestScope.userName}</h3>
    <table>
        <tr>
            <td>Зарплата Brutto</td>
            <td>${requestScope.info.brutto} $</td>
        </tr>
        <tr>
            <td>Выплаты ФСЗН</td>
            <td>${requestScope.info.fszn} $</td>
        </tr>
        <tr>
            <td>Страховка</td>
            <td>${requestScope.info.bgs} $</td>
        </tr>
        <tr>
            <td>Подоходный налог</td>
            <td>${requestScope.info.jobTax} $</td>
        </tr>
        <tr>
            <td>Отчисления в профсоюз</td>
            <td>${requestScope.info.profUnion} $</td>
        </tr>
        <tr>
            <td>Зарплата на руки</td>
            <td>${requestScope.info.netto} $</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/homepage">Вернуться на HomePage</a>
</body>
</html>
