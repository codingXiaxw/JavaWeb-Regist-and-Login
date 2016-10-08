<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/8
  Time: 下午4:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登录</h1>
<p style="color:red;font-weight: 900">${msg}</p>
<form action="<c:url value='/LoginServlet'/> " method="post">
    用户名:<input type="text" name="username" value="${user.username}"/>${errors.username}<br/>
    密  码:<input type="password" name="password" value="${user.password}"/>${errors.password}<br/>
    <input type="submit" value="登录"><br/>
</form>
</body>
</html>
