<%@page import="net.member.db.MemberBean"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<%@ page import="java.util.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%
	MemberBean member = (MemberBean)request.getAttribute("member");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./MemberList.me">뒤로가기</a><br>
<table class = "table table-hover table-striped text-center">
<%
out.print("<tr><td>아이디</td>");
out.print("<td>"+member.getID()+"</td></tr>");

out.print("<tr><td>비밀번호</td>");
out.print("<td>"+member.getPW()+"</td></tr>");

out.print("<tr><td>이메일</td>");
out.print("<td>"+member.getEMAIL()+"</td></tr>");

out.print("<tr><td>이름</td>");
out.print("<td>"+member.getNAME()+"</td></tr>");

out.print("<tr><td>주소</td>");
out.print("<td>"+member.getADDR()+"</td></tr>");

out.print("<tr><td>주민번호</td>");
out.print("<td>"+member.getPIN()+"</td></tr>");

out.print("<tr><td>생년월일</td>");
out.print("<td>"+member.getYEAR()+"-"+member.getMONTH()+"-"+member.getDAY()+"</td></tr>");

out.print("<tr><td>취미</td>");
out.print("<td>"+member.getHOBBY()+"</td></tr>");

out.print("<tr><td>자기소개</td>");
out.print("<td>"+member.getINTRO()+"</td></tr>");
%>
</table>
</div>
</div>


</body>
</html>