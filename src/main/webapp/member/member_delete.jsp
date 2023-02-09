<%@page import="java.sql.PreparedStatement"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
Connection conn=null;
String sql="DELETE FROM member WHERE id = ?";

try{
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:/comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	PreparedStatement stmt=conn.prepareStatement(sql);
	stmt.setString(1, request.getParameter("id"));
	stmt.executeUpdate();
	response.sendRedirect("member_list.jsp");
}catch(Exception e){
	out.println("<h3>삭제 실패...</h3>");
	e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>