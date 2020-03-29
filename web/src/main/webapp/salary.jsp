<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 27.03.2020
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculate User Salary</title>
    <style>
        div {
            width: 350px;
            margin: 0 auto;
        }
        button {
            width: 100px;
            height: 30px;
            background-color: lightcyan;
        }
        input {
            margin: 10px;
            width: 40%;
        }
        label {
            min-width: 130px;
            display: inline-block;
        }
    </style>
</head>
<body>
    <h1>ЗАРПЛАТКА</h1>
    <div>
        <h3>Расчет зарплаты</h3>
        <form action="${pageContext.request.contextPath}/salary?name=${requestScope.name}" method="post">
            <label for="brutto">Salary BRUTTO</label>
            <input id="brutto" type="number" name="brutto" value="0.0" step="0.1" min="0" required>$<br/>

            <label for="fszn">FSZN</label>
            <input id="fszn" type="number" name="fszn" value="35.0" step="0.1" min="0" max="100" required>%<br/>

            <label for="bgs">BGS</label>
            <input id="bgs" type="number" name="bgs" value="0.6" step="0.1" min="0" max="100" required>%<br/>

            <label for="jobTax">Job Taxes</label>
            <input id="jobTax" type="number" name="jobTax" value="13.0" step="0.1" min="0" max="100" required>%<br/>

            <label for="profUnion">Prof Union Taxes</label>
            <input id="profUnion" type="number" name="profUnion" value="1.0" step="0.1" min="0" max="100" required>%<br/>

            <button class="button" type="submit">Рассчитать</button>
        </form>
    </div>

    <a href="${pageContext.request.contextPath}/homepage">Вернуться на HomePage</a>
</body>
</html>
