<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 상세정보</title>
<link rel="stylesheet" href="admin_bookDetail_style.css"/>
</head>
<body>
	<table class="t1" width="1000" cellpadding="10" cellspacing="0" border="1">
	<h1>책 상세정보</h1>
	<tr class="bookDetail">
		<td>이미지</td>
		<td>설명</td>
	</tr class="bookDetail">
	<c:forEach items="${bList}" var="dto1">
	<tr>
		<td><img src="./image/bImage_${dto1.bId}.png" /></td>
		<td class="bookExplain">${dto1.bExplain}</td>
	</tr>
	</c:forEach>
	</table>
	<table class="t2" width="1000" cellpadding="10" cellspacing="0" border="1">
		<tr><form action="modify.do" method="post">
		<h1>책 소장정보</h1>
		<tr class="type">
		<td class="t1_1">도서번호</td>
		<td>이름</td>
		<td>저자</td>
		<td>출판사</td>
		<td>대출자</td>
		<td >수정</td>
		<td >삭제</td>
		</tr>
		<c:forEach items="${bList}" var="dto1">
		
		<input type="hidden" name="bId" value="${dto1.bId}">
		<td class="t2_1">${dto1.bId}</td>
		<td ><input type="text" name="bName" value="${dto1.bName}"></td>
		<td><input type="text" name="bAuthor" value="${dto1.bAuthor}"></td>
		<td><input type="text" name="bPublisher" value="${dto1.bPublisher}"></td>
		<input type="hidden" name="bClient" value="${dto1.bClient}">
		<td>${dto1.bClient}</td>
		<td> <input class="btn" type="submit" value="수정"> </td>
		<td><button class="btn" type="button" onclick="location.href='delete.do?bId=${dto1.bId}'">삭제</button></td>
		</tr>
		
		</c:forEach>
		</form>
		</table>
		<h3><button class="menuBtn" type="button" onclick="location.href='admin_book.do'">목록보기</button></h3>
</body>
</html>