<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자-회원관리</title>
<link rel="stylesheet" href="admin_Search_style.css"/>
</head>
<body>
	<section class="container">
		<div class="row">
			<form method="post" name="search" action="Csearch.do">
				<table class="searchBox">
					<tr>
						<td><select class="select_controller" name="select_content">
								<option value="CName">이름</option>
        						<option value="CEmail">이메일</option>
        						<option value="CId">아이디</option>
        						<option value="CPw">비밀번호</option>
						</select></td>
						<td><input type="text" class="form-control"
							placeholder="검색어 입력" name="searchText" maxlength="100"></td>
						<td><button type="submit" class="btn">검색</button></td>
					</tr>

				</table>
			</form>
		</div>
		
		<table class="main" width="1000" cellpadding="10" cellspacing="0" border="1">
		<tbody class="result">
		<tr class="type">
		<td>이름</td>
		<td>이메일</td>
		<td>아이디</td>
		<td>비밀번호</td>
		</tr>
		<c:forEach items="${cList}" var="dto">
		<tr>
		<td>${dto.memberName}</td>
		<td>${dto.memberEmail}</td>
		<td>${dto.memberID}</td>
		<td>${dto.memberPW}</td>
		</tr>
		</c:forEach>
		</tbody>
		</table>
	</section>
</body>
</html>