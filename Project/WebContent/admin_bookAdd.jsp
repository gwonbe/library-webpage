<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 추가</title>
<link rel="stylesheet" href="admin_bookAdd_style.css"/>
</head>
<body>
	<table width="1000" cellpadding="10" cellspacing="0" border="1">
		<form action="write.do" method="post">
		<tbody>
			<tr>
				<td class="type"> 도서번호 </td>
				<td> <input type="text" name="bId" size="50"> </td>
			</tr>
			<tr>
				<td class="type"> 이름 </td>
				<td> <input type="text" name="bName" size="50"> </td>
			</tr>
			<tr>
				<td class="type"> 저자 </td>
				<td> <input type="text" name="bAuthor" rows="50"></td>
			</tr> 
			<tr>
				<td class="type"> 출판사 </td>
				<td> <input type="text" name="bPublisher" rows="50"></td>
			</tr> 
			<tr>
				<td colspan="2"> <input class="button" type="submit" value="입력"> &nbsp;&nbsp;
				<button type="button" onclick="location.href='admin_book.do'">목록보기</button> 
			</tr>
		</tbody>
		</form>
		
	</table>
</body>
</html>