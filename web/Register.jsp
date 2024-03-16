<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Register</title>

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
  <main>
    <div class="container">
      <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
        <div class="container">
          <div class="row justify-content-center">
            <div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">

              <div class="d-flex justify-content-center py-4">
                <a href="MainController" class="logo d-flex align-items-center w-auto">
                  <img src="./assets/img/logo.png" alt="">
                  <span class="d-none d-lg-block">ABShop</span>
                </a>
              </div><!-- End Logo -->

              <div class="card mb-3">

                <div class="card-body">

                  <div class="pt-4 pb-2">
                    <h5 class="card-title text-center pb-0 fs-4">Create an Account</h5>
                    <c:if test="${registerMes == null }">
                    	<p class="text-center small">Enter your personal details to create account</p>
                    </c:if>
                    <p class="text-center small" style="color: red;">${registerMes}</p>
                  </div>

                  <form class="row g-3 needs-validation" action="RegisterController" method="POST">
                    <div class="col-12" style="margin-bottom: 5px;">
                      <label for="yourUsername" class="form-label">Username</label>
                      <div class="input-group has-validation">
                        <input type="text" name="username" class="form-control" id="yourUsername" value="${username}" required>
                      </div>
                    </div>

                    <div class="col-12">
                      <label for="yourPassword" class="form-label">Password</label>
                      <input type="password" name="password" class="form-control" id="yourPassword" value="${password}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourName" class="form-label">Your First Name</label>
                      <input type="text" name="firstName" class="form-control" id="yourName" value="${firstName}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourName" class="form-label">Your Last Name</label>
                      <input type="text" name="lastName" class="form-control" id="yourName" value="${lastName}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Your Phone</label>
                      <input type="text" name="phone" class="form-control" id="yourEmail" value="${phone}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Your Email</label>
                      <input type="email" name="email" class="form-control" id="yourEmail" value="${email}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Your Street</label>
                      <input type="text" name="street" class="form-control" id="yourEmail" value="${street}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Your City</label>
                      <input type="text" name="city" class="form-control" id="yourEmail" value="${city}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Your State</label>
                      <input type="text" name="state" class="form-control" id="yourEmail" value="${state}" required>
                    </div>

                    <div class="col-12">
                      <label for="yourEmail" class="form-label">Your Zip Code</label>
                      <input type="text" name="zipcode" class="form-control" id="yourEmail" value="${zipcode}" required>
                    </div>

                    <div class="col-12">
                      <button class="btn btn-primary w-100" type="submit">Create Account</button>
                    </div>
                    <div class="col-12">
                      <p class="small mb-0">Already have an account? <a href="LoginController">Log in</a></p>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </main><!-- End #main -->
</body>
</html>