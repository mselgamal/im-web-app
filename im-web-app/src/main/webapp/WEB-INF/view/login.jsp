<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
	<body>
		<form:form action="${pageContext.request.contextPath}/authenticateUser"
			method="POST">
			<p>
				User name: <input type="text" name="username"/>
			</p>
			<p>
				Password: <input type="text" name="password"/>
			</p>
			<input type="submit" value="Login"/>
		</form:form>
	</body>
</html>