<html>
<body>
<h2>Hello World!</h2>
<%
    response.sendRedirect(request.getContextPath() + "/bookServlet?method=getBooks");
%>
</body>
</html>
