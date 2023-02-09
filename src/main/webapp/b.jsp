<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String t = request.getParameter("t"); %>
<%=t %>
<% %>
<%RequestDispatcher dispatcher = request.getRequestDispatcher("c.jsp");
dispatcher.forward(request, response);%>
</body>
</html>