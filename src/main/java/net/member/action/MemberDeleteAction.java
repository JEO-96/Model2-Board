package net.member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.member.db.MemberDAO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		MemberDAO memberdao = new MemberDAO();
		ActionForward forward = new ActionForward();
		
		boolean result = false;
		try {
			String id = (String)request.getParameter("id");
			
			result = memberdao.memberDelete(id);
			
			if(result == false) {
				System.out.println("삭제할 아이디가 없습니다.");
				return null;
			}
			System.out.println("삭제되었습니다.");
			forward.setRedirect(true);
			forward.setPath("./MemberList.me");
			return forward;
		} catch(Exception e) {
			System.out.println("유저 삭제 실패");
			e.printStackTrace();
		}
		return null;
	}
}
