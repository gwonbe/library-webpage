<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>
	<meta charset="UTF-8">
	<title>Home</title>
	<link rel="stylesheet" href="style_mainpage.css" />
</head>

<body>
	
	<div id="DivA">
		<% 
			Object idObject = session.getAttribute("UserId");
			String message;
			String aText;
			if(idObject == null){
				aText = "로그인";
				message = "";
			}else{
				aText = "로그아웃";
				message = " 님 환영합니다.";
			}
		%>
		<a class="ButtonA" width="50px" href="LogInOrLogOut.do"><%=aText%></a>
		<p align="right">${UserId}<%=message%></p>
	</div>
	
	<h1>한림도서관</h1>
	
	<a href="https://www.hallym.ac.kr/hallym_univ/" target="_blank">
		<img src="./image/hallym.png" alt="한림대학교" />
	</a>
	
	<br>
	
	<div id="DivMenuBar" align="center">
		<a class="MenuA" href="MenuIntroduceLibrary.do">도서관 소개</a>
		<a class="MenuA" href="MenuBookSearchPage.do">도서 검색</a>
		<a class="MenuA" href="MenuMyPageViewInformation.do?CId=${UserId}">마이페이지</a>
	</div>
	
	<br><br><br><br>
	
	<table align="center" id="Table" border="1px">
		<tr>
			<td text-align="right" width="600px" height="350px">공지사항
			<ul align="left">
			<a href="mainpage_notice_1.html"><li> 학교 공사 공지</li></a>
			<a href="mainpage_notice_2.html"><li> 학교 휴관 안내사항</li></a>
			<a href="mainpage_notice_3.html"><li> 분실물 보관 안내</li></a>
			<a href="mainpage_notice_4.html"><li> 이번주 도서관 프로그램 소개</li></a>
			</ul>
			</td>
			<td width="600px" height="350px">
			<iframe width="600px" height="350px" src="./mainpage_calendar.html" frameborder=0 framespacing=0 marginheight=0 marginwidth=0 scrolling=no vspace=0></iframe>
			</td>
		</tr>
		<tr>
			<td width="600px" height="350px">추천 도서 <br><br>
				<a href="mainpage_recommend_book_1.jsp">
					<img src="./image/bImage_130830.png" width="100"/>
				</a>
				<a href="mainpage_recommend_book_2.jsp">
					<img src="./image/bImage_191118.png" width="100"/>
				</a>
			</td>
			<td width="600px" height="350px">도서관 위치 맵 <br>
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3148.940698093877!2d127.73555861555965!3d37.88506951357854!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3562e5e908acc65b%3A0x497ca251aa986ab6!2z7LaY7LKc7IucIOq1kOuPmSDtlZzrprzrjIDtlZnqtZAg7J287Iah6riw64WQ64-E7ISc6rSA!5e0!3m2!1sko!2skr!4v1676943230236!5m2!1sko!2skr" width="100%" height="100%" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
			</td>
		</tr>
	</table>
	
</body>

</html>