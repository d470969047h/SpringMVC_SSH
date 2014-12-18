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
<c:forEach items="${uesrTea_data_List}">
    <label>ID:</label>${userInfo.userId}<br>
    <label>用户名:</label>${userInfo.userName}<br>
    <label>密码:</label>${userInfo.userPass}<br>
    <label>教师:</label>${teacher.userPass}<br>
</c:forEach>
</body>
</html>
