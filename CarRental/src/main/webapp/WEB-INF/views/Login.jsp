<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!doctype html>
<html lang="en">
<head>
    <title>Login</title>

	<meta charset="utf-8" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />


	<style>body{padding-top: 60px;}</style>

    <link rel="stylesheet" href="<c:url value=" /resources/assets/css/bootstrap.css"/>"/>

	<link rel="stylesheet" href="<c:url value=" /resources/assets/css/login-register.css"/>"/>
	<link rel="stylesheet" href="<c:url value=" http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css"/>">
	<script type="text/javascript" src="<c:url value="/resources/assets/js/jquery-1.10.2.js"/>"></script>
	<script type="text/javascript" src="<c:url value=" /resources/assets/js/bootstrap.js"/>"></script>
	<script type="text/javascript" src="<c:url value=" /resources/assets/js/login-register.js"/>"></script>

</head>
<body>
    <div class="container">
        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">
                 <a class="btn big-login" data-toggle="modal" href="javascript:void(0)" onclick="openLoginModal();">Log in</a>
                 <a class="btn big-register" data-toggle="modal" href="javascript:void(0)" onclick="openRegisterModal();">Register</a></div>
            <div class="col-sm-4"></div>
        </div>


		 <div class="modal fade login" id="loginModal">
		      <div class="modal-dialog login animated">
    		      <div class="modal-content">
    		         <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title">Login with</h4>
                    </div>
                    <div class="modal-body">
                        <div class="box">
                             <div class="content">
                                <div class="error"></div>
                                <div class="form loginBox">
                                    <form:form method="POST" action="/Check-Login" modelAttribute="user" accept-charset="UTF-8">
                                    <form:input path="userName" id="email" class="form-control" type="text" placeholder="UserName" name="UserName"/>
                                    <form:input path="passWord" id="password" class="form-control" type="password" placeholder="Password" name="password"/>
                                    <button class="btn btn-default btn-login">Login</button>
                                    </form:form>
                                </div>
                             </div>
                        </div>
                        <div class="box">
                            <div class="content registerBox" style="display:none;">
                             <div class="form">
                                <form:form method="POST" html="{:multipart=>true}" data-remote="true" action="Registration" modelAttribute="registration" accept-charset="UTF-8" >
                                <form:input path="fullName" id="fullName" class="form-control" type="text" placeholder="FullName" name="fullname"/>
                                <form:input path="userName" id="userName" class="form-control" type="text" placeholder="UserName" name="username"/>
                                <form:input path="email" id="email" class="form-control" type="text" placeholder="Email" name="email"/>
                                <form:input path="passWord" id="password" class="form-control" type="password" placeholder="Password" name="password"/>
                                <button class="btn btn-default btn-register">Create account</button>
                                </form:form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="forgot login-footer">
                            <span>Looking to
                                 <a href="javascript: showRegisterForm();">create an account</a>
                            ?</span>
                        </div>
                        <div class="forgot register-footer" style="display:none">
                             <span>Already have an account?</span>
                             <a href="javascript: showLoginForm();">Login</a>
                        </div>
                    </div>
    		      </div>
		      </div>
		  </div>
    </div>
<script type="text/javascript">
    $(document).ready(function(){
        openLoginModal();
    });
</script>


</body>
</html>
