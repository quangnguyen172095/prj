<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<main id="main" class="main" style="margin-top: 50px">
		<c:if test="${service == 'customer'}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">All Customers</h5>
					<form method="GET" action="AdminController">
						<input type="hidden" name="service" value="${service}">
						<div class="input-group" style="margin-bottom: 20px">
							<input type="search" class="form-control rounded"
								placeholder="Enter to search" aria-label="Search"
								aria-describedby="search-addon" name="search" value="${search}" />
							<button type="button" class="btn btn-outline-primary">Search</button>
						</div>
					</form>
					<!-- Table with hoverable rows -->
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th style="vertical-align: middle">ID</th>
								<th style="vertical-align: middle;">Name</th>
								<th style="vertical-align: middle;">Phone</th>
								<th style="vertical-align: middle;">Email</th>
								<th style="vertical-align: middle;">Street</th>
								<th style="vertical-align: middle;">City</th>
								<th style="vertical-align: middle;">State</th>
								<th style="vertical-align: middle;">Zip_code</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="cus" items="${customers}">
								<tr>
									<td>${cus.getId()}</td>
									<td>${cus.getFirstName()} ${cus.getLastName()}</td>
									<td>${cus.getPhone()}</td>
									<td>${cus.getEmail()}</td>
									<td>${cus.getStreet()}</td>
									<td>${cus.getCity()}</td>
									<td>${cus.getState()}</td>
									<td>${cus.getZipCode()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
		
	
		<c:if test="${service == 'product'}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">All Products</h5>
					<form method="GET" action="AdminController">
						<input type="hidden" name="service" value="${service}">
						<div class="input-group" style="margin-bottom: 20px">
							<input type="search" class="form-control rounded"
								placeholder="Enter to search" aria-label="Search"
								aria-describedby="search-addon" name="search" value="${search}" />
							<button type="button" class="btn btn-outline-primary">Search</button>
						</div>
					</form>
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
							</tr>
						</thead>
						<tbody>
							<c:forEach var="pro" items="${products}">
								<tr>
									<td>${pro.getProductId()}</td>
									<td>${pro.getProductName()}</td>
									<td>${pro.getModelYear()}</td>
									<td>${pro.getListPrice()}</td>
									<td>${pro.getBrandName()}</td>
									<td>${pro.getCategoryName()}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
		
		
		<c:if test="${service == 'bill'}">
			<div class="card">
				<div class="card-body">
					<h5 class="card-title">All Products</h5>
					<form method="GET" action="AdminController">
						<input type="hidden" name="service" value="${service}">
						<div class="input-group" style="margin-bottom: 20px">
							<input type="search" class="form-control rounded"
								placeholder="Enter to search" aria-label="Search"
								aria-describedby="search-addon" name="search" value="${search}" />
							<button type="button" class="btn btn-outline-primary">Search</button>
						</div>
					</form>
					<!-- Table with hoverable rows -->
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th style="vertical-align: middle">Bill ID</th>
								<th style="vertical-align: middle;">Customer Name</th>
								<th style="vertical-align: middle;">Date</th>
								<th style="vertical-align: middle;">Total</th>
								<th style="vertical-align: middle;">Status</th>
								<th style="vertical-align: middle;">View</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="bill" items="${bills}">
								<tr>
									<td>${bill.getId()}</td>
									<td>${bill.getCustomerName()}</td>
									<td>${bill.getDate()}</td>
									<td>${bill.getTotal()}</td>
									<td>
										<c:choose>
									       <c:when test = "${bill.getStatus() == 2}">
									            <span class="badge bg-info text-dark">Wait</span>
									       </c:when>
									       <c:when test = "${bill.getStatus() == 3}">
									            <span class="badge bg-warning text-dark">Process</span>
									       </c:when>
									       <c:when test = "${bill.getStatus() == 4}">
									            <span class="badge bg-success">Done</span>
									       </c:when>
									       <c:otherwise>
									            <span class="badge bg-primary">Wait</span>
									       </c:otherwise>
									    </c:choose>
									</td>
									<td>
										<form action="DetailBillController" method="POST">
											<input type="hidden" name="orderId" value="${bill.getId()}">
											<button class="btn btn-sm btn-primary">Detail</button>
										</form>									
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	
	</main>
	<!-- End #main -->
</body>
</html>
