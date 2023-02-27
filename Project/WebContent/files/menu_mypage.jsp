<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>

<head>
	<meta charset="EUC-KR">
	<title>My Page</title>
	<link rel="stylesheet" href="style_menu.css" />
</head>

<body>
	
	<a href="GoToMainPage.do">Back</a>
	
	<h1>My Page</h1>
	
	<br>
	
	<h3>내정보</h3>
	<div align="center">
		<form>
			<table align="center">
				<tr align="right">
					<th colspan="3"><a href="MenuMyPageModifyMyInformation.do">수정</a></th>
				</tr>
				<tr>
					<th width="250px" height="200px">
						<img src="./image/member_img.jpg" width="190px" height="190px" alt="no image">
					</th>
					<th width="50px" height="200px">
					</th>
					<th width="600px" height="200px">
						<table>
							<tr height="50px">
								<th align="left" width="150px">이름</th>
								<td align="left" width="450px">${viewInformation.memberName}</td>
							</tr>
							<tr height="50px">
								<th align="left" width="150px">이메일</th>
								<td align="left" width="450px">${viewInformation.memberEmail}</td>
							</tr>
							<tr height="50px">
								<th align="left" width="150px">아이디</th>
								<td align="left" width="450px">${viewInformation.memberID}</td>
							</tr>
							<tr height="50px">
								<th align="left" width="150px">비밀번호</th>
								<td align="left" width="450px">* * * *</td>
							</tr>
						</table>
					</th>
				</tr>
			</table>
		</form>
	</div>
	
	<br>
	
	<h3>대출 중 도서</h3>
	<div align="center">
		<form action="MenuMyPageViewInformation.do?CId=${viewInformation.memberID}">
			<table align="center">
				<tr>
					<th width="300px" height="70px">도서번호</th>
					<th width="300px" height="70px">제목</th>
					<th width="300px" height="70px">저자</th>
					<th width="300px" height="70px">출판사</th>
				</tr>
				<c:forEach items="${bList}" var="dto">
					<tr>
						<td width="300px" height="30px">${dto.bId}</td>
						<td width="300px" height="30px">${dto.bName}</td>
						<td width="300px" height="30px">${dto.bAuthor}</td>
						<td width="300px" height="30px">${dto.bPublisher}</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	</div>
	
	<br><br><br>
		
</body>

</html>