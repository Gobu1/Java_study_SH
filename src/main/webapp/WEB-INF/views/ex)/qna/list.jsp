<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Notice Page</title>
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>
    .align-center {text-align: center;}
</style>
</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">QNA Page</h1>
<br>
<section class="container-fluid col-lg-6">
	<div class="row">
	<table class="table">
	  <thead class="table-secondary">
	    <tr>
	      <th scope="col">번호</th>
	      <th scope="col">공지 제목</th>
	      <th scope="col">작성자</th>
	      <th scope="col">등록일</th>
	      <th scope="col">조회수</th>

	    </tr>
	  </thead>
	  <tbody>
	    <c:forEach items="${list}" var="dto" >
			<tr>
				<td class="table-light">${dto.num }</td>
				<td class="table-light"><a href="./detail.iu?num=${dto.num}">${dto.title }</a></td>
				<td class="table-light">${dto.writer }</td>
				<td class="table-light">${dto.regDate }</td>
				<td class="table-light">${dto.hit }</td>
			</tr>
		</c:forEach>
	  </tbody>
</table>
</div>
<c:if test="${not empty sessionScope.member}">
<a href="./add.iu" class="btn btn-outline-primary" 
style="float: right; width: 90px; height: 36px;">글 작성</a>
</c:if>
</section>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>