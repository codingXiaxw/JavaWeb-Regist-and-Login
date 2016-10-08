<%--
  Created by IntelliJ IDEA.
  User: codingBoy
  Date: 16/10/8
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">
        function _change() {
            var ele=document.getElementById("vCode");
            ele.src="<c:url value='/VerifyCedeServlet'/>?xxx="+new Date().getTime();
        }
    </script>
</head>

<body>


<h1>注册</h1>
<p style="color:red;font-weight: 900">${msg}</p>
<form action="<c:url value='/RegistServlet'/> " method="post">
    用户名:<input type="text" name="username" value="${user.username}"/>${errors.username}<br/>
    密  码:<input type="password" name="password" value="${user.password}"/>${errors.password}<br/>
    验证码:<input type="text" name="verifyCode" value="${user.verifyCode}" size="10"/>${errors.verifyCode}
    <img id="vCode" src="<c:url value='/VerifyCedeServlet'/> ">
    <a href="javascript:_change()"> 点击更换 </a><br/>
    <input type="submit" value="提交"><br/>
</form>
</body>
</html>
