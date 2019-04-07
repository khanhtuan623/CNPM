<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Car</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" href="fonts/icomoon/style.css">

<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/magnific-popup.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/jquery-ui.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/owl.carousel.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/owl.theme.default.min.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/bootstrap-datepicker.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/animate.css"/>">


<link rel="stylesheet"
	href="<c:url value="/resources/fonts/flaticon/font/flaticon.css"/>">
<link rel="stylesheet"
	href="<c:url value="/resources/css/fl-bigmug-line.css"/>">

<link rel="stylesheet" href="<c:url value="/resources/css/aos.css"/>">

<link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>">

</head>
<body>
 
	<div class="site-wrap">

		<div class="site-mobile-menu">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>

		<header class="site-navbar py-1" role="banner">

		<div class="container">
			<div class="row align-items-center">

				<div class="col-6 col-xl-2">
					<h1 class="mb-0">
						<a href="#" class="text-black h2 mb-0">New Car</a>
					</h1>
				</div>

				<div class="col-10 col-xl-10 d-none d-xl-block">
					<nav class="site-navigation text-right" role="navigation">

					<ul class="site-menu js-clone-nav mr-auto d-none d-lg-block">
						<li><a href="/"><span
								class="rounded bg-primary py-2 px-3 text-white"><span
									class="h5 mr-2"></span> Log Out</span></a></li>
					</ul>
					</nav>
				</div>

				<div class="col-6 col-xl-2 text-right d-block">

					<div class="d-inline-block d-xl-none ml-md-0 mr-auto py-3"
						style="position: relative; top: 3px;">
						<a href="#" class="site-menu-toggle js-menu-toggle text-black"><span
							class="icon-menu h3"></span></a>
					</div>

				</div>

			</div>
		</div>

		</header>
		<div class="site-section bg-light">
			<div class="container">
				<div class="col-md-12 col-lg-12 mb-5">

					<form:form action="${action}" class="p-5 bg-white" method="POST"
						enctype="multipart/form-data" modelAttribute="${attribute}">
						<form:hidden path="idTicket"/>
						<div class="row form-group">
							<div class="col-md-12 mb-3 mb-md-0 style="text-align:center;>
								<div style="width: 40%; margin-left: 0%;">
									<label class="font-weight-bold" for="location">ID SCHEDULE</label>
									<form:select path="idSchedule" name="idSchedule" id="idSchedule"
										class="form-control">
										<c:forEach var="scheduleList" items="${scheduleList}">
										<form:option value="${scheduleList.idSchedule}">${scheduleList.idSchedule} &mdash; ${scheduleList.nameChannel}</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
						</div>
						
						<div class="row form-group">
							<div class="col-md-12 mb-3 mb-md-0 style="text-align:center;>
								<div style="width: 40%; margin-left: 0%;">
									<label class="font-weight-bold" for="fullname">STARTING POST</label>
									<form:input path="startingPost" type="text" id="startingPost"
										class="form-control" required="required"
										placeholder="eg. Ben Xe Mien Dong,292 Dinh Bo Linh,P.26,Q.Binh Thanh,TP.HCM" />
								</div>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12 mb-3 mb-md-0 style="text-align:center;>
								<div style="width: 40%; margin-left: 0%;">
									<label class="font-weight-bold" for="fullname">DESTINATION</label>
									<form:input path="destination" type="text" id="destination"
										class="form-control" required="required"
										placeholder="eg. Ben Xe My Dinh,My Dinh-Nam Tu Liem-Ha Noi" />
								</div>
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12 mb-3 mb-md-0 style="text-align:center;>
								<div style="width: 40%; margin-left: 0%;">
									<label class="font-weight-bold" for="price">PRICE</label>
									<form:input path="price" type="text" id="price"
										class="form-control" required="required"
										placeholder="eg. 99000" />
								</div>
							</div>
						</div>

						<div class="row form-group">
							<div class="col-md-12">
								<h3>NOTE</h3>
							</div>
							<div class="col-md-12 mb-3 mb-md-0">
								<form:textarea path="note" name="" class="form-control" id="note"
									cols="20" rows="7" required="required" />
							</div>
						</div>
						<div class="row form-group">
							<div class="col-md-12">
								<input type="submit" value="Save"
									class="btn btn-primary  py-2 px-5">
							</div>
						</div>
				</div>
				
				</form:form>
			</div>
		</div>
	</div>
	</div>
	</div>

	<script src="<c:url value="/resources/js/jquery-3.3.1.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/jquery-migrate-3.0.1.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery-ui.js"/>"></script>
	<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/owl.carousel.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.stellar.min.js"/>"></script>
	<script src="<c:url value="/resources/js/jquery.countdown.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/jquery.magnific-popup.min.js"/>"></script>
	<script
		src="<c:url value="/resources/js/bootstrap-datepicker.min.js"/>"></script>
	<script src="<c:url value="/resources/js/aos.js"/>"></script>


	<script src="<c:url value="/resources/js/main.js"/>"></script>

</body>
</html>