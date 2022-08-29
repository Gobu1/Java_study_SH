<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Page</title>
<!-- jquery -->
	<script type="text/javascript" src="//code.jquery.com/jquery-3.6.0.min.js"></script>
<!-- boot strap -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<style>	.align-center {text-align: center;}	</style>
	<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>

</head>
<body>
<c:import url="../template/header.jsp"></c:import>
<br><br>
<h1 class="align-center">Add Page</h1>
<br>

<section class="container-fluid col-lg-6">
	<div class="row">
		<form action="./add.iu" name="add" method="post" enctype="multipart/form-data">
			<input type="text" name="title" class="form-control mt-4 mb-2"
				placeholder="제목을 입력해주세요." required>
			<div class="form-group">
				<textarea class="form-control" rows="10" name="contents" id="contents"
					placeholder="내용을 입력해주세요" required></textarea>
			</div>
			<input type="text" name="writer" class="form-control mt-4 mb-2"
				placeholder="작성자를 입력해주세요." required>
			<button type="submit" class="btn btn-primary" style="float: right; width: 90px; height: 36px;">제출하기</button>
			
			<div class="row">
			    <label for="inputFiles" class="form-label">Files</label>
			  	<input type="file" class="form-control" id="files"  name="files">
			  	<input type="file" class="form-control" id="files"  name="files">
			  	<input type="file" class="form-control" id="files"  name="files">
			  			
			</div>
			  
		</form>

	</div>
</section>
	<c:import url="../template/footer.jsp"></c:import>
<!-- boot strap -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script type="text/javascript">
    	$("#contents").summernote();
    </script>
</body>
</html>