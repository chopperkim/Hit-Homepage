<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">

</head>
<body>
<div class="container">
	<header class="mb-auto py-5">
		<div>
			<h3 class="float-md-start mb-0">게시판</h3>
			<nav class="nav nav-masthead justify-content-center float-md-end">
				<a class="nav-link fw-bold py-1 px-2 active" aria-current="page" href="/">Home</a>
				<a class="nav-link fw-bold py-1 px-2" href="/board/list">게시판</a>
				<c:choose>
					<c:when test="${not empty member}">
					<span class="fw-bold py-1 px-2">${member.name }님</span>
					<a class="nav-link fw-bold py-1 px-2" href="/logout">로그아웃</a>
					</c:when>
					<c:otherwise>
					<a class="nav-link fw-bold py-1 px-2" href="/login">로그인</a>
					</c:otherwise>
				</c:choose>
				<a class="nav-link fw-bold py-1 px-2" href="/register">회원가입</a>
			</nav>
		</div>
	</header>

	<main>
		<table class="table table-striped table-bordered">
			<thead>
				<tr>
					<th>아이디</th>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${members}" var="member">
				<tr>
					<td>${member.id }</td>
					<td><a href="/member/modify?userId=${member.id}">${member.name }</a></td>
					<td>${member.email }</td>
					<td>${member.phoneNumber }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="Page navigation example">
		  <ul class="pagination justify-content-center">
		    <li class="page-item">
		      <a class="page-link" href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li class="page-item"><a class="page-link" href="#">1</a></li>
		    <li class="page-item"><a class="page-link" href="#">2</a></li>
		    <li class="page-item"><a class="page-link" href="#">3</a></li>
		    <li class="page-item">
		      <a class="page-link" href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li>
		  </ul>
		</nav>
	</main>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</body>
</html>