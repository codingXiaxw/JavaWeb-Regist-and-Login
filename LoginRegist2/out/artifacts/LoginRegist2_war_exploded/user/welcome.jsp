<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/8
  Time: 下午4:41
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>欢迎观临本系统</h1>
<c:choose>
    <c:when test="${ empty sessionScope.sessionUser}">您还没有登录，<a href="<c:url value='/user/login.jsp'/> ">点击这里跳转到登录页面.</a> </c:when>
    <c:otherwise>您好，${sessionScope.sessionUser.username}用户</c:otherwise>
</c:choose>
</body>
</html>
