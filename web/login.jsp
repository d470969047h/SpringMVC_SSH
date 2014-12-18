<%--
  Created by IntelliJ IDEA.
  User: daihui
  Date: 2014-12-16
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="/userinfo/test3" method="post">
<label>用户名：</label><input type="text" name="loginName"/>
<label>密码：</label><input type="password" name="loginPass"/>
    <input type="submit" value="提交"/>
</form>
</body>
</html>
