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
<c:forEach items="${user_data_list}" var="user">
    <label>ID:</label>${user.userId}
    <label>用户名:</label>${user.userName}
    <label>密码:</label>${user.userPass}<br>
</c:forEach>
</body>
</html>
