<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function clickLogin(){
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
}
</script>
</head>
<body>
<center>
<form method="post" action="./MemberLogin.me">
<table border="1">
	<tr>
		<th colspan="2">로그인 페이지</th>
	</tr>
	<tr>
		<td>아이디 :</td><td><input type="text" name="id" id="id"></td>
	</tr>
	<tr>
		<td>비밀번호 :</td><td><input type="password" name="pw" id="pw"></td>
	</tr>
	<tr>
		<td align="center"><input type="submit" value="로그인"></td>
		<td align="center"><a href="./joinForm.me">회원가입</a></td>
	</tr>
</center>
</table>
</form>
</body>
</html>