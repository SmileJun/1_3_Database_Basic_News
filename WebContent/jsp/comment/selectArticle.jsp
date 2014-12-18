<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>댓글 등록할 기사를 선택하는 곳입니다</h1>
	<br />

	<table>
		<tr>
			<td></td>
			<td>뉴스 번호</td>
			<td>뉴스 제목</td>
			<td>뉴스 생성일</td>
		</tr>

		<c:forEach var="article" items="${articleList}" varStatus="status">
			<tr>
				<td></td>
				<td>${article.seq}</td>
				<td><a
					href="<c:url value="/AddCommentServlet">
  							<c:param name="articleSeq" value="${article.seq}"/>
						  </c:url>">${article.title}
				</a></td>
				<td>${article.createDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>