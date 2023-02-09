<%@page import="net.member.db.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%
request.setCharacterEncoding("UTF-8");
String id = (String) session.getAttribute("id");
ArrayList<Object> memberlist = (ArrayList)request.getAttribute("memberlist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

<div align = "center">
<a href="./BoardList.bo">뒤로가기</a><br>
<h3>회원목록보기 </h3>
<div class="container my-3">
<div class="card align-middle" style="width: 30rem; border-radius: 20px;">
<div class="card-body">
<table>
<%
for(int i=0;i<memberlist.size();i++){
	MemberBean mb = (MemberBean)memberlist.get(i);
	if(!mb.getID().equals("admin")){
	out.print("<div class=\"d-flex justify-content-around\">");
	out.print("<div>"+"<a href=\"./MemberView.me?id="+mb.getID()+"\">"+mb.getID()+"</a>"+"</div>");
	out.print("<div>"+"<a href=\"./MemberDelete.me?id="+mb.getID()+"\">"+"삭제"+"</a>"+"</div>");
	out.print("</div>");
	}
}
%>
</table>
</body>
</html>


