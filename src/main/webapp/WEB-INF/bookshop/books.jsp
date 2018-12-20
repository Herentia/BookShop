<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/12/2018
  Time: 03:51 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>图书信息</title>
    <script type="text/javascript" src="script/jquery-3.3.1.js"></script>
    <script type="text/javascript">
        $(function() {
            //输入页面跳转
            $("#pageNo").change(function() {
                //得到当前页页码
                var pageNo = $(this).val();
                pageNo = $.trim(pageNo);
                //正则判断输入页码是否合法
                var reg = /^\d+$/g;
                var flag = false;
                // var pageNo = 0;
                if(reg.test(pageNo)) {
                    //判断输入的页码是否在合法范围内
                    var pageNo2 = parseInt(pageNo);
                    if(pageNo2 >= 1 && pageNo2 <= parseInt(${bookpage.totalPageNumber})) {
                        flag = true;
                    }
                }
                if(!flag) {
                    $(this).val("");
                    alert("输入页码不在合法范围内");
                    return;
                }
                //翻页
                var serialize = $(":hidden").serialize();
                window.location.href = "bookServlet?method=getBooks&pageNo=" + pageNo2 + "&" + serialize;
            })
        });
    </script>
    <%@ include file="/commons/queryCondition.jsp" %>
</head>
<body>
    <div align="center">
        <c:if test="${param.title != null}">
            您已将<span style="color: red">${param.title}</span>加入到购物车中
            <br><br>
        </c:if>

        <c:if test="${!empty sessionScope.shoppingCart.books}">
            您的购物车中有${sessionScope.shoppingCart.bookNumber} 本书，
            <a href="bookServlet?method=forwardPage&pageNo=${bookpage.pageNo }&page=shoppingCart">查看购物车</a>
        </c:if>

        <br><br>
        <form action="<%=request.getContextPath()%>/bookServlet?method=getBooks" method="post">
            <input type="text" size="1" name="minPrice" /> -
            <input type="text" size="1" name="maxPrice" />
            <input type="submit" value="提交" />
        </form>

        <br><br>
        <table cellpadding="10">
            <c:forEach items="${bookpage.list}" var="book">
                <tr>
                    <td>
                        <a href="bookServlet?method=getBook&pageNo=${bookpage.pageNo}&bookId=${book.id}">${book.title}</a>
                        <br>
                        ${book.author}
                    </td>
                    <td>${book.price}</td>
                    <td><a href="bookServlet?method=addToCart&pageNo=${bookpage.pageNo}&bookId=${book.id}&title=${book.title}">加入购物车</a> </td>
                </tr>
            </c:forEach>
        </table>

        <br><br>
        共${bookpage.totalPageNumber } 页
        &nbsp;&nbsp;
        当前第${bookpage.pageNo } 页
        &nbsp;&nbsp;
        <c:if test="${bookpage.hasprev }">
            <a href="bookServlet?method=getBooks&pageNo=1">首页</a>
            &nbsp;&nbsp;
            <a href="bookServlet?method=getBooks&pageNo=${bookpage.prePage }">上一页</a>
        </c:if>
        &nbsp;&nbsp;
        <c:if test="${bookpage.hasNext }">
            <a href="bookServlet?method=getBooks&pageNo=${bookpage.nextPage }">下一页</a>
            &nbsp;&nbsp;
            <a href="bookServlet?method=getBooks&pageNo=${bookpage.totalPageNumber}">末页</a>
        </c:if>

        跳转到<input type="text" size="1" id="pageNo" />页
    </div>
</body>
</html>
