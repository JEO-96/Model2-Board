package net.member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberDAO;



public class MemberListAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		MemberDAO memberdao=new MemberDAO();
		List memberlist=new ArrayList();
		

		memberlist = memberdao.memberList();
		
		request.setAttribute("memberlist", memberlist);
		
		
		ActionForward forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("./member/member_list.jsp");
		return forward;
	}
}
