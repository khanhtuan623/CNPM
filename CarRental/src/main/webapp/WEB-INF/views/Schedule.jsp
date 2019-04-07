<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<!-- <link rel="icon" type="image/png" href="assets/img/favicon.ico"> -->
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Car Rental</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link rel="stylesheet" href="<c:url value=" /resources/assets/css/bootstrap.min.css" />" />

    <!-- Animation library for notifications   -->
    <link rel="stylesheet" href="<c:url value=" /resources/assets/css/animate.min.css" />"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link rel="stylesheet" href="<c:url value=" /resources/assets/css/light-bootstrap-dashboard.css?v=1.4.0"/>"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link rel="stylesheet" href="<c:url value=" /resources/assets/css/demo.css"/>" />


    <!--     Fonts and icons     -->
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
    <link rel='stylesheet' type='text/css' href='http://fonts.googleapis.com/css?family=Roboto:400,700,300'/>
    <link rel="stylesheet" href="<c:url value=" /resources/assets/css/pe-icon-7-stroke.css"/>" />
</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="azure" data-image="assets/img/sidebar-5.jpg">

    <!--   you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple" -->


    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="/ScheduleList/${passCode}" class="simple-text">
                   Car Rental
                </a>
            </div>

            <ul class="nav">
                <li >
                    <a href="/DriverList/${passCode}">
                        <p>Driver List</p>
                    </a>
                </li>
                <li>
                    <a href="/CarList/${passCode}">
                        <p>Car List</p>
                    </a>
                </li>
                <li class="active">
                    <a href="/ScheduleList/${passCode}">
                        <p>Schedule List</p>
                    </a>
                </li>
                <li>
                    <a href="/TicketFareList/${passCode}">
                        <p>Ticket-Fare List</p>
                    </a>
                </li>
                <li>
                    <a href="/CustomerList/${passCode}">
                        <p>Customer List</p>
                    </a>
                </li>
                <li>
                    <a href="/ShoppingCartList/${passCode}">
                        <p>ShoppingCart List</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
		<nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Table List</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="/">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg hidden-md"></li>
                    </ul>
                </div>
            </div>
        </nav>

        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">

                            <div class="header">
                                <h4 class="title" style="float: left;">Schedule</h4>
                                <a style="margin-left: 80%" href="/ShowNewSchedule" class="btn btn-secondary btn-sm" role="button">Add New Schedule</a>                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                        <th>ID</th>
                                    	<th>NAME CHANNEL</th>
                                    	<th>SPACE</th>
                                    	<th>NUMBER OF CAR</th>
                                    	<th>TIME OF DEPARTURE</th>
                                    	<th>ARRIVAL TIME</th>
                                    	<th>CAR</th>
                                    </thead>
                                    <tbody>
                                    <c:forEach var="scheduleList" items="${scheduleList}">
                                        <tr>
                                        	<td>${scheduleList.idSchedule}</td>
                                        	<td>${scheduleList.nameChannel}</td>
                                        	<td>${scheduleList.space}</td>
                                            <td>${scheduleList.number}</td>
                                            <td>${scheduleList.timeOfDeparture}</td>
                                            <td>${scheduleList.arrivalTime}</td>
                                            <td>${scheduleList.idCar}</td>
                                            <td>
                                                <a href="/Get-Schedule/${scheduleList.idSchedule}">Edit</a>
                                            </td>
                                            <td >
                                                <a href="" style="color: red;">Delete</a>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script type="text/javascript" src="<c:url value=" /resources/assets/js/jquery.3.2.1.min.js"/>"></script>
	<script type="text/javascript" src="<c:url value=" /resources/assets/js/bootstrap.min.js" />"></script>

	<!--  Charts Plugin -->
	<script src="<c:url value=" /resources/assets/js/chartist.min.js"/>"></script>

    <!--  Notifications Plugin    -->
    <script src="<c:url value=" /resources/assets/js/bootstrap-notify.js"/>"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="<c:url value="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"/>"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="<c:url value=" /resources/assets/js/light-bootstrap-dashboard.js?v=1.4.0"/>"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="<c:url value=" /resources/assets/js/demo.js"/>"></script>


</html>
