<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
<div class="container">
	<form action="/member/modify" method="post">
		<div class="form-floating">
			<input type="text" name="userId" id="userId" readonly value="${member.id}" class="form-control-plaintext">
			<label for="userId">아이디</label>
		</div>
		<div class="form-floating">
			<input type="text" name="userName" id="userName" value="${member.name}" class="form-control">
			<label for="userName">이름</label>
		</div>
		<div class="form-floating">
			<input type="email" id="email" name="email" value="${member.email}" class="form-control">
			<label for="email">이메일</label>
		</div>
		<div class="form-floating">
			<input type="text" id="phoneNumber" name="phoneNumber" value="${member.phoneNumber}" class="form-control">
			<label for="phoneNumber">전화번호</label>
		</div>
		<div class="text-end">
			<button class="btn btn-success" type="submit">수정</button>
		</div>
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



