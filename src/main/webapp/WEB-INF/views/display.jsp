<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>

	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
  table {
    margin: 0 auto; 
    border-collapse: collapse;
    width: 60%;
  }

  th, td {
    text-align: center; 
    padding: 10px; 
  }
  
  button {
    display: block;
    margin: 8px auto; 
    width: 90px;
    background-color: green;
    height:30px;
    border: 2px solid black;
    border-radius: 5px;
  }
  .delete{
  display: block;
    margin: 20px auto; 
    width: 90px;
    background-color: red;
    height:30px;
    border: 2px solid black;
    border-radius: 5px;
  }

  a {
    text-decoration: none; 
    color: white;
    font-weight: bold;
  }
</style>

</head>
<body>
	<table border="1">
	<h3 align="center">user details</h3>
		<tr>
			<th>name</th>
			<th>phone</th>
			<th>email</th>
		</tr>

		<c:forEach var="u" items="${user}">
			<tr>
				<td>${u.getName()}</td>
				<td>${u.getPhone()}</td>
				<td>${u.getEmail()}</td>
				<td><button><a href="update?id=${u.getId()}">Update</a></button>
				<td><button class="delete"><a href="delete?id=${u.getId()}">Delete</a></button>
			</tr>
		</c:forEach>
	</table>
	<button>
		<a href="create?page=create">Create</a>
	</button>
</body>
</html>