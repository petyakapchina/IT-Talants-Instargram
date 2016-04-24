<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<body>
	<header>
		<div class="lable">
			<h1>Instagram</h1>
		</div>
	</header>

	<div class="content">
		<div class="menu">
			<nav>
				<h1>Welcome, ${user}!</h1>
				<ul>
					<li><a href="./home">Home</a></li>
					<li><a href="../html/Search.html">Search</a></li>
					<li><a href="./editProfile">Edit Profile</a></li>
					<li><a href="../html/ActivityNewSusbs.html">My Activity</a></li>
					<li><a href="../html/UploadPhoto.html">Upload photo</a></li>
					<li><a href="./login">Log out</a></li>
				</ul>
			</nav>
		</div>
	</div>