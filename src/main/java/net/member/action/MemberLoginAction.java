package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberLoginAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		MemberDAO memberdao=new MemberDAO();
	   	MemberBean memberdata=new MemberBean();
	   	ActionForward forward=new ActionForward();
	   	
	   	boolean result=false;
	   	try {
	   		memberdata.setID(request.getParameter("id"));
	   		memberdata.setPW(request.getParameter("pw"));
	   		
	   		result = memberdao.memberLogin(memberdata);
	   		
	   		if(result == false) {
	   			System.out.println("Action : 로그인 실패");
	   			forward.setRedirect(false);
	   			forward.setPath("./member/main.jsp");
	   			return forward;
	   		}
	   		System.out.println("Action : 로그인 성공");
	   		session.setAttribute("id", memberdata.getID());
	   		String user = (String)session.getAttribute("id");

	   		if(user.equals("admin")) {
	   			forward.setRedirect(true);
		   		forward.setPath("./MemberList.me");
	   		} else {
	   			
	   			forward.setRedirect(true);
	   			forward.setPath("./BoardList.bo");	   			
	   		}
	   		return forward;
	   	}catch (Exception e) {
			System.out.println("로그인 세션 생성 실패");
			e.printStackTrace();
		}
	   	
		return null;
	}
	
}
