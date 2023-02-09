package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.member.db.MemberBean;
import net.member.db.MemberDAO;

public class MemberViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		MemberDAO memberdao = new MemberDAO();
		MemberBean memberdata= new MemberBean();
		ActionForward forward = new ActionForward();
		
		try {
			memberdata.setID(request.getParameter("id"));
			
			MemberBean member = memberdao.memberInfo(memberdata);
			
			request.setAttribute("member", member);
			
			forward.setRedirect(false);
			forward.setPath("./member/member_info.jsp");
			return forward;
		} catch(Exception e) {
			System.out.println("INFO 실패");
			e.printStackTrace();
		}
		return null;
	}
}
