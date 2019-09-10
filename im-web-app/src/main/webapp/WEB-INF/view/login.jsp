<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>IM Web App</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap core CSS -->
		<link href="<c:url value="/resources/css/lib/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
		<!-- Swipe core CSS -->
		<link href="<c:url value="/resources/css/swipe.min.css"/>" type="text/css" rel="stylesheet">
		<!-- Favicon -->
		<link href="<c:url value="/resources/img/favicon.png"/>" type="image/png" rel="icon">
	</head>
	<body>
		<!-- Start of Sign In -->
		<div class="sign">
			<div class="container">
				<div class="item">
					<form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
						<h2>Login</h2>
						<c:if test="${param.error != null}">
							<div>
								<span class="alert alert-danger ">Invalid Username or Password.</span>
							</div>
						</c:if>
						<c:if test="${param.signout != null}">
							<div>
								<span class="alert alert-success ">You Have Been Logged Out.</span>
							</div>
						</c:if>
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Username" name="username" required autofocus>
							<button class="btn prepend"><i data-eva="person"></i></button>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password" name="password" required>
							<button class="btn prepend"><i data-eva="lock"></i></button>
						</div>
						<a href="#">Forgot Password?</a>
						<button type="submit" class="btn primary">Sign In</button>
						<span>Don't have account? <a href="#">Create Account.</a></span>
					</form:form>
				</div>
			</div>
		</div>
		<!-- End of Sign In -->
		<script src="<c:url value="/resources/js/vendor/jquery-slim.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/popper.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/feather.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/eva.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/resources/js/swipe.min.js"/>"></script>
	</body>
</html>																																																					