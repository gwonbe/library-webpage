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
	
	<a href="GoToMainPage.do">Back</a>
	
	<h1>책 상세정보</h1>
	
	<br>
	
	<div id="BookDetail">
		<table width="1000" cellpadding="10" cellspacing="0" border="1">
			<tr>
				<td>이미지</td>
				<td>설명</td>
			</tr>
			<tr class="searchTableList">
				<td><img id="BookImage" src="./image/bImage_191118.png" /></td>
				<td id="BookExplain">
					언제나 우리 눈앞에, 코앞에, 발밑에 있는 죽음을 기억하라! 타인의 시선에서 벗어나 자신의 삶을 사는 법을 전파했던 《행복한 이기주의자》로 지금 이 순간에도 수많은 사람들의 삶을 바꾸고 있는 웨인 다이어 박사의 『우리는 모두 죽는다는 것을 기억하라』. 우리 시대 가장 위대한 동기부여 전문가이자 심리학자, 영성가로 평가받으며 지혜롭고 통찰 깊은 삶을 살다 간 저자가 세상에 마지막으로 남기고 간 작품으로, 삶의 현자들로 불리는 작가, 철학자, 영성가, 명성가 등등 다양한 인물들의 뜨거운 목소리가 담겨 있다. 저자는 우리는 언제나 영원히 살 것처럼 일하고, 영원히 살 것처럼 고민하고, 영원히 살 것처럼 불안해하고 두려워하지만 언제나 죽음은 우리 코앞에 있다고 이야기하며, 우리에게 그 사실을 일깨워 우리의 삶을 ‘영원히’에서 ‘지금 당장’으로 변화시키고자 한다. 이 책에 담긴 삶의 다른 답, 다른 방식을 찾아낸 사람들의 따뜻하고 유쾌한 이야기를 통해 나 자신을 투명하게 바라보며 분노, 죄책감, 돈과 명예에 대한 욕망으로부터 자유로워지고, 마침내 삶의 다른 방식을 찾은 나 자신을 발견하게 될 것이다.
				</td>
			</tr>
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
			<tr class="searchTableList">
				<td>191118</td>
				<td>우리는 모두 죽는다는 것을 기억하라</td>
				<td>웨인 다이어</td>
				<td>토네이도</td>
			</tr>
		</table>
	</div>
		
	<h3><button type="button" onclick="location.href='MenuBookSearchPage.do'">목록보기</button></h3>	
	
</body>

</html>