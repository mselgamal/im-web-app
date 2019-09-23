<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Sign Up</title>
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<!-- Bootstrap core CSS -->
		<link href="<c:url value="/resources/css/lib/bootstrap.min.css"/>" type="text/css" rel="stylesheet">
		<!-- Swipe core CSS -->
		<link href="<c:url value="/resources/css/swipe.min.css"/>" type="text/css" rel="stylesheet">
		<!-- Favicon -->
		<link href="<c:url value="/resources/img/favicon.png"/>" type="image/png" rel="icon">
	</head>
	<body>
		<!-- Start of Sign Up -->
		<div class="sign">
			<div class="container">
				<div class="item">
					<form:form action="${pageContext.request.contextPath}/registration/registerUser" 
					th:object="${chatUser}" method="POST">
						<h2>Sign Up</h2>

						<c:if test="${error != null}">
							<div class="form-group">
								<span class="alert alert-danger">${error}</span>
							</div>
						</c:if>

						<span>
							<form:errors path="*" class="has-error alert alert-danger" />
						</span>
						<div class="form-group">
							<input class="form-control" th:field="${firstName}" placeholder="Firstname" required/>
							<button class="btn prepend" disabled="true"><i data-eva="person"></i></button>
						</div>
						<div class="form-group">
							<input class="form-control" path="lastName" placeholder="Lastname" required/>
							<button class="btn prepend" disabled="true"><i data-eva="person"></i></button>
						</div>
						<div class="form-group">
							<input class="form-control" path="email" placeholder="Email Address" required/>
							<button class="btn prepend" disabled="true"><i data-eva="email"></i></button>
						</div>
						<div class="form-group">
							<input class="form-control" path="userName" placeholder="Username" required/>
							<button class="btn prepend" disabled="true"><i data-eva="person"></i></button>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" path="password" placeholder="Password" required/>
							<button class="btn prepend" disabled="true"><i data-eva="lock"></i></button>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" path="matchingPassword" placeholder="Re-enter Password" required/>
							<button class="btn prepend" disabled="true"><i data-eva="lock"></i></button>
						</div>
						<button type="submit" class="btn primary">Create account</button>
						<span>Already a member? 
							<a href="<c:url value="/login.jsp"/>">Sign In.</a>
						</span>
					</form:form>
				</div>
			</div>
		</div>
		<!-- End of Sign Up -->
		<script src="<c:url value="/resources/js/vendor/jquery-slim.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/popper.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/feather.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/eva.min.js"/>"></script>
		<script src="<c:url value="/resources/js/vendor/bootstrap.min.js"/>"></script>
		<script src="<c:url value="/resources/js/swipe.min.js"/>"></script>
	</body>
</html>																																																						