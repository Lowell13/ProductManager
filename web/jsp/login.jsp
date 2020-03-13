<%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 11/03/2020
  Time: 09:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
<%@include file="/jsp/include/header.jsp"%>

<form action="${pageContext.request.contextPath}/login" method="post">
    <label for="username">First name:</label><br>
    <input type="text" id="username" name="username" value="John"><br>
    <input type="submit" value="Submit">
</form>

<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>
