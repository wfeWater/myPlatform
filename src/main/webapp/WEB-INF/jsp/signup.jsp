<%--
  Created by IntelliJ IDEA.
  User: 12846
  Date: 2019/4/10
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="/add">
    用户名:<<br>
        <input type="text" name="username" value="zhangsan">
    密码:<<br>
        <input type="password" name="password">
    手机号:<<br>
        <input type="text" name="tel" value="16630525060">
    <br><br>
        <input type="submit" value="signup">
    </form>
</body>
</html>
