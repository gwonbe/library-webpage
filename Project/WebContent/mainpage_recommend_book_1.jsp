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
				<td><img id="BookImage" src="./image/bImage_130830.png" /></td>
				<td id="BookExplain">
					자신의 인생에서 가장 중요한 ‘원씽’을 찾아라! 복잡한 세상을 이기는 단순함의 힘『원씽(THE ONE THING)』. 전 세계에서 두 번째로 큰 투자개발 회사의 대표이자 전미 130만 부 이상이 팔린 베스트셀러의 저자 게리 캘러가 더 적게 일함으로써 더 깊게 집중하여 더 크게 성공하는 비결이 무엇인지 제시하였다. 저자는 자신에게 가장 중요한 한 가지, ‘원씽’을 찾아 집중하고 파고들라고 제안한다. 우리의 삶을 소모시키는 멀티스태킹을 비롯한 성공에 대한 거짓신화를 바로잡고, ‘원씽’의 일을 찾아 집중하는 법, 그리고 ‘원씽’을 찾기 위해 스스로 어떤 질문을 해야 하며, 이를 어떻게 습관화하고 삶의 부분에 적용할 수 있는지를 알려준다.
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
				<td>130830</td>
				<td>원씽</td>
				<td>게리 켈러, 제이 파파산</td>
				<td>비즈니스북스</td>
			</tr>
		</table>
	</div>
		
	<h3><button type="button" onclick="location.href='MenuBookSearchPage.do'">목록보기</button></h3>	
	
</body>

</html>