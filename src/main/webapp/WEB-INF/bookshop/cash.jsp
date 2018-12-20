<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/18/2018
  Time: 10:56 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>支付页面</title>
</head>
<body>
    <div align="center">
        一共购买商品数量为：${sessionScope.shoppingCart.bookNumber}
        <br><br>
        总 金 额 为      ：${sessionScope.shoppingCart.totalMoney}
        <br><br>
        <c:if test="${requestScope.errors != null}">
            <span color="red">${requestScope.errors}</span>
        </c:if>
        <form action="bookServlet?method=cash" method="post">
            <table cellpadding="10">
                <tr>
                    <td>账号姓名：</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td>付款账户：</td>
                    <td><input type="text" name="accountId" /></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="提交" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
