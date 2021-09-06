<%@page import="com.technoelevate.controller.employeedto.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%EmployeeInfoBean myEmployeeObject =(EmployeeInfoBean) request.getAttribute("from2ndSession");%>
<body>

<h1>Welcome <%=myEmployeeObject.getFname() %>!</h1>
<p> Nice to have you back. Have fun!</p>

Please <a href="./add">click here</a> to add another Employee:
 <tr>
	<td><a href="./logout"><input type="submit" value="Logout"/></a></td>
</tr>

</body>
</html>