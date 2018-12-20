<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/20/2018
  Time: 01:38 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div align="center">
        <form action="userServlet" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="username" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="查询" /></td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>
