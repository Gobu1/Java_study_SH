<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header class="container-fluid">
        <nav class="navbar navbar-expand-lg bg-light">
            <div class="container-fluid">
            <a class="navbar-brand" href="#">Navbar</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                <a class="nav-link active" aria-current="page" href="#">Home</a>
                <a class="nav-link" href="/notice/list.iu">공지사항</a>
                <a class="nav-link" href="/qna/list.iu">QNA</a>
                <a class="nav-link" href="/bankbook/list.iu">상품목록</a>
                <a class="nav-link" href="/member/search.iu">회원검색</a>
                <c:if test="${empty sessionScope.member}">
                <a class="nav-link" href="../member/login.iu">로그인</a>
                <a class="nav-link" href="../member/join.iu">가입</a>
                </c:if>
                <c:if test="${not empty sessionScope.member}">
                <a class="nav-link" href="../member/myPage.iu">내 정보</a>
                <a class="nav-link" href="/member/logout.iu">로그아웃</a>
                </c:if>
                </div>
            </div>
            </div>
        </nav>
    </header>