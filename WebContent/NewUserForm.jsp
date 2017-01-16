<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name="frmNewUser" method="POST" action="api/v1/newuser">

<table>
	<tr>
		<td>User name</td><td><input name="userName"></td>
	</tr>

	<tr>
		<td>First Name</td><td><input name="firstName"></td>
	</tr>
	
	<tr>
		<td>Last Name</td><td><input name="lastName"></td>
	</tr>
	
	<tr>
		<td>&nbsp;</td><td><input type="submit"></td>
	</tr>
</table>

</form>

</body>
</html>