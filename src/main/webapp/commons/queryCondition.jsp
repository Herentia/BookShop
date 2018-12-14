<%--
  Created by IntelliJ IDEA.
  User: haohan
  Date: 12/14/2018
  Time: 10:38 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript" src="script/jquery-3.3.1.js"></script>
<script type="text/javascript">
    $(function() {
        $("a").click(function() {
            var serializeVal = $(":hidden").serialize();
            var href = this.href + "&" + serializeVal;
            window.location.href = href;
            return false;//阻止<a>标签执行原来的跳转，而是执行click事件里面的跳转
        })
    })
</script>

<input type="hidden" name="minPrice" value="${param.minPrice}" />
<input type="hidden" name="maxPrice" value="${param.maxPrice}" />
