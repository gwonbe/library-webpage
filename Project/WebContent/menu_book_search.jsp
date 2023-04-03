<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Book Search</title>
	<link rel="stylesheet" href="style_menu.css" />
</head>

<body>
	
	<a href="GoToMainPage.do">Back</a>
	<h2>도서 검색</h2>
	
	<section>
	
		<div align="center" class="searchDiv">
			<form class="searchForm" method="post" name="search" action="MenuBookSearch.do" align="center">
				<table align="center" id="searchBox">
					<tr>
						<td>
							<select name="select_content">
								<option value="bId">도서번호</option>
								<option value="bName">이름</option>
								<option value="bAuthor">저자</option>
								<option value="bPublisher">출판사</option>
							</select>
						</td>
						<td>
							<input type="text" placeholder="검색어 입력" name="searchText" maxlength="100"/>
						</td>
						<td>
							<button type="submit">검색</button>
						</td>
					</tr>
				</table>
			</form>
		</div>
		
		<table width="1000" cellpadding="10" cellspacing="0" border="1" align="center">
			<tbody>
				<tr class="searchTableTitle">
					<td>도서번호</td>
					<td>이름</td>
					<td>저자</td>
					<td>출판사</td>
				</tr>
				<c:forEach items="${bList}" var="dto">
				<tr class="searchTableList">
					<td>${dto.bId}</td>
					<td><a id="DetailLink" href="MenuBookSearchDetail.do?bId=${dto.bId}">${dto.bName}</td>
					<td>${dto.bAuthor}</td>
					<td>${dto.bPublisher}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</section>
		
</body>

</html>
