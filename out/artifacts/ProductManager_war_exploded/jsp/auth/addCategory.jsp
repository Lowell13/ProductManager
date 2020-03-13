<%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 12/03/2020
  Time: 15:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/auth/addCategory" method="post">
    <label for="category">Name:</label><br>
    <input type="text" id="category" name="category" value="New Category"><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
