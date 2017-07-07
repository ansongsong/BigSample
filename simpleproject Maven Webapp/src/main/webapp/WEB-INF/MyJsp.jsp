<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>aaa</title>
	</head>
	<body>
		<a href="../j_spring_security_logout">logout</a>
		<hr>
		Input form:
		<hr>
		<sec:authorize access="hasRole('ROLE_USER')">
			<s:form>
				username:<s:input path="username"/>
				<br>
				password:<s:input path="password"/>
				<br>
				<s:button value="submit">submit</s:button>
			</s:form>
		</sec:authorize>
	</body>
</html>

