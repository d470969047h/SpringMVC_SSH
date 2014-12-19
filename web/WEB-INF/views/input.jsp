<%--
  Created by IntelliJ IDEA.
  User: daihui
  Date: 2014-12-16
  Time: 9:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title></title>
</head>
<body>
${some_msg}

<form:form action="/method3" method="post" modelAttribute="user">
    <form:select path="userId" items="${users}" itemLabel="userName" itemValue="userId">

    </form:select>
    <input type="submit" value="提交"/>
</form:form>
</body>
</html>
