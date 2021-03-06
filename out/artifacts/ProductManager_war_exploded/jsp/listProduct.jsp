<%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 11/03/2020
  Time: 11:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>List Product</title>
</head>
<body>
<%@include file="/jsp/include/header.jsp"%>
    <c:forEach var="product" items="${requestScope.get('productList')}" >
        <c:out value="${product.name}"></c:out>
        <c:out value="${product.description}"></c:out>
        <c:out value="${product.price}"></c:out>
        <br/>
    </c:forEach>
<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>
