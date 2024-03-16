<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<jsp:include page="adminPanner.jsp"></jsp:include></div>
	<div>
		<jsp:include page="adminMenu.jsp"></jsp:include></div>

	<main id="main" class="main" style="margin-top: 50px">
		<div class="card">
			<div class="card-body">
				<h5 class="card-title text-center">Bill Detail</h5>
				<!-- Table with hoverable rows -->
				<table class="table table-hover" border="1">
					<thead>
						<tr>
							<th style="vertical-align: middle">Item ID</th>
							<th style="vertical-align: middle;">Product</th>
							<th style="vertical-align: middle;">Quantity</th>
							<th style="vertical-align: middle;">Price</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="item" items="${orderItems}">
							<tr>
								<td>${item.getId()}</td>
								<td>${item.getProductName()}</td>
								<td>${item.getQuantity()}</td>
								<td>${item.getPrice()}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<form action="CartController" method="post">
					<div class="text-center">
						<div class="row mb-3">
							<label class="col-sm-2 col-form-label">Status</label>
							<div class="col-sm-10">
								<select class="form-select" aria-label="Default select example"
									name="status">
									<c:choose>
										<c:when test="${status == 2}">
											<option value="2" class="bg-info text-dark" selected>Wait</option>
										</c:when>
										<c:otherwise>
											<option value="2" class="bg-info text-dark">Wait</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${status == 3}">
											<option value="3" selected class="bg-warning text-dark">Process</option>
										</c:when>
										<c:otherwise>
											<option value="3" class="bg-warning text-dark">Process</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${status == 4}">
											<option value="4" selected class="bg-success">Done</option>
										</c:when>
										<c:otherwise>
											<option value="4" class="bg-success">Done</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
						</div>
						<input type="hidden" name="orderId" value="${orderId}">
						<button class="btn btn-sm btn-success text-bold">Update</button>
					</div>
				</form>
			</div>
		</div>
	</main>
</body>
</html>