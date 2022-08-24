<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">Detail Page</h1>
<br>

<section class="container-fluid col-lg-6">
	<div class="row">
		<form action="./Add.iu" name="add" method="post">
			<input type="text" name="title" class="form-control mt-4 mb-2"
				readonly value="${boardDTO.title }" required>
			<div class="form-group">
				<textarea class="form-control" rows="10" name="contents"
					readonly  required>${boardDTO.contents }</textarea>
			</div>
			<c:if test="${not empty sessionScope.member}">
				<a href="./update.iu" class="btn btn-outline-primary" 
				style="float: right; width: 90px; height: 36px;">글 수정</a>
			</c:if>
		</form>
	</div>
</section>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>