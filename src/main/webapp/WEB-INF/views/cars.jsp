<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Car Storage</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
    <a href="${pageContext.servletContext.contextPath}/addcar">Add new advertisement</a>
</div>
<table id="cars-table" class="table table-bordered">
    <thead>
    <tr>
        <td>Id</td>
        <td>Car</td>
        <td>Body type</td>
        <td>Engine</td>
        <td>Color</td>
        <td>Price</td>
        <td>Sold</td>
    </tr>
    </thead>
    <tbody id="cars-table-body">
    <c:forEach items="${cars}" var="car">
        <tr>
            <td><c:out value="${car.id}"></c:out></td>
            <td><c:out value="${car.name}"></c:out></td>
            <td><c:out value="${car.body}"></c:out></td>
            <td><c:out value="${car.engine}"></c:out></td>
            <td><c:out value="${car.color}"></c:out></td>
            <td><c:out value="${car.price}"></c:out></td>
            <td><c:out value="${car.sold}"></c:out></td>
            <td>
                <a href="<c:url value="" />">View more</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>