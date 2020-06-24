<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EverGreen Book Store Administrative</title>
</head>
<body>
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<h2>Administrative Dashboard</h2>
	</div>
	
	<div align="center">
		<hr width="60%" />
		<h2>Quick Actions:</h2>
		<b>
			<a href="create_book">New Book</a> &nbsp;
			<a href="user_form.jsp">New User</a> &nbsp;
			<a href="create_category">New Category</a> &nbsp;
			<a href="create_customer">New Customer</a> 
		</b>
	</div>
	
	<div align="center">
		<hr width="60%" />	
		<h2>Recent Sales:</h2>
	</div>
	
	<div align="center">
		<hr width="60%" />
		<h2>Recent Reviews:</h2>
	</div>
	
	<div align="center">
		<hr width="60%" />
		<h2>Statistics:</h2>
		<hr width="60%" />
	</div>
	<jsp:directive.include file="footer.jsp" />

</body>
</html>