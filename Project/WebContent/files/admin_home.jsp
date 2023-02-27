<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>관리자 홈 화면</title>
<link rel="stylesheet" href="admin_home_style.css"/>
</head>
<body>
<h1> 관리자 홈 화면</h1>
<section class="main">
<button type="button" onclick="location.href='admin_book.do'">
    도서관리
</button>
<button type="button" onclick="location.href='admin_client.do'">
    회원관리
</button>
</section>
</body>
</html>