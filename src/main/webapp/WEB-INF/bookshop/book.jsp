<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/13/2018
  Time: 04:48 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图书信息</title>
    <script type="text/javascript" src="script/jquery-3.3.1.js"></script>
    <%@ include file="/commons/queryCondition.jsp" %>
</head>
<body>
    <div align="center">
        <table cellpadding="10">
            <tr>
                <td>Title:</td>
               <td>${book.title }</td>
            </tr>
            <tr>
                <td>Author:</td>
                <td>${book.author }</td>
            </tr>
            <tr>
                <td>Price:</td>
                <td>${book.price }</td>
            </tr>
            <tr>
                <td>PublishingDate:</td>
                <td>${book.publishingDate }</td>
            </tr>
            <tr>
                <td>SalesAmount:</td>
                <td>${book.salesAmount }</td>
            </tr>
        </table>
        <br><br>
        <a href="bookServlet?method=getBooks&pageNo=${param.pageNo}">继续购物</a>
    </div>
</body>
</html>
