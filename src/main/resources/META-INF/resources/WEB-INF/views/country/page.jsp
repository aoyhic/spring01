<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page.jsp</title>
<!-- 1.animate css -->
<link rel="stylesheet" href="/webjars/animate.css/3.5.2/animate.min.css">
<!-- 2.BootStrap -->
<link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.css">
<!-- 3.JQuery -->
<script type="text/javascript" src="/webjars/jquery/1.11.1/jquery.min.js"></script>
<!-- 4.bootstrap.js -->
<script type="text/javascript" src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
<!--code_assist  -->
<c:if test="false">
<link rel="stylesheet" href="../code_assist/animate.css">
<link rel="stylesheet" href="../code_assist/bootstrap.css">
</c:if>
</head>
<body>
<c:set var="countrys" value="${page.countrys}"/>
<c:set var="paging" value="${page.paging}"/>

<h1>Country Page List pageNo=${paging.pageNo}</h1>
<c:forEach var="c" items="${countrys}" varStatus="status">
<b>${status.index}</b>,${c.code}, <a href="/country/item/${c.code}">${c.name}</a>,${c.population}<br>
</c:forEach>
<hr>
<button onclick="displayBox(event)" class="btn btn-info animated bounce">css test
</button><br>
<button class="btn btn-warning animated bounce">
${paging}  
</button>
<hr>
<a href="/country/page/${paging.firstPage-1}">prev</a>
<c:forEach var="i" begin="${paging.firstPage}" end="${paging.lastPage}">
<a href="/country/page/${i}">${i}</a>
</c:forEach>
<a href="/country/page/${paging.lastPage+1}">Next</a>

<script type="text/javascript">
	function displayBox(event) {
		//$('.btn').removeClass('btn-info');
		$('.btn').toggleClass('btn-info'); //있으면 없애고 없으면 추가함.
	} 
</script>

</body>
</html>