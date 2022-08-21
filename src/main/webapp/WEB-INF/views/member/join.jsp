<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	<section class="container-fluid">
		<div class="row">
		
			<form class="row g-3" action="./join.iu" name="join" method="post">
			  <div class="col-md-6">
			    <label for="inputEmail4" class="form-label">UserName</label>
			    <input type="text" class="form-control" id="inputEmail4" name="userName">
			  </div>
			  <div class="col-md-6">
			    <label for="inputPassword4" class="form-label">Password</label>
			    <input type="password" class="form-control" id="inputPassword4" name="password">
			  </div>
			  <div class="col-12">
			    <label for="inputAddress" class="form-label">Name</label>
			    <input type="text" class="form-control" id="inputAddress" placeholder="PER1" name="name">
			  </div>
			  <div class="col-12">
			    <label for="inputAddress2" class="form-label">Email</label>
			    <input type="text" class="form-control" id="inputAddress2" placeholder="email@email" name="email">
			  </div>
			  <div class="col-md-6">
			    <label for="inputCity" class="form-label">Phone</label>
			    <input type="text" class="form-control" id="inputCity" placeholder="01010101" name="phone">
			  </div>
			 
			  <div class="col-12">
			    <button type="submit" class="btn btn-primary">Sign in</button>
			  </div>
			</form>
	
		</div>
	</section>
	<c:import url="../template/footer.jsp"></c:import>	
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
</body>
</html>