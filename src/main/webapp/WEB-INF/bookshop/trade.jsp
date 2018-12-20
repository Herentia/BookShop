<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/20/2018
  Time: 02:49 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户购物信息</title>
</head>
<body>
    <div align="center">
        <br><br>
        User: ${user.username}
        <br><br>
        <c:forEach items="${user.trades}" var="trade">
            TradeTime: ${trade.tradeTime}
            <br><br>
            <c:forEach items="trade.tradeItems" var="item">
                ${item.book.title} - ${item.book.price} - ${item.book.quantity}
            </c:forEach>
            <br>
            <hr>
            <br>
        </c:forEach>
    </div>
</body>
</html>
