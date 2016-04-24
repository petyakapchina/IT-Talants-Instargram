<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
<link rel="stylesheet" type="text/css" href="./css/main.css" />
<link rel="stylesheet" type="text/css" href="./css/forProfile.css" />
<link rel="stylesheet" type="text/css"
	href="./css/forProfileUsername.css" />
</head>
<body>
	<jsp:include page="partials/header2.jsp" />
	<div>
		<form method=post action="./editUsername">

			<table class="menu2">
				<tr>
					<td>First name</td>
					<td>:</td>
					<td>${first}</td>
					<td><input type="text" placeholder="New first name"
						name="newFirstName" /></td>
				</tr>
				<tr>
					<td>Last name</td>
					<td>:</td>
					<td>${last}</td>
					<td><input type="text" placeholder="New last name"
						name="newFirstName" /></td>
				</tr>
				<tr>
					<td>Username</td>
					<td>:</td>
					<td>${user}</td>
					<td><input type="text" placeholder="New username"
						name="newFirstName" /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td>${email}</td>
					<td><input type="text" placeholder="New email"
						name="newFirstName" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td>${password}</td>
					<td><input type="text" placeholder="New password"
						name="newFirstName" /></td>
				</tr>
				<tr>
					<td>Profile photo</td>
					<td>:</td>
					<td>Photo</td>
					<td><input type="text" placeholder="New photo"
						name="newFirstName" /></td>
				</tr>
			</table>

		</form>
	</div>
	</div>
</body>
<div></div>
<footer class="media"> <a href="http://www.facebook.com">Facebook</a>
<a href="http://www.tweeter.com">Tweeter</a> <br>
&copy;2016 Instagram </footer>
</html>