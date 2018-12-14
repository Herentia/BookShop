<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/14/2018
  Time: 03:19 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
    <script type="text/javascript" src="script/jquery-3.3.1.js"></script>
    <script type="application/javascript">
        $(function() {
            $(".delete").click(function() {
                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                var flag = confirm("确定要删" + title + "除信息吗？");
                if(flag) {
                    return true;
                }
                return false;
            })
        })
    </script>
</head>
<body>
    <div align="center">
        购买商品数量： ${sessionScope.shoppingCart.bookNumber}
        <br><br>
        <table cellpadding="10">
            <c:forEach items="${sessionScope.shoppingCart.items}" var="item">
                <tr>
                    <td>${item.book.title}</td>
                    <td>${item.quantity}</td>
                    <td>${item.book.price}</td>
                    <td><a href="" class="delete">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4">总金额：￥${sessionScope.shoppingCart.totalMoney} 元</td>
            </tr>
            <tr>
                <td colspan="1">继续购物</td>
                <td colspan="1">全部删除</td>
                <td colspan="2">结账</td>
            </tr>
        </table>
    </div>
</body>
</html>
