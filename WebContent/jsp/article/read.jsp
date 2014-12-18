<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="entity.Comment" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>news를 읽는 곳입니다</h1>
	<a href="/jsp/index.jsp">메인으로</a>
	<br />
	<br /> 기사 제목 : ${article.title}
	<br /> 기사 작성자 : ${article.usrName}
	<br /> 기사 생성일 : ${article.createDate}
	<br /> 기사 수정일 : ${article.updateDate}
	<br />
	<br /> 기사 본문
	<br /> ${article.contents}
	<br />
	<br /> 댓글
	<br />
	<c:forEach var="comment" items="${CommentList}">
	============================================== <br />
	댓글 생성일 : ${comment.createDate} <br />
	댓글 수정일 : ${comment.updateDate} <br />
	작성자 : ${comment.usrName} <br />
	댓글 내용 <br />
	${comment.contents} <br />
	============================================== <br />
	</c:forEach>
</body>
</html>