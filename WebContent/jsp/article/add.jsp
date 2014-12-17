<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>기사를 등록하는 곳입니다</h1>
	<a href="/jsp/index.jsp">메인으로</a>
	<br />

	<p>기사를 입력하세요</p>
	<form action="/AddArticleServlet" method="POST">
		기사 제목 <input type="text" name="title"> <br />
		기사 내용 <br />
		<textarea name="contents" cols="100" rows="50"
			placeholder="기사 내용을 입력하세요"></textarea> <br />
		<input type="submit" name="addArticleSubmit" value="등록">
	</form>
</body>
</html>