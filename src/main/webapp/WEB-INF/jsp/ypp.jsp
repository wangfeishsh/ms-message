<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<title></title>
		<link rel="stylesheet" href="css/jquery-ui.css">


	</head>
	<body>

	<form name="test" action="/v1/ypp/action">
		开始时间：<input id="startTime" name="startTime" type="text"/><br>
		结束时间：<input id="endTime" name="endTime" type="text"/><br>
		发起人Id：<input id="fromUser" name="fromUser" type="text"/><br>
		接受人Id：<input id="toUser" name="toUser" type="text"/><br>
		<input type="submit">
	</form>

	<br>

	<p>
		${message}
	</p>

	</body>
</html>
