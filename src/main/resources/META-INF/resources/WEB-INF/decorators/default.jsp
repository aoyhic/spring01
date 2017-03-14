<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><sitemesh:write property="title"/></title>
<!-- 1.animate css -->
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.min.css">
<!-- 2.BootStrap -->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.css">
<!-- 3.JQuery -->
<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<!-- 4.bootstrap.js -->
<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<c:if test="false">
<!-- code assist -->
<link rel="stylesheet" href="../code_assist/animate.css">
<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
<sitemesh:write property="head"/>
</head>
<body>
<hr>
<h1>Decorator</h1>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
			<!-- 화면이 작아졌을 때 압축한 버튼  -->
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span> 
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Mosaic</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">Employee <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/dept/list">Dept</a></li>
							<li><a href="/emp/salgrade">Salgrade</a></li>
							<li><a href="/emp/list">Emp</a></li>
						</ul>
					</li>
					<li class="dropdown"><a class="dropdown-toggle"	data-toggle="dropdown" href="#">World <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/country/page/1">Country</a></li>
							<li><a href="/city/page/1">City</a></li>
							<li><a href="/language/page/1">Language</a></li>
						</ul>
					</li>
					<li><a href="#">Q & A</a></li>
					<li><a href="#">Documentation</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
					<li><a href="#"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- list.jsp의 body가 여기 합쳐지는 것. SiteMeshConfig.java파일에 /country/* 이 폴더 밑의 파일을 디폴트파일과 합치겠다고 한 것인데, 그 중 body를 합치겠다는 뜻   -->
<sitemesh:write property="body" />
</body>
</html>