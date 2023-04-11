<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<main id="adminLogin" class="wrapper">
		<h3>${message}</h3>
		<h2 class="title">Admin Login</h2>
		<form action="/admin/authenticate" method="post">
			<label for="username">Username: </label> <input type="email"
				placeholder="Username" id="username" name="email" /> <br> <label
				for="password">Password: </label> <input type="password"
				placeholder="Password" id="password" name="password" /><br> <input
				type="submit" value="Login" />
		</form>
		<p>Or</p>
		<a href="/home">Go to Home</a>
	</main>
</body>
</html>