package net.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet implements Servlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());

		ActionForward forward = null;
		Action action = null;

		// 로그인 화면
		if(command.equals("/main.me")) {
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./member/main.jsp");
		}
		
		// 회원가입 폼
		else if(command.equals("/joinForm.me")) {
			forward = new ActionForward();

			forward.setRedirect(false);
			forward.setPath("./member/joinForm.jsp");
		}
		
		
		
		// 회원가입 버튼
		else if(command.equals("/MemberJoin.me")) {
			action = new MemberJoinAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 로그인 클릭시
		else if(command.equals("/MemberLogin.me")) {
			action = new MemberLoginAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 로그인 성공 후 관리자로 회원목록 출력할 시
		else if(command.equals("/MemberList.me")) {
			action = new MemberListAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 회원 정보를 보고싶을 때 get 방식
		else if(command.equals("/MemberView.me")) {
			action = new MemberViewAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		// 회원 삭제
		else if(command.equals("/MemberDelete.me")) {
			action = new MemberDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	
		
		// Action -> controller -> View
		if(forward.isRedirect()){
			response.sendRedirect(forward.getPath());
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
			dispatcher.forward(request, response);
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}