<html>
<body>
<h2>Default Hello World!</h2>
<form action="${pageContext.request.contextPath}/add" method="post">
    username:<br>
    <input type="text" name="username" value="zhangsan"><br>
    password:<br>
    <input type="password" name="password"><br>
    tel:<br>
    <input type="text" name="tel" value="16630525060">
    <br>
    <input type="submit" value="signup">
</form>
</body>
</html>
