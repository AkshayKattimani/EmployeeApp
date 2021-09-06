<%@page import="com.technoelevate.controller.employeedto.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<%EmployeeInfoBean myObject =(EmployeeInfoBean) request.getAttribute("My AddSessionAttribute");
	
%>
</head>
<body>
<fieldset>
	<legend>Enter Employee Details</legend>
		<form action="./add" method="post">
			<table>
					<tr>
						<td>Employee Id</td>
						<td>:</td>
						<td><input type="number" name="id"/></td>
					</tr>
					<tr>
						<td>Employee Name</td>
						<td>:</td>
						<td><input type="text" name="fname"/></td>
					</tr>
					<tr>
					
						<td>Password</td>
						<td>:</td>
						<td><input type="password" name="password"/></td>
					</tr>
					<tr>
						<td><input type="submit" value="Register"></td>
					</tr>
			</table>
		</form>
</fieldset>

</body>
</html>