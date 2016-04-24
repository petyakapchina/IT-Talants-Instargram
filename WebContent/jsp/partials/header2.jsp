<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<div class="menu1">
	<h3>Profile outlook</h3>
	<nav>
		<ul>
			<li class="menu2"><a href="./myProfile">My profile</a></li>
			<li class="menu2"><a href="./editProfile">Edit profile</a></li>

		</ul>
	</nav>
</div>