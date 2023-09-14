<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<form action="/board/update" method="post">
		<div class="form-floating">
			<input type="text" name="title" id="title" value="${board.title}" class="form-control">
			<label for="title">제목</label>
		</div>
		<div class="form-floating">
			<input type="text" name="writer" id="writer" readonly value="${board.writer}" class="form-control-plaintext">
			<label for="writer">작성자</label>
		</div>
		<div class="form-floating">
			<input id="createDate" value="${board.createDate}" class="form-control-plaintext">
			<label for="createDate">작성일자</label>
		</div>
		<div class="input-group">
			<textarea rows="10" cols="40" name="content" class="form-control" aria-label="With textarea">${board.content}</textarea>
		</div>
		<input type="hidden" value="${board.no}" name="no" id="no">
		<button class="btn btn-success" type="submit">수정</button>
		<a href="/board/delete?no=${board.no}" class="btn btn-danger">삭제</a>
	</form>
	<form action="/board/delete">
		<input type="hidden" value="${board.no }" name="no" id="no">
	</form>
</div>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<script>
	function delete_board() {
		location.href = "/board/delete?no=" + document.getElementById("no").value
	}
</script>
</body>
</html>



