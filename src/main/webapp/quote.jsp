<%@ page import="com.spasov.homework3.model.Quote"%><%--
  Created by IntelliJ IDEA.
  User: Иван
  Date: 25.02.2024
  Time: 22:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Quote</title>
</head>
<body>
<%Quote quote = (Quote) session.getAttribute("quote");%>
<p><%=quote.getQuote()%></p>
<form method="post" action="maxNum">
    <div>
        <label>Введите первое число:</label>
        <input type="number" name="num1">
    </div>
    <div>
        <label>Введите второе число:</label>
        <input type="number" name="num2">
    </div>
    <div>
        <label>Введите третье число:</label>
        <input type="number" name="num3">
    </div>

    <div>
        <fieldset style="width: max-content">
            <legend>Выберете операцию над числами</legend>
            <label style="display: inline-block;">
                <input type="radio" id="maxID" name="operation" value="max">
                Максимум
            </label><br>
            <label style="display: inline-block;">
                <input type="radio" id="minID" name="operation" value="min">
                Минимум
            </label><br>
            <label style="display: inline-block;">
                <input type="radio" id="avgID" name="operation" value="avg">
                Среднее
            </label>
        </fieldset>
    </div><br>
    <input type="submit" value="Send">
</form>
<% String num1 = (String) session.getAttribute("num1");
    if (num1 != null) {
        out.println("<p>Первое число: " + num1 + "</p>");
    }
    String num2 = (String) session.getAttribute("num2");
    if (num2 != null) {
        out.println("<p>Второе число: " + num2 + "</p>");
    }
    String num3 = (String) session.getAttribute("num3");
    if (num3 != null) {
        out.println("<p>Третье число: " + num3 + "</p>");
    }
    String max = (String) session.getAttribute("max");
    if (max != null) {
        out.println("<b>Максимальное из 3 чисел: " + max + "</b><br>");
    }
    //String operation = (String) session.getAttribute("operation");
    //out.println(operation);
    String res = (String) session.getAttribute("res");
    if (res != null) {
        out.println("<b>Полученный результат: " + res + "</b><br>");
    }

%>
<%--<p><%=num1%></p>--%>
</body>
</html>
