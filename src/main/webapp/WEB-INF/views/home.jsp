<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="./template/header.jsp"></c:import>		
 		
				<c:choose>
					<c:when test="${not empty member}">
						<a class="nav-link active" href="./member/logout.iu">Logout</a><br>
						<a class="nav-link active" href="./bankbook/add.iu">product add </a>
						<a class="nav-link active" href="./bankbook/list.iu">booklist</a>
						<a class="nav-link active" href="./member/search.iu">search</a>
					</c:when>
					<c:otherwise>
						<a class="nav-link active" href="./member/login.iu">로그인</a>
						<a class="nav-link active" href="./member/join.iu">join</a><br>
					</c:otherwise>
				</c:choose>
			
<c:import url="./template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>
