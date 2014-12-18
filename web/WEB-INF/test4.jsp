<%--
  Created by IntelliJ IDEA.
  User: daihui
  Date: 2014-12-16
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
 <form action="/userinfo/test4" method="post">
     <label>用户名ID:</label><input type="text" name="userInfo.userId"/><br>
     <label>用户名:</label><input type="text" name="userInfo.userName"/><br>
     <label>密码:</label><input type="text" name="userInfo.userPass"/><br>
     <label>教师姓名:</label><input type="text" name="teacher.teaName"/><br>
     <input type="submit" value="提交"/>
 </form>
</body>
</html>
