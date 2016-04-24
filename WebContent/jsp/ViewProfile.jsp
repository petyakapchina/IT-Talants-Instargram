<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="UTF-8">

<title>MyProfile</title>
<link rel='stylesheet prefetch'
	href='http://mustafaismail.co/wp-content/uploads/gothamrnd/gothamrnd.css'>

<link rel="stylesheet" href="../css/style.css" media="screen"
	type="text/css" />

<link rel="stylesheet" type="text/css" href="../css/main.css" />

</head>
<body>

	<jsp:include page="header.jsp" />

	<section> <header class="clearfix">
	<div class="liks">
		<i class="icon"></i> <span>${followers}</span>
	</div>
	<div class="user">
		<div class="avatar">
			<img>
		</div>
		<h2>${user}</h2>
		<form class="follow" method="post" action="./follow" user=${}>
			<a href="#" class="follow"><span>+</span>Follow</a>
		</form>
		<form class="unfollow">
			<a href="#" class="follow" id="un"><span>-</span>Unfollow</a>
		</form>
	</div>

	</header>

	<ul class="menu">
		<li><a href="../html/PhotoGallery.html" class="active profile">Photos</a></li>
	</ul>

	</section>


</body>

</html>