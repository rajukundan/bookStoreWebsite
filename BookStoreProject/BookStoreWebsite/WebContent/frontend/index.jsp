<!--This is the Default Home Page for front End user-->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RUR - Read Use ReUse Book Store</title>
</head>
<body>
	<!--jsp:directive.include will add the jsp file to this location  -->
	<jsp:directive.include file="header.jsp" />

	<div align="center">
		<br>
		<h3>This is main content:</h3>
		<h2>New Books:</h2>
		<h2>Best Selling Books:</h2>
		<h2>New Books:</h2>
		<h2>Most Favored Books</h2>
		<br>
		<br>
	</div>

	<jsp:directive.include file="footer.jsp" />

</body>
</html>