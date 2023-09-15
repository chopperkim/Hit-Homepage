<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시판 등록</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<h2 class="h2 text-center">게시판 글 등록</h2>
	<form method="post">
		<div class="form-floating">
			<input type="text" name="title" id="title" class="form-control">
			<label for="title">제목</label>
		</div>
		<div class="input-form">
			<textarea rows="20" cols="80" name="content" class="form-control"></textarea>
		</div>
		<div class="text-end">
			<input type="hidden" name="writer" value="${member.id }">
			<button type="submit" class="btn btn-success">등록</button>
		</div>
	</form>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
</body>
</html>