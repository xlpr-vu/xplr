<%@page import="com.xlpr.model.Event"%>
<%@ page language="java" import="java.util.*"%>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags"%>
<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/event.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="css/chart.css">
<script type="text/javascript" src="javascripts/data/coordinates.js"></script>
</head>

<meta name="viewport" content="width=device-width, initial-scale=1">


<body>


	<div id="mySidenav" class="sidenav">

		<a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
		<a href="#">${facebook.name}</a> <a href="#">My Profile</a> <a
			href="#">My Events</a> <a href="#">My Routes</a> <a href="index.html">Logout</a>
	</div>

	<span style="font-size: 30px; cursor: pointer" onclick="openNav()">&#9776;</span>
	<script>
		function openNav() {
			document.getElementById("mySidenav").style.width = "250px";
		}

		function closeNav() {
			document.getElementById("mySidenav").style.width = "0";
		}
	</script>

	<div class="logo">
		<img src="./img/logo_blue.png">
	</div>

	<%-- <%  
        List myList = (List)request.getSession().getAttribute("event");       
        %>  
        <p>  
            list<%=myList %>  
        </p> 
<h>${fn:length(requestScope.event)}</h> --%>
	<div class="slideshow-container">
		<c:forEach items="${event}" var="user" varStatus="id">
			<div class="mySlides fade">

				<img src="<c:out value="${user.img}" />" style="width: 100%">
				<div class="text">
					<table style="text-align: left;">
						<tr>
							<td><c:out value="${user.title}" /></td>
						</tr>
						<tr>
							<td>${user.short_description}"</td>
						</tr>
						<tr>
							<td>${user.address}</td>
						</tr>
						<tr>
							<td>from ${user.begin_date} to ${user.end_date}</td>
						</tr>
						<tr>
							<td>Contact Email: ${user.contact_email}</td>
						</tr>
					</table>
				</div>
			</div>
			<a class="prev" onclick="plusSlides(1)">&#120;</a>
			<a class="next" onclick="plusSlides(1)">&#10084;</a>
		</c:forEach>

	</div>
	<br>

	<script>
		var slideIndex = 1;
		showSlides(slideIndex);

		function plusSlides(n) {
			showSlides(slideIndex += n);
		}

		function currentSlide(n) {
			showSlides(slideIndex = n);
		}

		function showSlides(n) {
			var i;
			var slides = document.getElementsByClassName("mySlides");
			if (n > slides.length) {
				slideIndex = 1
			}

			if (n < 1) {
				slideIndex = slides.length
			}

			for (i = 0; i < slides.length; i++) {
				slides[i].style.display = "none";
			}
			slides[slideIndex - 1].style.display = "block";

		}
	</script>

</body>
</html>
