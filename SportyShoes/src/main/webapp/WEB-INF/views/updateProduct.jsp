<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
	<h2>Update Product</h2>
	<form action="/product/update" method="post">
		<input type="hidden" name="_method" value="POST"> Id(Can't be
		edited): <input type="text" value="${product.id}" name="id"
			readonly="readonly"> <br> Name: <input type="text"
			value="${product.name}" required="required" name="name"> <br>
		Description: <input type="text" value="${product.discription}"
			name="discription"> <br> Category <select
			required="required" name="category">
			<option value="${product.category.id }">${product.category.name}</option>
			<c:forEach var="category" items="${categories}">
				<c:if test="${category.id != product.category.id }">
					<option value="${category.id }">${category.name}</option>
				</c:if>
			</c:forEach>
		</select><br> Price:<input type="number" name="price" value=${product.price } required="required" />
		<input type="submit" value="update">
	</form>
</body>
</html>