<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Modify</title>
	<link rel="stylesheet" href="style_menu.css" />
</head>

<body>

	<h1>개인 정보 수정</h1>
	
	<br>
	
	<div align="center">
		<form action="MenuMyPageModificationComplet.do" method="POST">
			<table align="center">
				<tr height="60px">
					<th align="left" width="100px">&nbsp;이름</th>
					<td><input type="text" name="memberName" value="${viewInformation.memberName}" />&nbsp;</td>
				</tr>
				<tr height="60px">
					<th align="left" width="100px">&nbsp;이메일</th>
					<td><input type="text" name="memberEmail" value="${viewInformation.memberEmail}" />&nbsp;</td>
				</tr>
				<tr height="60px">
					<th align="left" width="100px">&nbsp;아이디</th>
					<td><input type="text" name="memberID" value="${viewInformation.memberID}" />&nbsp;</td>
				</tr>
				<tr height="60px">
					<th align="left" width="100px">&nbsp;비밀번호</th>
					<td><input type="text" name="memberPW" value="${viewInformation.memberPW}" />&nbsp;</td>
				</tr>
				<tr height="60px">
					<td colspan="2" align="center"><input type="submit" value="수정 완료" /></td>
				</tr>
			</table>
		</form>
	</div>
	
</body>

</html>