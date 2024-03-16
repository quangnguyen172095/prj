<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AB Shop Homepage</title>
<link href="./assets/img/favicon.png" rel="icon">
</head>
<body>
	<div>
		<jsp:include page="Panner.jsp"></jsp:include>
	</div>

	<div>
		<jsp:include page="Menu.jsp"></jsp:include>
	</div>

	<main id="main" class="main" style="margin-top: 60px;">
		<div class="card">
			<form action="UpdateCartController" method="POST">
				<div class="card-body">
					<h5 class="card-title">Show Cart</h5>

					<!-- Table with hoverable rows -->
					<table class="table table-hover" border="1">
						<thead>
							<tr>
								<th style="vertical-align: middle">ID</th>
								<th style="vertical-align: middle;">Name</th>
								<th style="vertical-align: middle;">Quantity</th>
								<th style="vertical-align: middle;">Price</th>
								<th style="vertical-align: middle;">Total</th>
								<th style="vertical-align: middle;">Remove</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="item" items="${sessionScope.order.getItems()}">
								<tr>
									<td>${item.getProductId()}</td>
									<td>${item.getProductName()}</td>
									<td><input type="number" name="${item.getProductId()}"
										value="${item.getQuantity()}"></td>
									<td>${item.getPrice()}</td>
									<td>${item.getQuantity() * item.getPrice()}</td>
									<td><a class="btn btn-sm btn-primary"
										href="RemoveCartController?productId=${item.getProductId()}">Remove</a>
									</td>
								</tr>
							</c:forEach>
							<c:if test="${sessionScope.order.getTotalQuantity() > 0}">
								<tr>
									<td colspan="4" style="text-align: center;"><b>Total</b></td>
									<td>${sessionScope.order.getTotalPrice()}</td>
									<td><a class="btn btn-sm btn-primary"
										href="RemoveCartController?productId=-1">Remove All</a></td>
								</tr>
							</c:if>
							<c:if test="${sessionScope.order.getTotalQuantity() == 0}">
								<tr>
									<td colspan="6" style="text-align: center;"><b>No
											items in cart!</b></td>
								</tr>
							</c:if>
						</tbody>
					</table>
					<div class="text-center">
						<button class="btn btn-sm btn-warning text-dark me-3">Update</button>
						<a class="btn btn-sm btn-success text-bold"
										href="CheckoutCartController">Checkout</a>
					</div>
				</div>
			</form>
		</div>
	</main>
	<!-- End #main -->
</body>
</html>