<%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 11/03/2020
  Time: 12:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Google Fonts Roboto -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="resources/css/mdb.min.css">
    <!-- Your custom styles (optional) -->
    <link rel="stylesheet" href="resources/css/style.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark primary-color">

    <a class="navbar-brand" href="${pageContext.request.contextPath}/index.jsp">Index</a>

    <!-- Collapse button -->
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
            aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <!-- Collapsible content -->
    <div class="collapse navbar-collapse" id="basicExampleNav">

        <!-- Links -->
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/listProduct">List Product</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/auth/addProduct">Add Product</a>
            </li>

            <c:if test="${sessionScope.get('username') == null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                </li>
            </c:if>

            <c:if test="${sessionScope.get('username') != null}">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/login">Logout</a>
                </li>
            </c:if>

        </ul>
    </div>

<%--    <a href="${pageContext.request.contextPath}/listProduct">List Product</a>
    <a href="${pageContext.request.contextPath}/auth/addProduct">Add Product</a>

    <c:if test="${sessionScope.get('username') == null}">
        <a href="${pageContext.request.contextPath}/login">Login</a>
    </c:if>

    <c:if test="${sessionScope.get('username') != null}">
        <a href="${pageContext.request.contextPath}/logout">Logout</a><br/><br/>
    </c:if>--%>
</nav>
</body>
</html>
