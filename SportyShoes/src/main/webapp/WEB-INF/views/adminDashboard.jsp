<%@page import="java.util.List"%>
<%@page import="com.project.sportyshoes.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Dashboad</title>
</head>
<body>
	<h5>${message }</h5>
	<div>
		<h3>Name = ${admin.name }</h3>
		<h3>Email = ${admin.email }</h3>
	</div>
	<h2>Category</h2>
	<form action="/category/create" method="post">
		Name: <input type="text" required="true" name="name"> <br>
		Description: <input type="text" name="discription"> <br>
		<input type="submit" value="Add" />
	</form>
	<table border="1">
		<tr>
			<th>Category Id</th>
			<th>Category Name</th>
			<th>Category Description</th>
			<th>Action</th>
		</tr>
		<c:forEach var="category" items="${categories}">
			<tr>
				<td>${category.id}</td>
				<td>${category.name}</td>
				<td>${category.discription}</td>
				<td><a href="/category/delete/${category.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

	<h2>Products</h2>

	<form action="/product/create" method="post">
		Name: <input type="text" required="true" name="name"> <br>
		Description: <input type="text" name="discription"> <br>
		Category <select required="true" name="category_name">
			<option value="">Choose the category</option>
			<c:forEach var="category" items="${categories}">
				<option value="${category.name}">${category.name}</option>
			</c:forEach>
		</select><br> Price:<input type="number" name="price" required="required" />
		<input type="submit" value="Create">
	</form>

	<table border="1">
		<tr>
			<th>Product Id</th>
			<th>Shoe Name</th>
			<th>Shoe Description</th>
			<th>Shoe price</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${product.id}</td>
				<td>${product.name}</td>
				<td>${product.discription}</td>
				<td>${product.price}</td>
				<td><a href="/product/update/${product.id}">Update</a></td>
				<td><a href="/product/delete/${product.id}">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="/admin/logout">Logout</a>
</body>
</html>

