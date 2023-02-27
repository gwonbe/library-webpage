<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   
<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Book Detail</title>
	<link rel="stylesheet" href="style_menu.css" />
</head>

<body>
	
	<h1>책 상세정보</h1>
	
	<br>
	
	<div id="BookDetail">
		<table width="1000" cellpadding="10" cellspacing="0" border="1">
			<tr>
				<td>이미지</td>
				<td>설명</td>
			</tr>
			<c:forEach items="${bList}" var="dto">
			<tr class="searchTableList">
				<td><img id="BookImage" src="./image/bImage_${dto.bId}.png" /></td>
				<td id="BookExplain">${dto.bExplain}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
	
	<h1>책 소장정보</h1>
	
	<br>
	
	<div id="BookDetail">
		<table width="1000" cellpadding="10" cellspacing="0" border="1">
			<tr class="type">
				<td>도서번호</td>
				<td>이름</td>
				<td>저자</td>
				<td>출판사</td>
			</tr>
			<c:forEach items="${bList}" var="dto">
			<tr class="searchTableList">
				<td>${dto.bId}</td>
				<td>${dto.bName}</td>
				<td>${dto.bAuthor}</td>
				<td>${dto.bPublisher}</td>
			</tr>
			</c:forEach>
		</table>
	</div>
		
	<h3><button type="button" onclick="location.href='MenuBookSearchPage.do'">목록보기</button></h3>	
	
</body>

</html>