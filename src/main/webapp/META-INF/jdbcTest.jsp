<%@page import="javax.naming.Context"%>
<%@page import="javax.naming.InitialContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--sql import --%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*"%>

	Connection conn = null;
	
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/PostgresDB");
		conn = ds.getConnection();
		
		conn.close();
		
		out.println("<h3>연결되었습니다.</h3>");
	} catch(Exception e){
		out.println("<h3>연결에 실패했습니다.</h3>");
		e.printStackTrace();
	}

