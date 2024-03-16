<%@page import="java.util.Vector"%>
<%@page import="entity.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<main id="main" class="main" style="margin-top: 50px">
		<%
		Vector<Product> cVector = (Vector<Product>) request.getAttribute("cVector");
		%>
		<div class="card">
			<div class="card-body">
				<h5 class="card-title">${productID}</h5>

				<!-- Table with hoverable rows -->
				<table class="table table-hover" border="1">
					<thead>
						<tr>
							<th style="vertical-align: middle">ID</th>
							<th style="vertical-align: middle;">Name</th>
							<th style="vertical-align: middle;">Model</th>
							<th style="vertical-align: middle;">Price</th>
							<th style="vertical-align: middle;">Brand</th>
							<th style="vertical-align: middle;">Category</th>
							<th style="vertical-align: middle;">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (Product pro : cVector) {
						%>
						<tr>
							<td><%=pro.getProductId()%></td>
							<td><%=pro.getProductName()%></td>
							<td><%=pro.getModelYear()%></td>
							<td><%=pro.getListPrice()%></td>
							<td><%=pro.getBrandName()%></td>
							<td><%=pro.getCategoryName()%></td>
							<td>
								<form action="AddToCartController" method="POST">
									<input type="hidden" name="productId" value="<%=pro.getProductId()%>">
									<button class="btn btn-sm btn-primary">Add To Cart</button>
								</form>
							</td>
						</tr>
						<%}%>
					</tbody>
				</table>
			</div>
		</div>
	</main>
	<!-- End #main -->
</body>
</html>
