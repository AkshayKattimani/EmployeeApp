<%@page import="com.technoelevate.controller.employeedto.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
EmployeeInfoBean eib = (EmployeeInfoBean) request.getAttribute("AddedEmployee");
String msg = (String) request.getAttribute("msg");
%>
<body>
<%=msg %>
<h1>Below Employee has been added:<br><br>

Name  =  <%=eib.getFname() %>, <%=eib.getLname() %>
</body>
</html>