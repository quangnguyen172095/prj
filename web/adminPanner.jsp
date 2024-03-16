<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<link href="./assets/img/favicon.png" rel="icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="./assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="./assets/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="./assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">

<!-- Template Main CSS File -->
<link href="./assets/css/style.css" rel="stylesheet">
</head>
<body>
	<header id="header" class="header fixed-top d-flex align-items-center">
		<div class="d-flex align-items-center justify-content-between">
			<a href="AdminController" class="logo d-flex align-items-center">
				<img src="./assets/img/logo.png" alt="My logo"> <span
				class="d-none d-lg-block">ABShop</span>
			</a> <i class="bi bi-list toggle-sidebar-btn"></i>
		</div>
		<!-- End Logo -->

		<nav class="header-nav ms-auto">
			<ul class="d-flex align-items-center">

				<li class="nav-item d-block d-lg-none"><a
					class="nav-link nav-icon search-bar-toggle " href="#"> <i
						class="bi bi-search"></i>
				</a></li>
				<!-- End Search Icon-->

				<c:if test="${sessionScope.user != null}">
					<li class="nav-item dropdown pe-3"><a
						class="nav-link nav-profile d-flex align-items-center pe-0"
						href="#" data-bs-toggle="dropdown"> <img
							src="./assets/img/profile-img.jpg" alt="Profile"
							class="rounded-circle"> <span
							class="d-none d-md-block dropdown-toggle ps-2">${sessionScope.user.getDisplayName() }</span>
					</a> <!-- End Profile Iamge Icon -->

						<ul
							class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
							<li class="dropdown-header">
								<h6>Full name</h6> <span>Roll number</span>
							</li>
							<li>
								<hr class="dropdown-divider">
							</li>

							<li><a class="dropdown-item d-flex align-items-center"
								href="LogoutController"> <i class="bi bi-box-arrow-right"></i>
									<span>Log Out</span>
							</a></li>

						</ul> <!-- End Profile Dropdown Items --></li>
				</c:if>
				<!-- End Profile Nav -->

			</ul>
		</nav>
		<!-- End Icons Navigation -->
	</header>

	<script src="./assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="./assets/js/main.js"></script>
</body>
</html>