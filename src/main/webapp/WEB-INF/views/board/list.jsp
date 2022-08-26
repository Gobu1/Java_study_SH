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
<h1 class="align-center">${board} Page</h1>
<br>
<section class="container-fluid col-lg-6">
	<form action="./list.iu"  class="row gy-2 gx-3 align-items-center">
	  <div class="col-auto">
	    <label class="visually-hidden" for="kind">Kind</label>
	    <select name="kind" class="form-select" id="kind">
	      <option value="title">Title</option>
	      <option value="contents">Contents</option>
	      <option value="writer">Writer</option>
	    </select>
	  </div>
	  <div class="col-auto">
	    <label class="visually-hidden" for="autoSizingInputGroup"></label>
	    <div class="input-group">
	      <input type="text" class="form-control" name="search" id="autoSizingInputGroup" placeholder="검색어를 입력하세요">
	  	</div>
	  </div>
	  
	  <div class="col-auto">
	    <button type="submit" class="btn btn-primary">검색</button>
	  </div>
	</form>

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
				<td class="table-light">
				<c:catch>
				<c:forEach begin="1" end="${dto.depth }">&nbsp;
				</c:forEach>
				</c:catch>
				<a href="./detail.iu?num=${dto.num}">${dto.title }</a></td>
				<td class="table-light">${dto.writer }</td>
				<td class="table-light">${dto.regDate }</td>
				<td class="table-light">${dto.hit }</td>
			</tr>
		</c:forEach>
	  </tbody>
</table>
	<nav aria-label="Page navigation example">
	  <ul class="pagination">
		    <li class="page-item ${pager.pre?'':'disabled' }">
		   	 <a class="page-link" href="./list.iu?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}	" aria-label="previous">Previous
		    		<span aria-hidden="true">&raquo</span></a>
		    </li>
	    
	    	<c:forEach begin="${pager.startNum }" end="${pager.lastNum }" var="i">
	    		<li class="page-item"><a class="page-link" href="./list.iu?page=${i}&kind=${pager.kind}&search=${pager.search}">${i }</a></li>
	    	</c:forEach>
	    	
  			
<%--	    </c:if>
	    	<c:choose>
	    		<c:when test="${pager.next}">
	    			<li class="page-item">	
	    		</c:when>
	    		<c:otherwise>
					<li class="page-item disabled">
	    		</c:otherwise>
	    	</c:choose> --%>
	    	<li class="page-item ${pager.next?'':'disabled'}">	
	    		<a class="page-link" href="./list.iu?page=${pager.lastNum+1 }&kind=${pager.kind}&search=${pager.search}" aria-label="next">Next
	    		<span aria-hidden="true">&raquo</span>
	    	</a>
	    </li>
	  </ul>
	</nav>
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