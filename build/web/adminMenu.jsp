<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<aside id="sidebar" class="sidebar">
		<%
		String service = request.getAttribute("service") == null ? "customer" : request.getAttribute("service").toString();
		%>
		<ul class="sidebar-nav" id="sidebar-nav">
			<!-- Customer -->
			<%
				if (service.trim().equalsIgnoreCase("customer")) {
			%>
			<li class="nav-item">
				<a class="nav-link"	href="AdminController?service=customer">
			<%} else {%>			
			<li class="nav-item">
				<a class="nav-link collapsed" href="AdminController?service=customer">
			<%}%>

					<i class="bi bi-grid"></i>
					<span>Customer Manager</span>
				</a>
			</li>
			<!-- Product -->
			<%
				if (service.trim().equalsIgnoreCase("product")) {
			%>
			<li class="nav-item">
				<a class="nav-link"	href="AdminController?service=product">
			<%} else {%>			
			<li class="nav-item">
				<a class="nav-link collapsed" href="AdminController?service=product">
			<%}%>

					<i class="bi bi-grid"></i>
					<span>Product Manager</span>
				</a>
			</li>
			<!-- Bill -->
			<%
				if (service.trim().equalsIgnoreCase("bill")) {
			%>
			<li class="nav-item">
				<a class="nav-link"	href="AdminController?service=bill">
			<%} else {%>			
			<li class="nav-item">
				<a class="nav-link collapsed" href="AdminController?service=bill">
			<%}%>

					<i class="bi bi-grid"></i>
					<span>Bill Manager</span>
				</a>
			</li>
		</ul>
	</aside>
</body>
</html>
