<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=request.getAttribute("name") %>(으)로 로그인 하셨습니다.
<c:if test="${name == 'admin'}">
	<a href="MemberList.me">관리자 모드 접속(회원 목록 보기)</a>
</c:if>
</body>
</html>