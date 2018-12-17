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
                var flag = confirm("确定要删除" + title + "信息吗？");
                if(flag) {
                    return true;
                }
                return false;
            });

            //修改购物车商品数量
            $(":text").change(function() {
                //修改商品数量给出提示
                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                var flag = confirm("确定要修改" + title + "的数量吗？");
                if(!flag) {
                    return true
                }

                //异步请求更新修改商品数量后的总商品数量和总价格
                var url = "bookServlet";
                var idVal = $.trim(this.name);
                var quantityVal = $.trim(this.value);
                var args = {
                    "method"    : "updateItemQuantity",
                    "id"        : idVal,
                    "quantity"  : quantityVal,
                    "time"      : new Date()
                };

                //判断输入的商品数量是否合法
                var reg = /^\d+$/g;
                var flag = false;
                var quantity = -1;
                if(reg.test(quantityVal)) {
                    var quantity = parseInt(quantityVal);
                    if(quantity >= 0) {
                        flag = true;
                    }
                }

                if(!flag) {
                    alert("输入的数量不合法");
                    $(this).val($(this).attr("class"));
                    return;
                }

                //当修改商品数量为0时，即为删除该商品
                var $tr = $(this).parent().parent();
                var title = $.trim($tr.find("td:first").text());
                if(quantity == 0) {
                    var flag2 = confirm("确定要删除" + title + "吗？");
                    if(flag2) {
                        // var href = $tr.find("td:last").find("a").attr("href");
                        // var serialize = $(":hidden").serialize();
                        // href = href + "&" + serialize;
                        // window.location.href = href;
                        var $a = $tr.find("td:last").find("a");
                        alert($a);
                        $a.onclick();
                        return;
                    }
                }

                $.post(url, args, function (data) {
                    var bookNumber = data.bookNumber;
                    var totalMoney = data.totalMoney;

                    $("#bookNumber").text("购买商品数量： " + bookNumber);
                    $("#totalMoney").text("总金额：￥" + totalMoney + " 元");
                }, "json")
            })
        })
    </script>
</head>
<body>
    <div align="center">
        <div id="bookNumber">购买商品数量： ${sessionScope.shoppingCart.bookNumber}</div>

        <br><br>
        <table cellpadding="10">
            <c:forEach items="${sessionScope.shoppingCart.items}" var="item">
                <tr>
                    <td>${item.book.title}</td>
                    <td>
                        <input class="${item.quantity}" type="text" size="1" name="${item.book.id}" value="${item.quantity}" />
                    </td>
                    <td>
                        ${item.book.price}
                    </td>
                    <td>
                        <a href="bookServlet?method=remove&id=${item.book.id}" class="delete">删除</a>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="4" id="totalMoney">总金额：￥${sessionScope.shoppingCart.totalMoney} 元</td>
            </tr>
            <tr>
                <td colspan="1"><a href="">继续购物</a></td>
                <td colspan="1"><a href="bookServlet?method=clear">全部删除</a></td>
                <td colspan="2"><a href="">结账</a></td>
            </tr>
        </table>
    </div>
</body>
</html>
