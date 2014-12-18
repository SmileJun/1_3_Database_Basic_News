<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>댓글을 등록하는 곳입니다</h1>
	<br />

	<p>댓글을 입력하세요</p>
	<form action="/AddCommentServlet" method="POST">
		선택된 기사 번호 <input type="text" name="articleSeq" value="${articleSeq}" readonly="readonly"> <br />
		<br />
		댓글 내용 <br />
		<textarea name="contents" cols="100" rows="5"
			placeholder="댓글 내용을 입력하세요"></textarea> <br />
		<input type="submit" name="addCommentSubmit" value="등록">
	</form>
</body>
</html>