<%--
  Created by IntelliJ IDEA.
  User: romain
  Date: 11/03/2020
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<%@include file="/jsp/include/header.jsp"%>

<form action="${pageContext.request.contextPath}/auth/addProduct" method="post">

    <select name="categoryName">
        <c:forEach var="category" items="${requestScope.get('categoryList')}">
            <option><c:out value="${category.name}"></c:out></option><br/>
        </c:forEach>
    </select>

    <label for="produit">Produit :</label><br>
    <input type="text" id="produit" name="produit" value="Objet"><br>
    <label for="description">Description : </label>
    <input type="text" id="description" name="description" value="Description">
    <label for="price">Price : </label>
    <input type="text" id="price" name="price" value="Prix">
    <input type="submit" value="Submit">
</form>

<%@include file="/jsp/include/footer.jsp"%>
</body>
</html>
