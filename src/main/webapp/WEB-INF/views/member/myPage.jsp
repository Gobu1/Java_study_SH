<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
		<div class="col-lg-4-mb-5">
			<img width="200" height="200" alt="" src="../resources/upload/member/${dto.bankMembersFileDTOs.fileName }">
		</div>
		
		<table class="table table-columns">
			<thead>
				<tr class="table-info">
					<th>UserName</th><th>name</th><th>email</th><th>phone</th>
				</tr>
			</thead>
		  	<tbody>
				<tr class="table-light">
					<td>${dto.userName}</td>
					<td>${dto.name}</td>
					<td>${dto.email}</td>
					<td>${dto.phone}</td>
				</tr>
			</tbody>
		</table>
		
		<table class="table table-dark table-striped-columns">
			<thead>
				<tr>
					<th>AccountNum</th><th>BookName</th><th>AccountDate</th>
				</tr>
			</thead>
		 	<tbody>
		 	
				<c:forEach items="${dto.bankAccountDTOs}" var="dto">
		 			<tr>
						<td><p>${pageScope.dto.accountNum }</p></td>
						<td><p>${dto.bankBookDTO.bookName }</p></td>
						<td><p>${dto.accountDate }</p></td>
					</tr>
				</c:forEach>
				 
			</tbody>
		</table>
		
	<c:import url="../template/footer.jsp"></c:import>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>