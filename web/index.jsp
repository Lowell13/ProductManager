<%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 10/03/2020
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%@include file="/jsp/include/header.jsp"%><br />
Hello dear <c:if test="${sessionScope.get('username') == null}">customer !</c:if>
<c:if test="${sessionScope.get('username') != null}"><c:out value="${sessionScope.get('username')}"></c:out>!</c:if>
<br />
<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>
