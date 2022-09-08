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
	<table class="table table-dark">
	  <thead>
	    <tr>	
	      <th scope="col">상품번호</th>
	      <th scope="col">상품명</th>
	      <th scope="col">이자율</th>
	      <th scope="col">판매여부</th>
	    </tr>
	  </thead>
	  <tbody>
	    	<tr>
				<td>${dto.bookNum}</td>
				<td>${dto.bookName}</td>	
				<td>${dto.bookRate}</td>	
				<td>${dto.bookSale}</td>			
			</tr>
	   </tbody>
</table>
<br><br>
<div class="align-center">
<a href = "./list.iu" class="btn btn-info">상품 목록 보기</a>
<a href= "./update.iu?bookNum=${dto.bookNum}" class="btn btn-primary">상품 수정</a>
<a href="./delete.iu?bookNum=${dto.bookNum}" class="btn btn-danger">상품 삭제</a>
<c:if test="${not empty sessionScope.member}">
<a href="../bankAccount/add.iu?bookNum=${dto.bookNum}" class="btn btn-success">상품 가입</a>
</c:if>
</div>

</div>
	<!--comment part-->
	<div class="row">
		<div class="card mb-2">
			<div class="card-header bg-light">
					<i class="fa fa-comment fa"></i> REPLY
			</div>
			<div class="card-body">
				<ul class="list-group list-group-flush">
					<li class="list-group-item">
					<div class="form-inline mb-2">
						<label for="writer"><i class="fa fa-user-circle-o fa-2x"></i></label>
						<input type="text" class="form-control ml-2" placeholder="Enter yourId" id="writer">
					</div>
					<textarea class="form-control" id="contents" rows="3"></textarea>
					<button type="button" class="btn btn-dark mt-3" id="commentAdd" data-booknum="${dto.bookNum}">답글 작성</button>
					</li>
				</ul>
			</div>
		</div>
		
	</div>
	<div>
		<table class="table " id="commentList">


		</table>
	</div>
	<button id="more" class="btn disabled">더보기</button>

	<div>
		<button type="button" style="display: none;" class="btn btn-primary" id="up" data-bs-toggle="modal" data-bs-target="#exampleModal" data-bs-whatever="@getbootstrap">Open modal for @getbootstrap</button>

		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Update</h5>
					<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<input type="hidden" id="num">
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">writer:</label>
							<input type="text" class="form-control" id="updateWriter">
						</div>
						<div class="mb-3">
							<label for="message-text" class="col-form-label">Contents:</label>
							<textarea class="form-control" id="updateContents"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" data-bs-dismiss="modal" id="update">Send message</button>
				</div>
				</div>
			</div>
		</div>

	</div>
</section>
<c:import url="../template/footer.jsp"></c:import>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<script src="/resources/js/bankbookComment.js"></script>
</body>
</html>