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
		ResultSet cRs = (ResultSet) request.getAttribute("cRs");
		String productID = request.getAttribute("productID").toString();
		%>
		<ul class="sidebar-nav" id="sidebar-nav">
			<%
			while (cRs.next()) {
				if (productID.trim().equalsIgnoreCase(cRs.getString(1).trim())) {
			%>
			<li class="nav-item">
				<a class="nav-link"	href="MainController?service=displayProduct&id=<%=cRs.getString(1).trim()%>&search=${search}">
			<%} else {%>
			<li class="nav-item">
				<a class="nav-link collapsed" href="MainController?service=displayProduct&id=<%=cRs.getString(1).trim()%>&search=${search}">
			<%}%>
					<i class="bi bi-grid"></i>
					<span><%=cRs.getString(1).trim()%></span>
				</a>
			</li>
			<%}%>
		</ul>
	</aside>
</body>
</html>
