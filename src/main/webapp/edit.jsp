<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="user" class="ua.nure.kn.chychkanov.usermanagement.User" scope="session"/>

<html>

<head>
    <title>User Management/Edit</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/edit" method="post">
    <input type="hidden" name="id" value="${user.id}">
First name <input type="text" name="firstName" value="${user.firstName}"></br>
Last name <input type="text" name="lastName" value="${user.lastName}"></br>
Date of birth <input type="text" name="date" value="<fmt:formatDate value="$(user.dateofBirth)" type="date" dateStyle="medium""</br>

    <input type="submit" name="okButton" value="Ok">
    <input type="submit" name="cancel" value="Cancel">
</form>
<c:if test="${requestScope.error != null}">
    <script>
        alert("${requestScope.error}")
    </script>
</c:if>
</body>

</html> 