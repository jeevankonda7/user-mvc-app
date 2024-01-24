<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Form</title>
<style>
body {
	font-family: Arial, sans-serif;
	display: flex;
	align-items: center;
	justify-content: center;
	height: 100vh;
	margin: 0;
}

form {
	width: 300px;
	padding: 20px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f8f8f8;
}

label {
	display: block;
	margin-bottom: 8px;
}

input {
	width: 100%;
	padding: 8px;
	margin-bottom: 15px;
	box-sizing: border-box;
}

input[type="submit"] {
	background-color: #4caf50;
	color: white;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #45a049;
}
</style>
</head>
<body>



	<form:form modelAttribute="user" method="post" action="save">
		<h2>User Details Form</h2>


		<form:input path="id" value="${user.getId()}"
			cssStyle="display: none;" />
		<br />
		<br />
		<label for="name">name:</label>
		<form:input path="name" value="${user.getName()}" />

		<br />

		<label for="phone">phone:</label>
		<form:input path="phone" value="${user.getPhone()}" />

		<br />

		<label for="email">email:</label>
		<form:input path="email" value="${user.getEmail()}" />


		<br />

		<input type="submit" value="Insert" />
	</form:form>

</body>
</html>
