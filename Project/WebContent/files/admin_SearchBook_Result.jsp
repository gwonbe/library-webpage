<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자-도서관리-결과</title>
<link rel="stylesheet" href="admin_Search_style.css"/>
</head>
<body>
	<section class="container">
		<div class="row">
			<form method="post" name="search" action="Bsearch.do">
				<table class="searchBox">
					<tr>
						<td><select class="select_controller" name="select_content">
								<option value="bId">도서번호</option>
        						<option value="bName">이름</option>
        						<option value="bAuthor">저자</option>
        						<option value="bPublisher">출판사</option>
        						<option value="bClient">대출자</option>
						</select></td>
						<td><input type="text" class="form-control"
							placeholder="검색어 입력" name="searchText" maxlength="100"></td>
						<td><button type="submit" class="btn">검색</button></td>
						<td><button type="button" onclick="location.href='admin_bookAdd.jsp'">추가</button></td>
					</tr>
				</table>
			</form>
		</div>
		
		<table class="main" width="1000" cellpadding="10" cellspacing="0" border="1">
		<tbody class="result">
		<tr class ="type">
		<td>도서번호</td>
		<td>이름</td>
		<td>저자</td>
		<td>출판사</td>
		<td>대출자</td>
		</tr>
		<c:forEach items="${bList}" var="dto1">
		<tr>
		<td>${dto1.bId}</td>
		<td><a href="book_detail.do?bId=${dto1.bId}">${dto1.bName}</td>
		<td>${dto1.bAuthor}</td>
		<td>${dto1.bPublisher}</td>
		<td>${dto1.bClient}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</section>
</body>
</html>