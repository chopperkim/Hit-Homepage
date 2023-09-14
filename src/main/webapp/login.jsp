<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<form action="/login" method="post">
		<div class="form-floating">
			<input type="text" class="form-control" id="userId" name="userId" placeholder="아이디">
			<label for="userId">아이디</label>
		</div>
		<div class="form-floating">
			<input type="password" class="form-control" id="userPw" name="userPw" placeholder="비밀번호">
			<label for="userPw">비밀번호</label>
		</div>
		<div class="d-grid">
			<button type="submit" class="btn btn-info">로그인</button>
		</div>
	</form>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</body>
</html>