<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
  <meta charset="UTF-8">
  <title>xplr Create Event</title>
  
  
  <link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Open+Sans:600'>

  <link rel="stylesheet" href="css/CreateEvent.css">

  
</head>

<body>

  <div class="login-wrap">



	<div class="login-html">
		<div class="logo"><img src="./img/logo_blue.png"></div>
			<form method="POST" action="UserController">
				<input id="tab-1" type="radio" name="tab" class="sign-in" checked><label
					for="tab-1" class="tab">Create your event</label>

				<div class="login-form">
					<div class="group">
						<label for="eventtitle" class="label">Title of Event</label> <input
							id="eventtitle" name="title" type="text" class="input">
					</div>
					<div class="group">
						<label for="EventImg" class="label">Image Link</label> <input
							id="EventImg" name="img" type="text" class="input">
					</div>
					<div class="group">
						<label for="DescriptionShort" class="label">Short
							Description</label> <input id="DescriptionShort" name="short_description"
							type="text" class="input">
					</div>
					<div class="group">
						<label for="DescriptionLong" class="label">Long
							Description - At least 150 words</label> <input id="DescriptionLong"
							name="long_description" type="text" class="input">
					</div>
					<div class="group">
						<label for="BeginningDate" class="label">Begin date</label> <input
							id="BeginningDate" name="begin_date" type="date" class="short">
					</div>
					<div class="group">
						<label for="EndingDate" class="label">End Date</label> <input
							id="EndingDate" name="end_date" type="date" class="short">
					</div>
					<div class="group">
						<label for="email" class="label">Address</label> <input id="email"
							name="address" type="email" class="input">
					</div>
					<div class="group">
						<label for="email" class="label">Contact Email</label> <input
							id="email" name="contact_email" type="email" class="input">
					</div>
					<div class="group">
						<label for="email" class="label">Longitude</label> <input
							id="email" name="longitude" type="email" class="input">
					</div>
					<div class="group">
						<label for="email" class="label">Latitude</label> <input
							id="email" name="latitude" type="email" class="input">
					</div>


					<div class="group">
						<input type="submit" class="button" value="Create">
					</div>
					<div class="hr"></div>
				</div>
			</form>
		</div>
</div>
  
  
</body>
</html>
