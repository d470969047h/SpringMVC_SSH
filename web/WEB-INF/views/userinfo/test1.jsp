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
<label STYLE="font-size: 14pt">原生servlet访问示例一</label><br>
<label>request.getRequestURI():</label>${req_uri}<br>
<label>response.getCharacterEncoding():</label>${resp}<br>
<label>session.getId():</label>${sid}<br>
<label>application.getRealPath("/"):</label>${app_path}
</body>
</html>
